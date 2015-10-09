;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))


;; Destructuring
;; -=-=-=-=-=-==


;; In any serious ClojureScript program, there will be significant amounts of
;; data manipulation. Again, we will see that ClojureScripts's uniformity
;; pays off.

;; In ClojureScript anywhere bindings are allowed (like `let` or function
;; parameters), destructuring is allowed. This is similar to the destructuring
;; proposed for ES6, but the system provided in ClojureScript benefits from
;; all the collections supporting uniform access.



;; Sequence destructuring
;; =--=--=-=-=-=-=-=-=-=-


;; Destructuring sequential types is particularly useful.

(let [[f & r] '(1 2 3)]
  f)

(let [[f & r] '(1 2 3)]
  r)

(let [[r g b] [255 255 150]]
  g)


;; _ is just a convention for saying that you are not interested in the
;; item at the corresponding position. It has no other special meaning.
;; Here we're only interested in the third local varialbe named `b`.

(let [[_ b _] [255 255 150]]
  b)

;; destructuring function arguments works just as well. Here we are
;; only interested in the second argument `g`.

(defn green [[_ g _]]
  g)

(green [255 255 150])
