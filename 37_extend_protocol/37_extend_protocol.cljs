;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial)



;; extend-protocol
;; ---------------

(defprotocol MyProtocol (awesome [this]))


(extend-type string
  MyProtocol
  (awesome [this] (vector this "Totally awesome!")))

;; Sometimes you want to extend several types to a protocol at once. you can use extend-protocol forthis. extend-protocol simply desugars into multiple extend-type forms.

;; As said while learning about `let` special form, when we're not interested in the value of an argument it's idiomatic to use the underscore as a placeholder like above.

(extend-protocol MyProtocol
  js/Date
  (awesome [_] "Having an awesome time!")
  number
  (awesome [_] "I'm an awesome number!"))


(awesome #inst "2014")
(awesome 5)
