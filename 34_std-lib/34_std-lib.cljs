;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial)


;; The ClojureScript Standard Library
;; -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

;; The ClojureScript standard library largely mirrors the Clojure standard library with the exception of functionality that assumes a multithreaded environment, first class namespaces, and Java numerics.


;; Here are some highlights and patterns that newcomers to ClojureScript might find useful. Remember you can type ControlShift-D at anytime to bring up the documentation panel to see what any of these functions do.


(apply str (interpose ", " ["Bob" "Mary" "George"]))


((juxt :first :last) {:last "Smith" :first "Bob"})


(def people [{:first "John" :last "McCarthy"}
             {:first "Alan" :last "Kay"}
             {:first "Joseph" :last "Licklider"}
             {:first "Robin" :last "Milner"}])


(map :first people)


(take 5000 (repeat "red"))


(take 5 (repeat "blue"))


(take 5 (interleave (repeat "red") (repeat "blue")))


(take 10 (cycle ["red" "white" "blue"]))


(partition 2 [:a 1 :b 2 :c 3 :d 4 :e 5])


(partition 2 1 [:a 1 :b 2 :c 3 :d 4 :e 5])


(take-while #(< % 5) (range 10))


(drop-while #(< % 5) (range 10))
