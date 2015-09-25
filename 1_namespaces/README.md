# cljs-presentation
Basic ClojureScript via a hands-on approach

# [Declaring namespaces](https://github.com/wallclockbuilder/cljs-presentation/blob/master/1_namespaces/1_namespaces.cljs)


ClojureScript supports modularity via namespaces. They allow you to group logical definitions together.

```clojure
(ns lt-cljs-tutorial
  (:require [clojure.string :as string]))
```

`:require` is how you can import functionality from a different namespace into
the current one.  Here we are requiring `clojure.string` and giving it an
alias. We could write the following:

```clojure
  (clojure.string/blank? "")
```
but thats really verbose compared to:

```clojure
  (string/blank? "")
```
[NEXT---->](https://github.com/wallclockbuilder/cljs-presentation/blob/master/2_comments)
