;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial)


;; Protocols
;; -=-=--==-


;; The clojureScript language is constructed on a rich set of protocols. The
;; same uniformity provided by ClojureScript collections can be extended to
;; your own types or even types that you do not control!

;; A lot of the uniform power we saw early was because the ClojureScript
;; collections are implemented in terms of protocols. Collections can be
;; coerced into sequences because they implement ISeqable. you can use `get`
;; on vectors and maps because they implement ILookup.


(get {:foo "bar"} :foo)
(get [:cat :bird :dog] 1)


;; Map destructuring actually desugars into `get` calls. That means if you extend
;; your type to ILookup it will also support map destructuring!
