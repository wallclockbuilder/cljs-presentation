;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Map destructuring
;;-------------------

;; Map destructuring is also useful. Here we destructure the value for the
;; `:foo` key and bind ti to a local `f`, and the value for `:baz` key
;; and bind it to a local `b`.

(let [{f :foo b :baz} {:foo "bar" :baz "woz"}]
  [f b])

;; If we don't want to rename, we can just use `:keys`.

(let [{:keys [first last]} {:first "Bob" :last "Smith"}]
  [first last])

;; We can also destructure a nested map.


(let [{:keys [first last] {:keys [addr1 addr2]} :address} {:first "Bob" :last "Smith" :address {:addr1 "123" :addr2 "Main street"}}]
  [first last addr1 addr2])


;; Similar to :keys for keyword, :strs and :syms directies are available for matching string and symbol :keys.


(let [{:syms [first last]} {'first "Bob" 'last "Smith"}]
  [first last])


(let [{:strs [first last]} {"first" "Bob" "last" "Smith"}]
  [first last])


;; The above map destructuring form is very useful when you need to
;; define a function with optional, non positional and defaulted
;; arguments.

(defn magic [& {:keys [k g h]
                :or {k 1
                     g 2
                     h 3}}]
  (hash-map :k k
            :g g
            :h h))


(magic)
(magic :k 10)
(magic :g 100)
(magic :h 1000)
(magic :k 10 :g 100 :h 1000)
(magic :h 1000 :k 10 :g 100)
