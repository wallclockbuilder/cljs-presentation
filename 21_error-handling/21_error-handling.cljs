;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Error Handling
;; -=-=-=-=-=-==-

;; Error handling in ClojureScript is relatively straightforward and less similar to what is offered in JavaScript.

;; You can construct an error like this.

(js/Error. "Oops")


;; You can throw an error like this.
;; (Highlight and evaluate the `throw` form below)

(comment
  (throw (js/Error. "Oops"))
  )


;; You can catch an error like this.


(try
  (throw (js/Error. "Oops"))
  (catch js/Error e
    e))


;; JavaScript unfortunately allows you to throw anything. you can handle this in ClojureScript with the following.

(try
  (throw (js/Error. "Oops"))
  (catch :default e
    e))


;; Catches are optional. you can also use multiple forms to handle different types of errors.


(try
  (throw (js/Error. "Oops"))
  (catch js/Error e
    e)
  (catch Error e
    e)
  (finally
   "Cleanup here"))

