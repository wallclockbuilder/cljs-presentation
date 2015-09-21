;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))

;; Definitions
;; -=-=-==-=-=--=

;; Once you have a namespace, you can start creating top level definitions in
;; that namespace.

;; You can define a top level with `def`.

(def x 1)

x

;; You can also refer to top level definitions by fully qualifying them.

lt-cljs-tutorial/x

;; This means top levels can never be shadowed by locals and function
;; parameters.

(let [x 2]
  lt-cljs-tutorial/x)

;; Once way to define a funciton is like this.

(def y (fn [] 1))

(y)

;; Defining functions in ClojureScript is common enough that `defn` sugar is
;; provided and idiomatic.

(defn z [] 1)

(z)


