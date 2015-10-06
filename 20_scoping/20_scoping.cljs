;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Scoping
;; -=-=-=-

;; Unlike JavaScript, there is no hoisting in ClojureScript. ClojureScript
;; has lexical scoping.


(def some-x 1)


(let [some-x 2]
  some-x)


some-x
