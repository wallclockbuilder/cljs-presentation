;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; JavaScript data type literals
;; -==-=--=-=-=-=-=-==--=-=-=-==

;; You can construct a JavaScript array with the `array` function.

(def an-array (array 1 2 3))

;; Similarly, you can create simple JavaScript objects with `js-obj`.

(def an-object (js-obj "foo" "bar"))

;; But again you can save a few characters with `#js`.

(def another-object #js {"foo" "bar"})

;; Its important to note that `#js` is shallow, the contents of `#js` will be
;; ClojureScript data unless preceded by `#js`.

;; This is a mutable JavaScript object with an immutable ClojureScript vector
;; inside.

(def shallow #js {"foo" [ 1 2 3]})

