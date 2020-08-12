(ns sirupi.singleView
  (:use hiccup.page hiccup.element)
  (:require  
    [hiccup.core :refer [h]]
    [sirupi.pageView :as izgledStr]
     [hiccup.form :as form]
     [ring.util.anti-forgery :as anti-forgery]
))

(defn index []
  (izgledStr/view
    [:div {:class "container"}
          [:a [:img {:class "img-fluid" :alt "Responsive image" :src "/img/3.jpg"}]]
      ]
    ))
