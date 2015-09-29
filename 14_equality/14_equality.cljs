;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Equality
;; -==--=-=

;; ClojureScript has a much simpler notion of equality that what is present in JavaScript. In ClojureScript equality is always deep equality.

(= {:one 1 :two "2"} {:two "2" :one 1})

;; Maps are not ordered.

(= {:one 1 :two "2"} {:two "2" :one 1})

;; For sequential collections, equality just works.

(= [1 2 3] '(1 2 3))

;; Again, it is possible to check whether two things are reqpresented by the same thing in memory with `identical`.

(def my-vec [1 2 3])
(def your-vec [1 2 3])

(identical? my-vec your-vec)
