# cljs-presentation
Basic ClojureScript via a hands-on approach

# [Comments](https://github.com/wallclockbuilder/cljs-presentation/blob/master/2_comments/2_comments.cljs)

;; There are three ways to create comments in ClojureScript. The first way is by preceding a line with a semi-colon, just like you are reading now.

The second way is by preceding a form with `#_`. This causes ClojureScript to skip the evaluation of only the form immediately following, without affecting the evaluation of the surrounding forms.

Try to reveal the secret message below.

```clojure
  (str "The secret word is " #_(string/reverse "tpircSerujolC"))
```

Finally, you can also create a comment using the `comment` macro. One common technique is to use the `comment` macro to include code to be evaluated in a REPL, but which you do not normally want to be included in the compiled source.

For example, try placing your cursor after the last `)` below and type Command-ENTER
```clojure
(comment

  (string/upper-case "This is only a test...")

)
```

The `comment` macro makes the whole form return `nil`. Now go back and highlight just the middle line, then type Command-ENTER. In this way you can include code samples or quick tests in-line with the rest of your code.



##[NEXT---->](https://github.com/wallclockbuilder/cljs-presentation/blob/master/3_defs)
