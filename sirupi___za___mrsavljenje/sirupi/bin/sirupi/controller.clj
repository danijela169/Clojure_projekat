(ns sirupi.controller
   (:use ring.middleware.json 
        ring.adapter.jetty)
  (:require [compojure.core :refer [defroutes ANY]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [sirupi.core :as core]
            ))

(defroutes routes
 core/my_routes
 (route/resources "/" )
)

(def app
  (wrap-defaults routes site-defaults))