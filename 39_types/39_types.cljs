;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


(defprotocol MyProtocol (awesome [this]))


;; Types and Records
;; -=-=-=-=-=-=-=-==-

;; deftype
;; -------

;; Sometimes a map will simply not suffice, in these cases you will want to make your own custom type.


(deftype Foo [a b])


;; It's idiomatic to use CamelCase to name a `deftype`. You can instantiate a deftype instance using the same constructor pattern we've already discussed.


(Foo. 1 2)


;; You can implement protocol methods on a deftype.
;; Note that the first argument to any deftype or
;; defrecord method is the instance itself.
;; The dash in `_count` has no  special meaning.
;; It's just a convention for the core ClojureScript protocols. You need not adopt it.


(deftype Foo [a b]
  ICounted
  (-count [this] 2))


(count (Foo. 1 2))


;; Sometimes it's useful to implement methods directly on the deftype.


(deftype Foo [a b]
  Object
  (toString [this] (str a ", " b)))

(.toString (Foo. 1 2))

;; deftype fields are immutable unless specified.
;; The following will not compile. (To prove it to yourself, highlight and evaluate the `deftype` form below.)


(comment


  (deftype Foo [a ^:mutable b]
    Object
    (setA [this val] (set! a val)))


  ;; The folowing will compile.


  (deftype Foo [a ^:mutable b]
    Object
    (setB [this val] (set! b val)))

  )


;; defrecord
;; ---------


;; `deftype` doesn't provide much out of the box.
;; Often what you want to do is have a domain object
;; act more or less like a map.
;; This is what `defrecord` is for.


;; Like `deftype`, it's idiomatic to use CamelCase
;; to name a `defrecord`.


(defrecord Person [first last])


;; You can construct an instance in the usual way.


(Person. "Bob" "Smith")


;; Or you can use the provided constructors.


(->Person "Bob" "Smith")


(map->Person {:first "Bob" :last "Smith"})


;; It's considered idiomatic (and recommended)
;; to define a factory function which returns
;; the created instance of a defrecord/deftype.
;; It's idiomatic to use dash-case for factories
;; names.


(defn person [first last]
  (->Person first last))


;; records work like maps


(seq (person "Bob" "Smith"))


(:first (person "Bob" "Smith"))


(keys (person "Bob" "Smith"))


(vals (person "Bob" "Smith"))


;; both deftype and defrecord are open to dynamic extensions (i.e. open class)


(keys (assoc (person "Bob" "Smith") :age 18))


;; Records & Protocols
;; -------------------

;; You can extend a defrecord to satisfy a protocol as you do with deftype.


(extend-type Person
  MyProtocol
  (awesome [this]
           (str (:last this) ", " (:first this))))


(awesome (person "Bob" "Smith"))

(satisfies? MyProtocol (person "Bob" "Smith"))

;; Or you can extend a protocol on a defrecord.


(extend-protocol MyProtocol
  Person
  (awesome [this]
           (str (:last this) ", " (:first this))))


(awesome (person "Bob" "Smith"))

;; If you need a more sophisticated form of polymorphism consider multimethods.


;; If you mix types/ records with protocolsyou are modeling your problem with an object oriented approach, which is sometimes useful.


;; Note ClojureScript does not offer a direct form of inheritance. Instead,
;; reuse/extension by composition is encouraged. Its best to avoid deftype/defrecord and model your problem with plain maps. You can easily
;; switch to records later on down the line.

(defrecord Contact [person email])


;; Even if it's not required, remember to define a factory function to create
;; instances of the new Contact recored type by internally calling the factory
;; function for the Person record type.


(defn contact [first last email]
  (->Contact (person first last) email))


(contact "Bob" "Smith" "bob.smith@acme.com")

;; And extend the protocol on defrecord as well.


(extend-protocol MyProtocol
  Contact
  (awesome [this]
          (str (awesome (:person this)) ", " (:email this))))


;; To change the value of a nested key you use 'assoc-in', like with maps.


(assoc-in (contact "Bob" "Smith" "bob.smith@acme.com")
          [:person :first] "Robert")


;; If you need to use the previous value of a nested field for calculating the new one, you cna use 'update-in', like with maps.


(update-in (contact "Bob" "Smith" "bob.smith@acme.com")
           [:person :first] #(string/replace %1 #"Bob" %2) "Robert")


;; As said, the main difference with the majority of OO languages is that your
;; instances of deftypes/defrecords are immutable.


(def bob (contact "Bob" "Smith" "bob.smith@acme.com"))


(update-in bob [:person :first] #(string/replace %1 #"Bob" %2) "Robert")


(get-in bob [:person :first])
