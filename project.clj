(defproject vyrlynd "0.1.0-SNAPSHOT"
  :description "Vyrlynd : A Component Entity System library for ClojureScript game development."
  :url "http://example.com/FIXME"

  :source-paths ["src"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2202"]
                 [speclj "3.0.2"]
                 [compojure "1.1.5"]]

  ;; lein-cljsbuild plugin to build a CLJS project
  :plugins [
            ;; cljsbuild plugin
            [lein-cljsbuild "1.0.3"]

            ;; speclj
            [speclj "3.0.2"]]

  ;; cljsbuild options configuration
  :cljsbuild {

              :test-commands
              ; Test command for running the unit tests in "test-cljs" (see below).
              ;     $ lein cljsbuild test
              {"dev" ["phantomjs"
                      "bin/phantom/spec-runner.js"
                      "bin/phantom/spec-runner.html"]}


              :builds {
                       :final {;; CLJS source code path
                               :source-paths ["src"]

                               ;; Google Closure (CLS) options configuration
                               :compiler {;; CLS generated JS script filename
                                          :output-to "target/vyrlynd.js"

                                          ; See http://lukevanderhart.com/2011/09/30/using-javascript-and-clojurescript.html for why advanced optimization doesn't work.

                                          ;; minimal JS optimization directive
                                          :optimizations :whitespace

                                          ;; generated JS code prettyfication
                                          :pretty-print true}
                               }

                       ; This build is for the ClojureScript specljs that will
                       ; be run via PhantomJS.  See the bin/phantom/spec-runner.js file
                       ; for details on how it's run.
                       :dev {
                             :source-paths ["src" "spec"]
                             :compiler {:output-dir "target"
                                        :output-to "target/vyrlynd.js"
                                        :source-map "target/vyrlynd.js.map"
                                        :optimizations :whitespace
                                        :pretty-print true}
                             :notify-command ["phantomjs"
                                              "bin/phantom/spec-runner.js"
                                              "bin/phantom/spec-runner.html"]
                             }
                       }})
