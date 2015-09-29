;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Control
;; -==-=--=

;; Inorder to write useful programs, we need to be able to express control flow. ClojureScript provides the usual control ocnstructs, however truth-y and false-y values are not the same as in JavaScript so its worth reviewing.

;; If
;; --

;; 0 is not a false-y value.

(if 0
  "Zero is not false-y"
  "Yuck")

;; Nor is the empty string.

(if ""
  "An empty string is not false-y"
  "Yuck")

;; the empty vector

(if []
  "An empty vector is not false-y"
  "Yuck")

;; the empty list

(if ()
  "An empty list is not false-y"
  "Yuck")

;; the empty map

(if {}
  "An empty map is not false-y"
  "Yuck")

;; the empty set

(if #{}
  "An empty set is not false-y"
  "Yuck")

;; and even the empty regexp

(if #""
  "An empty regexp is not false-y"
  "Yuck")

;; The only false-y values in ClojureScript are `nil` and `false`.

(if nil
  "Yuck"
  "`nil` is one of the two false-y values in ClojureScript.")

(if false
  "Yuck."
  "False is the other false-y value.")

;; `undefined` is not really a valid ClojureScript value and is generally coerced to `nil`.



