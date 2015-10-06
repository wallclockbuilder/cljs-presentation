;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Seqable collections
;; -------------------


;; Most ClojureScript collections can be coerced into sequences.


(seq {:foo "bar" :baz "woz"})
(seq #{:cat :dog :bird})
(seq [1 2 3 4 5])
(seq '(1 2 3 4 5))


;; Many ClojureScript functions will call `seq` on their arguments in order to
;; provide the expected behavior. The following demonstrates that you can
;; uniformly iterate over all the ClojureScript collections!

(first {:foo "baz" :baz "woz"})
(rest {:foo "bar" :baz "woz"})


(first #{:cat :dog :bird})
(rest #{:cat :dog :bird})


(first [1 2 3 4 5])
(rest [1 2 3 4 5])
