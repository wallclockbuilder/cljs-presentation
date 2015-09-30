;; +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
;; An Introduction to ClojureScript for Light Table users
;; +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


;; Basics
;; ============================================================================

;; To begin, open the command pane (type Control-SPACE), Add Connection, select
;; Light Table UI. Once connected you can evaluate all the forms in this file
;; by placing the cursor after the form and typing Command-ENTER.

;; IMPORTANT: You must evaluate the very first form, the namespace
;; definition.

;; Declaring a namespaces
;; ----------------------------------------------------------------------------

;; ClojureScript supports modularity via namespaces. They allow you to group
;; logical definitions together.

(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))

;; :require is how you can import functionality from a different namespace into
;; the current one. Here we are requiring `clojure.string` and giving it an
;; alias. We could write the following:

(clojure.string/blank? "")

;; But that's really verbose compared to:

(string/blank? "")


;; Comments
;; ----------------------------------------------------------------------------

;; There are three ways to create comments in ClojureScript. The first way is
;; by preceding a line with a semi-colon, just like the lines you are reading
;; now.

;; The second way is by preceding a form with `#_`. This causes ClojureScript
;; to skip the evaluation of only the form immediately following, without
;; affecting the evaluation of the surrounding forms.

;; Try to reveal the secret message below:

