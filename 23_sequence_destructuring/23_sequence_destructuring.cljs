;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Sequence destructuring
;; ----------------------


;; Destructuring sequential types is particularly useful.

(let [[f & r] '(1 2 3)]
  f)


(let [[f & r] '(1 2 3)]
  r)


(let [[r g b] [255 255 150]]
  g)


;; _ is just a convention for saying that you are not intrested in the
;; item at the corresponding position. It has no other special meaning.
;; Here we're only interested in the third local variable named 'b'.


(let [[_ _ b] [255 255 150]]
  b)


;; destructuring function arguments works just as well. Here we are
;; only interested in the second argument `g`.

(defn green [[_ g _]] g)

(green [255 255 150])
