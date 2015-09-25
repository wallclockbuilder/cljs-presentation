;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))



;; Vectors
;; -==-=--

;; Instead of arrays, ClojureScript programmers use persistent vectors. They are
;; like arrays - they support efficient random access, efficient update
;; and efficient addition to the end.

(def a-vector [1 2 3 4 5])

;; We can get the length of a vector in constant time via `count`.

(count a-vector)

;; We can add an element to the end.

(def another-vector (conj a-vector 6))

;; Note this does not mutate the array! `a-vector` will be left
;; unchanged.

a-vector

another-vector

;; Hallelujah! Here is where some ClojureScript magic
;; happens. `another-vector` appears to be a a completely new vector
;; compared to `a-vector`. But it is not really so. Internally, the new
;; vector efficiently shares the `a-vectore` structure. In this way, you
;; get the benefits of immutability without paying in performance.

;; We can access any element in a vector with `nth`. The following
;; will return the second element.

(nth a-vector 1)

(nth ["foo" "bar" "baz"] 1)

;; Or with `get` ...

(get a-vector 0)

;; ... which allows you to return to an alternate value when the index
;; is out of bounds.

(get a-vector -1 :out-of-bounds)
(get a-vector (count a-vector) :out-of-bounds)

;; Surprisingly, vectors can be treated as functions. This is actually
;; a very useful property for associative data structures to have as
;; we'll see later with sets.

(a-vector 1)

(["foo" "bar" "baz"] 1)
