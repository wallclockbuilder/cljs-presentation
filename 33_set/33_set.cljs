;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial)


;; set!
;; ----

;; Sometimes you need to mutate existing JavaScript objects. For this you have `set!`.

(def c (.createElement js/document "canvas"))
(def ctxt (.getContext c "2d"))


;; Se can use property access with `set!` to change the fill color of a canvas rendering context.


(set! (.-fillColor ctxt) "#ffffff")
