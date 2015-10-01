;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; cond
;; --=-

;; Nesting `if` tends to be noisy and hard to read so ClojureScript
;; provides a `cond` macro to deal with this.

(cond
 nil "Not going to return this"
 false "Nope not going to return this either"
 :else "Default case")
