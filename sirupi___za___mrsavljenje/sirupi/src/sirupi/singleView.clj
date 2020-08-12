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

(defn narudzbine [data] 
  (izgledStr/view 
   [:section {:id "narudzbine"}
        [:div {:class "container"}
           [:div
                [:h2 "Narudžbine"]
                [:p {:class "lead"} "Lista narudžbina"]
            ]

            [:div {:class "row"}
                [:div {:class "narudzbine"}
                     [:table {:class "table table-hover"}
                       [:thead
                         [:tr
                           [:th "Sirupi"]
                           [:th "Naručena količina"]
                           [:th "Datum kreiranja narudžbine"]
                         ]
                       ]
                       [:tbody
                          [:tr 
                           (map 
                             (fn [singleData]
                               [:tr
                                [:td (:nazivvrste singleData)]
                                [:td (:kolicina singleData)]
                                [:td (.toString (:datumpreuzimanja singleData))] 
                                [:td [:a {:class "btn btn-info" :href (str "/izmena/" (h (:narudzbinaid singleData)))} "Izmenite narudžbinu" ]]
                                [:td [:a {:class "btn btn-danger" :href (str "/obrisi/" (h (:narudzbinaid singleData)))} "Obrišite narudžbinu" ]]
                           ] ) data)]
  ]]]]]]  
 ))