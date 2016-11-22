;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial)


;; swap!
;; -----


;; If you want to change the value of an atom on the basis of its current value,
;; you can use `swap!`. In its simplest form, `swap!` accepts as a first argument
;; the atom itself and as a second rgument an updating function of one argument
;; which will be instantiated with the current value of the atom. `swap!` returns
;; the new value of the atom.


(swap! x inc)


x


@x


;; If your updating function needs extra arguments to calculate the new value, you
;; have to pass them as extra arguments to `swap!` after the updating function
;; itself.

(swap! x (fn [old extra-arg]
           (+ old extra-arg)) 39)


x


@x


;; As usual when anonymous functions are simple enough, it's idiomatic to use
;; the condensed form.


(swap! x #(- %1 %2) 42)


x


@x


;; Note that the updating function has to be free of side-effects because a
;; waiting writer could call it more than once in a spin loop.
