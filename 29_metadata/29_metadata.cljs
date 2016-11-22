;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Metadata
;; -=-=-=-=-=


;; All of the ClojureScript standard collections support metadata. Metadata is a useful way to annotate data without affecting equality. The ClojureScript compiler uses this language feature to great effect.


;; You can add metadata to a ClojureScript collection with `with-meta`. The metadata must be a map.


(def plain-data [0 1 2 3 4 5 6 7 8 9])


(def decorated-data (with-meta plain-data {:url "http://github.com"}))


;; Metadata has no effect on equality.


(= plain-data decorated-data)


;; You can access metadata with `meta`.


(meta decorated-data)
