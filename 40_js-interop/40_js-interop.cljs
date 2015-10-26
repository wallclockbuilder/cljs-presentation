;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial)

;; JavaScript Interop
;;====-=-=-=-=-=-=-=-=


;; Property Access
;; ---------------


(def a-date (js/Date.))


;; You can access properties with the `.-` property access syntax.


(.-getSeconds a-date)


;; Method Calls
;; ------------

;; Methods can be invoked with the `.` syntax.


(.getSeconds a-date)


;; The above desugars into the following.


(. a-date (getSeconds))


;; For example, you can write a `console.log` call like so.


(. js/console (log "Interop!"))



;; Primitive Array Operations
;; --------------------------


;; When writing performance sensitive code,
;; sometimes dealing with mutable arrays is unavoidable.
;; ClojureScript provides a variety of functions
;; for creating and manipulating JavaScript arrays.


;; You can make an array of specific size with `make-array`


(make-array 32)

;; You can access an element of an array with `aget`.


(aget #js [#js ["one" "two" "three"]] 0 1)


;; You can set the contents of an array with aset.


(def yucky-stuff #js [1 2 3])


(aset yucky-stuff 1 4)

yucky-stuff
