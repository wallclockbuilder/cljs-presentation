;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Mutation
;; -=-=-=-=

;; Atoms
;; -----

;; A little bit of mutability goes a long way. ClojureScript does not offer any traditional mutable data structures, however it does support identities that an evolve over time via `atom`.


(def x (atom 1))


;; You can dereference the value of an atom with `@`.


@x


;; This is equivalent to calling `deref`.


(deref x)


;; If you want to change the value of an atom you can use `reset!` which returns the new value. It's idiomatic to add the bang char `!` at the end of function names mutating objects.


(reset! x 2)


x


@x
