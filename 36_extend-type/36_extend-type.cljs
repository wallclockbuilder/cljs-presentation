;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial)


;; extend-type
;; -=-=-=-=-=-=

;; ClojureScript supports custom extension to types that avoid many of the pitfals that you encounter in other languages. For example imagine we have some awesome polymorphic functionality in mind.


(defprotocol MyProtocol (awesome [this]))


;; It's idiomatic to name the first argument of a protocol's functions as `this` which reminds you that it is the argument used by ClojureScript to dispatch the right function implementation on the basis of the type of the value of `this`.

;; Now imagine we want JavaScript strings to participate . We can do this simply.

(extend-type string
  MyProtocol
  (awesome [this] (vector this "Totally awesome!")))

(awesome "Is this awesome?")
