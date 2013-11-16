(defproject overload-demo "0.1.0-SNAPSHOT"
  :description "Demo of https://clojars.org/overload-middleware"
  :url "https://clojars.org/overload-middleware"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [overload-middleware "0.1.0"]]
  :plugins [[lein-ring "0.8.8"]]
  :ring {:handler overload-demo.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
