;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; List comprehensions
;; =--=-=-=-=-=-=-=-=-=

;; ClojureScript supports the list comprehensions you might know from various
;; languages. List comprehensions are sometimes more natural or more readable
;; than a chain of `map` and `filter` operations.


(for [x (range 1 10)
      y (range 1 10)]
  [x y])
(for [x (range 1 10)
      y (range 1 10)
      :when (and (zero? (rem x y))
                 (even? (quot x y)))]
  [x y])


(for [x (range 1 10)
      y (range 1 10)
      :let [prod (* x y)]]
  [x y prod])

