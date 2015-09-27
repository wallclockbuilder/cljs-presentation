;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))



;; Keyword digression
;; -==-=-=-=--=-=-=-=-=

;; Let's take a moment to digress about keywords as they are so ubiquitous
;; in ClojureScript code.

(identity :foo)

;; If you add an additional preceding colon you'll get a namespaced keyword.

(identity ::foo)

;; What good is this for? It allows you to put data into collections without
;; fear of namespace clashes without the tedium of manually namespacing them
;; in your source.

(identity {:user/foo ::foo})

;; Namespaced keywords are essential to Light Table's modularity.

