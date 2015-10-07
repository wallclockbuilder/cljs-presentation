;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; multimethods
;; --=-=-=--=-=

;; Often when you  need some polymorphism and performance isn't an issue,
;; multimethods will suffice. Multimethods are functions that allow open
;; extension, but instead of limiting dispatch to type, dispatch is controlled
;; by whatever value the dispatch fn originally supplied to `defmulti` returns.


;; Here is the simplest multimethod you can write. It simply dispatches on
;; the value received.


(defmulti simple-multi identity)


;; Now we can define methods for particular values.

(defmethod simple-multi 1
  [value] "Dispatched on 1")

(simple-multi 1)


(defmethod simple-multi "foo"
  [value] "Dispatched on foo")


(simple-multi "foo")


;; However we haven't defined a case for "bar"
;; (Highlight and evaluate the `simple-multi` form below)
(comment
  (simple-multi "bar")
  )

;; Here is a function that takes a list. It dispatches on the first element
;; of the list!
;; Note that this example uses destructuring, which is covered later.


(defmulti parse (fn [[f & r :as form]] f))

(defmethod parse 'if
  [form] {:op :if})

(defmethod parse 'let
  [form] {:op :if})


(parse '(if a b c))
(parse '(let [x 1] x))
