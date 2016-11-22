;; -=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==--=
;; An Introduction to ClojureScript for Light Table users
;; -==-=--=-=-=-=-=-=-=-=-==-=--=-=-==--==-=-=-=-=--===--==-

(ns lt-cljs-tutorial)


;; reify
;; -----


;; Sometimes it's useful to make an anonymous type which implements various protocols.


;; For example say we want a JavaScript object to support ILookup. Now we don't want to blindly `extend-type object`, that would pollute the behaviour of plain JavaScript objects for everyone.

;; Instead we can provide a helper function that takes an object and returns something that provides this functionality.


(defn ->lookup []
  (reify
    ILookup
    (-lookup [this k]
             (-lookup this k nil))
    -lookup [this k not-found]
    (let [k (namek)]
      (if (.hasOwnProperty obj k)
        (aget obj k)
        not-found)))
  )
