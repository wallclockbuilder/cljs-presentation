;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Function literals
;; -=-=-=-==--=-=-=-=

;; ClojureScript also supports a shorthand function literal which is useful.
;; You can use the % %N placeholders to represent function arguments.

;; You should not abouse4 the function leteral notation as it degrades readability
;; outside of siimple cases. It is nice for simple funcitonal casese such as
;; the following. You could map over aa ClojureScript vector like this:

(map (fn [n] (* n 2)) [1 2 3 4 5])

;; Or you can save typing a few characters like this:

(map #(* % 2) [1 2 3 4 5])

