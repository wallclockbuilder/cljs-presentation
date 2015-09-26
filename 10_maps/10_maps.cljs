;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))



;; Maps
;; -=-=

;; Along with vectors, maps are the most common data type in ClojureScript.
;; Map usage is analogous to the usage Object in JavaScript, but
;; ClojureScript maps are immutalbe and considerably more flexible.

;; Let's define a simple map.

(def a-map {:foo "bar" :baz "woz"})

;; Note `:foo` is a ClojureScript keyword.
;; ClojureScript programmers prefer to use keywords for keys instead
;; of strings. They are more distinguishable from the rest of the
;; code, more efficient than plain strings, and they can be used in
;; function postion (i.e. first position after the open parens), as
;; we'll see in a moment.

;; We can get the number of key-value pairs in constant time.

(count a-map)

;; We can access a particular value ofr a key with `get`.

(get a-map :foo)

;; and return an alternative value when the key is not present.

(get a-map :bar :not-found)

;; We can add a new key-value pair with `assoc`.

(def another-map (assoc a-map :noz "goz"))

;; Again a-map is unchanged! Same magic as before for vectors.

a-map

another-map

;; We can remove a key-value pair with `dissoc`.

(dissoc a-map :foo)

;; Again a-map is unchanged!

a-map

;; Like vectors, maps can act like functions.

(a-map :foo)

;; However ClojureScript keywords themselves can act like functions and the
;; following is more idiomatic.

(:foo a-map)

;; We can get all the keys in a map with `keys`.

(keys a-map)

;; And all of the values with `vals`.

(vals a-map)

;; We can put a lot of things in a map, even other maps
(def a-nested-map {:customer-id 1e6
                   :preferences {:nickname "Bob"
                                 :avatar "http://en.gravatar.com/userimage/0/0.jpg"}
                   :services {:alerts {:daily true}}})

;; and navigate its keys to get the nested value you're interested in

(find a-nested-map :customer-id)
(find a-nested-map :services)

;; There are many cool ways to create maps.

(zipmap [:foo :bar :baz] [ 1 2 3])

(hash-map :foo 1 :bar 2 :baz 3)

(apply hash-map [:foo 1 :bar 2 :baz 3])

(into {} [[:foo 1] [:bar 2] [:baz 3]])

;; Unlike JavaScript objects, ClojureScript maps support complex keys.

(def complex-map {[1 2] :one-two [3 4] :three-four})

(get complex-map [3 4])

