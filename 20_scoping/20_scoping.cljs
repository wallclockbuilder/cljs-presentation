;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Scoping
;; -=-=-=-

;; Unlike JavaScript, there is no hoisting in ClojureScript. ClojureScript
;; has lexical scoping.


(def some-x 1)


(let [some-x 2]
  some-x)


some-x


;; Closures
;; --------

;; Could a language with such a name miss closures? Surely it can't.
;; You may be already familiar with them in JavaScript, even if it's a
;; variable scoped language.


(let [a 1e3]
  (defn foo []
    (* a a))
  (defn bar []
    (+ (foo) a)))


;; Above we defined `foo` and `bar` functions inside the scope of a
;; `let` form and they both know about `a` (i.e. they close over `a`)
;; Note, even if defined inside a `let`, `foo` and `bar` are available
;; in the outer scope. This is because all `def` expressions are always
;; top level. See the footnote at the end of this section.


(foo)
(bar)


;; And nobody else.

(comment
  (defn baz []
    (type a))
  (baz)
  )

;; That's why some people say that closures are the poor man's objects.
;; They encapsulate the information as well.

;; But in ClojureScript, functions' parameters and let bindings' locals
;; are not mutable! That goes for loop locals too!


(let [fns (loop [i 0 ret []]
      (if (< i 10)
        (recur (inc i) (conj ret (fn [] i)))
        ret))]
  (map #(%) fns))


;; In JavaScript you would see a list of ten 9s. In ClojureScript we
;; see the expected numbers from 0 to 9.

;; FOOTNOTE:
;;
;; `def` expressions (including `defn`) are always top level. People familiar
;; with Scheme or other Lisps often mistakenly write the following in Clojure:


(defn not-scheme []
  (defn no-no-no []))

;; This is almost always incorrect. If you need to write a local function
;; just do it with a let binding.


(defn outer-fn []
  (let [inner-fn (fn [])]))
