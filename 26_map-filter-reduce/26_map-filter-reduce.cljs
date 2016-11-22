;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Map / Filter  / Reduce
;;=----=----------------=


;; ClojureScript supports the same bells and whistles out of the box that you may
;; be familiar with from other functional programming language or JavaScript
;; libraries such as Underscore.js


(map inc [0 1 2 3 4 5 6 7 8 9])

(filter even? (range 10))

(remove odd? (range 10))

;; ClojureScript's `map` and `filter` operations are lazy. you can stack up operations without getting too concerned about  multiple traversals.


(map #(* % %) (filter even? (range 20)))


(reduce + (range 100))
