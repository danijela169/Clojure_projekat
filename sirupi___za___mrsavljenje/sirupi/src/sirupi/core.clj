(ns sirupi.core
  (:use ring.middleware.json 
        ring.adapter.jetty
        compojure.core
        [hiccup.element :only (link-to)])
  (:require [compojure.core :refer [defroutes ANY]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.page :as h]
            [hiccup.page :refer [html5 include-css]]
            ))

(defn izgled []
  (h/html5
    [:head
     [:title "Sirupi za mrsavljenje"]
     (include-css "/css/bootstrap.css" "/css/style1.css" "/css/bootstrap.min.css" "/css/responsive.css" "/css/style.css" "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css")
     ]
    [:body {:class "homepage"}
[:p "Prirodnim putem do idealne linije"]

    ]
  ))



(defroutes mroutes
 (GET "/" [] (izgled))
 (route/resources "/"))
(def app
  (wrap-defaults mroutes site-defaults))




