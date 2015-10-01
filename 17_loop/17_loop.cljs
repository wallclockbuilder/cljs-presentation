;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; loop/recur
;; -=-==--==-

;; The most primitive looping construct in ClojureScript is `loop`/`recur`.
;; Like `let`, `loop` established bindings and allows you to set their initial values.
;; Like `let`, you may have  a sequence of forms for the body. In tail
;; positions, you may write a `recur` statement that will set the bindings for
;; the next iteration of the `loop`. Using `loop`/`recur` is uaually considered bad
;; style if a reasonable functional solution via `map`/`filter`/`reduce` or a list
;; comprehension is possible.


;; While you might write this in JavaScript:
;;
;; var ret = [];
;; for(var i = 0; i < 10; i++) ret.push(i)
;;
;; In ClojureScript you would write `loop`/`recur` like so:

(loop [i 0 ret []]
  (if (< i 10)
    (recur (inc i) (conj ret i))
    ret))

;; Again avoid `loop`/`recur` unless you really need it. The loop above would
;; be better expressed as the following:

(into [] (range 10))
