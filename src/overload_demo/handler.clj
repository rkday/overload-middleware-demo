(ns overload-demo.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [overload-middleware.middleware :refer [wrap-overload]]))

(defroutes subsidiary-routes
  (GET "/sub1" [] (do
         (Thread/sleep 30)
         "Hi World")))


(defroutes app-routes
  (GET "/unwrapped" []
       (do
         (Thread/sleep 30)
         "Hello World"))

  (wrap-overload (GET "/wrapped" []
                      (do
                        (Thread/sleep 30)
                        "Hello World"))
                 {:target-latency 50})

  ;; If you have a set of routes with shared overload characteristics
  ;; (e.g. they all use the same database), you can group their
  ;; overload control like this.
  (wrap-overload subsidiary-routes {:target-latency 150})
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