(str "The secret word is " #_(string/reverse "tpircSerujolC"))

;; Finally, you can also create a comment using the `comment` macro. One common
;; technique is to use the `comment` macro to include code to be evaluated in a
;; REPL, but which you do not normally want to be included in the compiled
;; source.

;; For example, try placing your cursor after the last `)` below and type
;; Command-ENTER:

(comment

  (string/upper-case "This is only a test...")

  )

;; The `comment` macro makes the whole form return `nil`. Now go back and
;; highlight just the middle line, then type Command-ENTER. In this way
;; you can include code samples or quick tests in-line with the rest of
;; your code.


;; Definitions
;; ----------------------------------------------------------------------------

;; Once you have a namespace, you can start creating top level definitions in
;; that namespace.

;; You can define a top level with `def`.

(def x 1)

x

;; You can also refer to top level definitions by fully qualifying them.

lt-cljs-tutorial/x

;; This means top levels can never be shadowed by locals and function
;; parameters.

(let [x 2]
  lt-cljs-tutorial/x)

;; One way to define a function is like this.

(def y (fn [] 1))

(y)

;; Defining functions in ClojureScript is common enough that `defn` sugar is
;; provided and idiomatic.

(defn z [] 1)

(z)


;; Literal data types
;; ----------------------------------------------------------------------------

;; ClojureScript comes out of the box with the usual useful data literals.

;; Booleans

(def a-boolean true)

;; Strings

(def a-string "Hello!")

;; Regular Expressions

(def a-regexp #"\d{3}-?\d{3}-?\d{4}")

;; Numbers

(def a-number 1)


;; Function literals
;; ----------------------------------------------------------------------------

;; ClojureScript also supports a shorthand function literal which is useful
;; You can use the % and %N placeholders to represent function arguments.

;; You should not abuse the function literal notation as it degrades readability
;; outside of simple cases. It is nice for simple functional cases such as
;; the following. You could map over a ClojureScript vector like this:

(map (fn [n] (* n 2)) [1 2 3 4 5])

;; Or you can save typing a few characters like this:

(map #(* % 2) [1 2 3 4 5])


;; JavaScript data type literals
;; ----------------------------------------------------------------------------

;; You can construct a JavaScript array with the `array` function.

(def an-array (array 1 2 3))

;; But ClojureScript also supports JavaScript data literals via the `#js`
;; reader literal.

(def another-array #js [1 2 3])

;; Similarly, you can create simple JavaScript objects with `js-obj`.

(def an-object (js-obj "foo" "bar"))

;; But again you can save a few characters with `#js`.

(def another-object #js {"foo" "bar"})

;; It's important to note that `#js` is shallow, the contents of `#js` will be
;; ClojureScript data unless preceded by `#js`.

;; This is a mutable JavaScript object with an immutable ClojureScript vector
;; inside.

(def shallow #js {"foo" [1 2 3]})


;; Constructing a type
;; ----------------------------------------------------------------------------

;; Of course some JavaScript data types you will want to create with a
;; constructor.

;; (js/Date.) is equivalent to new Date().

(def a-date (js/Date.))

(def another-date #inst "2014-01-15")

;; Note the above returns an `#inst` data literal.

(def another-regexp (js/RegExp. "\\d{3}-?\\d{3}-?\\d{4}"))

;; Handy

;; NOTE: js/Foo is how you refer to global JavaScript entities of any kind.

js/Date

js/RegExp

js/requestAnimationFrame

;; If you're curious about other JavaScript interop jump to the bottom of this
;; tutorial.


;; ClojureScript data types
;; ============================================================================

;; Unless there is a good reason, you should generally write your ClojureScript
;; programs with ClojureScript data types. They have many advantages over
;; JavaScript data types - they present a uniform API and they are immutable.

;; Vectors
;; ----------------------------------------------------------------------------

;; Instead of arrays, ClojureScript programmers use persistent vectors. They are
;; like arrays - they support efficient random access, efficient update
;; and efficient addition to the end.

(def a-vector [1 2 3 4 5])

;; We can get the length of a vector in constant time via `count`.

(count a-vector)

;; We can add an element to the end.

(def another-vector (conj a-vector 6))

;; Note this does not mutate the array! `a-vector` will be left
;; unchanged.

a-vector

another-vector

;; Hallelujah! Here is where some ClojureScript magic
;; happens. `another-vector` appears to be a completely new vector
;; compared to `a-vector`. But it is not really so. Internally, the new
;; vector efficiently shares the `a-vector` structure. In this way, you
;; get the benefits of immutability without paying in performance.

;; We can access any element in a vector with `nth`. The following
;; will return the second element.

(nth a-vector 1)

(nth ["foo" "bar" "baz"] 1)

;; Or with `get`...

(get a-vector 0)

;; ...which allows you to return an alternate value when the index is
;; out-of bounds.

(get a-vector -1 :out-of-bounds)
(get a-vector (count a-vector) :out-of-bounds)

;; Surprisingly, vectors can be treated as functions. This is actually
;; a very useful property for associative data structures to have as
;; we'll see below with sets.

(a-vector 1)

(["foo" "bar" "baz"] 1)


;; Maps
;; ----------------------------------------------------------------------------

;; Along with vectors, maps are the most common data type in ClojureScript.
;; Map usage is analogous to the usage of Object in JavaScript, but
;; ClojureScript maps are immutable and considerably more flexible.

;; Let's define a simple map. Note `:foo` is a ClojureScript keyword.
;; ClojureScript programmers prefer to use keywords for keys instead
;; of strings. They are more distinguishable from the rest of the
;; code, more efficient than plain strings, and they can be used in
;; function position (i.e. first position after the open parens), as
;; we'll see in a moment.

(def a-map {:foo "bar" :baz "woz"})

;; We can get the number of key-value pairs in constant time.

(count a-map)

;; We can access a particular value for a key with `get`.

(get a-map :foo)

;; and return an alternative value when the key is not present

(get a-map :bar :not-found)

;; We can add a new key-value pair with `assoc`.

(def another-map (assoc a-map :noz "goz"))

;; Again a-map is unchanged! Same magic as before for vectors

a-map

another-map

;; We can remove a key-value pair with `dissoc`.

(dissoc a-map :foo)

;; Again a-map is unchanged!

a-map

;; Like vectors, maps can act like functions.

(a-map :foo)

;; However ClojureScript keywords themselves can act like functions and the
;; following is more idiomatic.

(:foo a-map)

;; We can check if a map contains a key, with `contains?`.

(contains? a-map :foo)

;; We can get all the keys in a map with `keys`.

(keys a-map)

;; And all of the values with `vals`.

(vals a-map)

;; We can put a lot of things in a map, even other maps
(def a-nested-map {:customer-id 1e6
                   :preferences {:nickname "Bob"
                                 :avatar "http://en.gravatar.com/userimage/0/0.jpg"}
                   :services {:alerts {:daily true}}})

;; and navigate its keys to get the nested value you're interested in

(get-in a-nested-map [:preferences :nickname])
(get-in a-nested-map [:services :alerts :daily])

;; or just find a top level key-value pair (i.e. MapEntry) by key

(find a-nested-map :customer-id)
(find a-nested-map :services)

;; There are many cool ways to create maps.

(zipmap [:foo :bar :baz] [1 2 3])

(hash-map :foo 1 :bar 2 :baz 3)

(apply hash-map [:foo 1 :bar 2 :baz 3])

(into {} [[:foo 1] [:bar 2] [:baz 3]])

;; Unlike JavaScript objects, ClojureScript maps support complex keys.

(def complex-map {[1 2] :one-two [3 4] :three-four})

(get complex-map [3 4])


;; Keyword digression
;; ----------------------------------------------------------------------------

;; Let's take a moment to digress about keywords as they are so ubiquitous
;; in ClojureScript code.

(identity :foo)

;; If you add an additional preceding colon you'll get a namespaced keyword.

(identity ::foo)

;; What good is this for? It allows you to put data into collections without
;; fear of namespace clashes without the tedium of manual namespacing them
;; in your source.

(identity {:user/foo ::foo})

;; Namespaced keywords are essential to Light Table's modularity.


;; Sets
;; ----------------------------------------------------------------------------

;; ClojureScript also supports sets.

(def a-set #{:cat :dog :bird})

;; `:cat` is already in `a-set`, so it will be unchanged.

(conj a-set :cat)

;; But `:zebra` isn't.

(conj a-set :zebra)

;; If you haven't guessed already, `conj` is a "polymorphic" function that adds
;; an item to a collection. This is some of the uniformity we alluded to
;; earlier.

;; `contains?` works on sets just like it does on maps.

(contains? a-set :cat)

;; Like vectors and maps, sets can also act as functions. If the argument
;; exists in the set it will be returned, otherwise the set will return nil.

(#{:cat :dog :bird} :cat)

;; This is powerful when combined with conditionals.

(defn check [x]
  (if (#{:cat :dog :bird} x)
    :valid
    :invalid))

(check :cat)
(check :zebra)


;; Lists
;; ----------------------------------------------------------------------------

;; A less common ClojureScript data structure is lists. This may be
;; surprising as ClojureScript is a Lisp, but maps, vectors and sets
;; are the 'go-to' data structures for most applications. Still, lists are sometimes
;; useful—especially when dealing with code (i.e. code is data).

(def a-list '(:foo :bar :baz))

;; `conj` is "polymorphic" on lists as well, and it's smart enough to
;; add the new item in the most efficient way on the basis of the
;; collection type.
(conj a-list :front)

;; and lists are immutable as well

a-list

;; You can get the first element of a list

(first a-list)

;; or the tail of a list

(rest a-list)

;; which allows you to easly verify how ClojureScript shares data
;; structure instead of inefficiently copying data for supporting
;; immutability.

(def another-list (conj a-list :front))

another-list

a-list

(identical? (rest another-list) a-list)

;; `identical?` checks whether two things are represented by the same
;; thing in memory.


;; Equality
;; ============================================================================

;; ClojureScript has a much simpler notion of equality than what is present
;; in JavaScript. In ClojureScript equality is always deep equality.

(= {:one 1 :two "2"} {:one 1 :two "2"})

;; Maps are not ordered.

(= {:one 1 :two "2"} {:two "2" :one 1})

;; For sequential collections, equality just works.

(= [1 2 3] '(1 2 3))

;; Again, it is possible to check whether two things are represented
;; by the same thing in memory with `identical?`.

(def my-vec [1 2 3])
(def your-vec [1 2 3])

(identical? my-vec your-vec)


;; Control
;; ============================================================================

;; In order to write useful programs, we need to be able to express
;; control flow. ClojureScript provides the usual control constructs,
;; however truth-y and false-y values are not the same as in
;; JavaScript so it's worth reviewing.

;; if
;; ----------------------------------------------------------------------------

;; 0 is not a false-y value.

(if 0
  "Zero is not false-y"
  "Yuck")

;; Nor is the empty string.

(if ""
  "An empty string is not false-y"
  "Yuck")

;; the empty vector

(if []
  "An empty vector is not false-y"
  "Yuck")

;; the empty list

(if ()
  "An empty list is not false-y"
  "Yuck")

;; the empty map

(if {}
  "An empty map is not false-y"
  "Yuck")

;; the empty set

(if #{}
  "An empty set is not false-y"
  "Yuck")

;; and even the empty regexp

(if #""
  "An empty regexp is not false-y"
  "Yuck")

;; The only false-y values in ClojureScript are `nil` and `false`. `undefined`
;; is not really a valid ClojureScript value and is generally coerced to `nil`.


;; cond
;; ----------------------------------------------------------------------------

;; Nesting `if` tends to be noisy and hard to read so ClojureScript
;; provides a `cond` macro to deal with this.

(cond
  nil "Not going to return this"
  false "Nope not going to return this either"
  :else "Default case")


;; loop/recur
;; ----------------------------------------------------------------------------

;; The most primitive looping construct in ClojureScript is `loop`/`recur`.
;; Like `let`, `loop` establishes bindings and allows you to set their initial values.
;; Like `let`, you may have a sequence of forms for the body. In tail
;; positions, you may write a `recur` statement that will set the bindings for
;; the next iteration of the `loop`. Using `loop`/`recur` is usually considered bad
;; style if a reasonable functional solution via `map`/`filter`/`reduce` or a list
;; comprehension is possible.

;; While you might write this in JavaScript:
;;
;; var ret = [];
;; for(var i = 0; i < 10; i++) ret.push(i)
;;
;; In ClojureScript you would write `loop`/`recur` like so:

(loop [i 0 ret []]
  (if (< i 10)
    (recur (inc i) (conj ret i))
    ret))

;; Again avoid `loop`/`recur` unless you really need it. The loop above would
;; be better expressed as the following:

(into [] (range 10))

;; More functions
;; ===============

;; Functions are the essence of any significant ClojureScript program, so
;; we will dive into features that are unique to ClojureScript functions that
;; might be unfamiliar.

;; Here is a simple function that takes two arguments adds them.

(defn foo1 [a b]
  (+ a b))

(foo1 1 2)
;; Functions can have multiple arities.

(defn foo2
  ([a b] (+ a b))
  ([a b c] (* a b c)))

(foo2 3 4)
(foo2 3 4 5)

;; Multiple arities can be used to supply default values.

(defn defaults
  ([x] (defaults x :default))
  ([x y] [x y]))

(defaults :explicit)
(defaults :explicit1 :explicit2)

;; Funcitons support rest arguments.

(defn foo3 [a b & d]
  [a b d])

(foo3 1 2)
(foo3 1 2 3 4)

;; You can apply functions.

(apply + [1 2 3 4 5])




































