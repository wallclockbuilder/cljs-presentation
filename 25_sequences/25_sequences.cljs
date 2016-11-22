;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; seqquences
;; -=-=--=--=-

;; We said that ClojureScript data structures are to be preferred as they
;; provide a uniform interface. All ClojureScript collections satisfy
;; the Iseqable protocol, which means iteration is uniform
;; (i.e. polymorphic) for all collection types.

