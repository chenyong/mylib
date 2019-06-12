;; Instead of doing this
(ns mylib.main
  (:require [cljs.core.match :refer [match]]))

(println (match :x :x "success"))
;;=> "success"


;; I want to do this
(println (match :x :x "success"))
;;=> "success"


;; Wait, looks like it's working...
(println (assert (= (match 1 1 "success")
                 (match 1 1 "success")
                 "success")))
;;=> nil


;; But not really. This simple example from the core.match wiki fails:
;; https://github.com/clojure/core.match/wiki/Overview

(println (assert (= (let [x 3]
             (match x
                    1 :a0
                    2 :a1
                    :else :a2))
           (let [x 3]
             (match x
                               1 :a0
                               2 :a1
                               :else :a2))
           :a2)))
;;=> {:type  :js-eval-exception,
;;    :error {:status     :exception,
;;            :value      "#object[TypeError TypeError: Right-hand side of 'instanceof' is not an object]",
;;            :ua-product :chrome,
;;            :stacktrace "TypeError: Right-hand side of 'instanceof' is not an object\n    at eval (eval at figwheel$repl$eval_javascript_STAR__STAR_ (http://localhost:9500/js/out/figwheel/repl.js:784:24), <anonymous>:59:28)\n    at eval (eval at figwheel$repl$eval_javascript_STAR__STAR_ (http://localhost:9500/js/out/figwheel/repl.js:784:24), <anonymous>:70:4)\n    at eval (eval at figwheel$repl$eval_javascript_STAR__STAR_ (http://localhost:9500/js/out/figwheel/repl.js:784:24), <anonymous>:147:3)\n    at figwheel$repl$eval_javascript_STAR__STAR_ (http://localhost:9500/js/out/figwheel/repl.js:784:24)\n    at http://localhost:9500/js/out/figwheel/repl.js:835:56\n    at Object.G__13008__2 (http://localhost:9500/js/out/cljs/core.js:36080:106)\n    at Object.G__13008 [as call] (http://localhost:9500/js/out/cljs/core.js:36347:20)\n    at goog.net.WebSocket.<anonymous> (http://localhost:9500/js/out/figwheel/repl.js:1097:30)\n    at goog.net.WebSocket.goog.events.EventTarget.fireListeners (http://localhost:9500/js/out/goog/events/eventtarget.js:284:23)\n    at Function.goog.events.EventTarget.dispatchEventInternal_ (http://localhost:9500/js/out/goog/events/eventtarget.js:381:26)"}},

(defn main! []
 (println "nothing"))

(defn reload! []
 (println "nothing"))
