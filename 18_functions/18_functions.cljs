;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; More Functions
;; -=-=-=-=-=-==

;; Functions are the essence of any significant ClojureScript program, so we will dive into features that are unique to ClojureScript functionis that might be unfamiliar.

;; Here is a simple function that takes two arguments and adds them.

(defn foo1 [a b]
  (+ a b))

(foo1 1 2)

;; Functions can have multiple arities

(defn foo2
  ([a b] (+ a b))
  ([a b c] (* a b c)))

(foo2 3 4)
(foo2 3 4 5)

;; Multiple arities can be used to supply default values.

(defn defaults
  ([x] (defaults x :default))
  ([x y] [x y]))

(defaults :explicit)
(defaults :explicit1 :explicit2)

;; Functions support rest arguments.

(defn foo3 [a b & d]
  [a b d])

(foo3 1 2)
(foo3 1 2 3 4)

;; You can apply functions.

(apply + [1 2 3 4 5])
