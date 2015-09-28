;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Lists
;; -=-=-=

;; A let common ClojureScript data structure is lists. This may be surprising as CLojureScript is a Lisp, but maps, vectors and sets are the 'go-to' data structures for most applications. Still, lists are sometimes useful-especially when dealing with code (i.e. code is data).

(def a-list '(:foo :bar :baz))

;; `conj` is "polymorphic" on lists as well, and it's smart enough to add the new item in the most efficient way on the basis of the collection type.

(conj a-list :front)

;; and lists are immutable as well

a-list

;; You can get the first element of a list

(first a-list)

;; ore the tail of a list

(rest a-list)

;; which allows you to easily verify how ClojureScript shares data structure instead of inefficiently copying data for supporting immutability.

(def another-list (conj a-list :front))

another-list

a-list

(identical? (rest another-list) :front)

;; `identical?` checks whether two things are represented by the same thing in memory.
