;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-


;; Basic
;; -==-=-=-=--=-=-=-=-=-=--=-=-==-=-=--==--=-=-=-=-=-=-=-==-

;; To begin, open the command pane (type Control-SPACE), Add Connection, select
;; Light Table UI. Once connected you can evaluate all the forms in this file
;; by placing the cursor after the form and typing Command-ENTER.

;; IMPORTANT: You must evaluate the very first form, the namespace definition.

;; Declaring namespaces
;; -=-==--=-=-=-=-=-==--==--=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

;; ClojureScript supports modularity via namespaces. They allow you to group
;; logical definitions together.

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))

;; :require is how you can import functionality from a different namespace into
;; the current one. Here we are requiring `clojure.string` and giving it an
;;alias. We could write the following:

(clojure.string/blank? "")

;; but thats really verbose compared to:

(string/blank? "")

