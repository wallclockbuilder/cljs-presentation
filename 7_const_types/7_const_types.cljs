;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))



;; Constructing a type
;; -=-==--=-=-=--=---=-

;; Of course some JavaScript data types you will want to create with a
;; constructor.


;; (js/Date) is equivalent to new Date().

(def a-date (js/Date.))

(def another-date #inst "2014-01-15")

;; Note the above returns an `#inst` data literal.

(def another-regexp (js/RegExp. "\\d{3}-?\\d{3}-?\\d{4}"))

;; Handy

;; NOTE: js/Foo is how you refer to global JavaScript entities of any kind.

js/Date

js/RegExp

js/requestAnimationFrame

;; If you're curious about other JavaScript interop jump to the bottom of this tutorial.
