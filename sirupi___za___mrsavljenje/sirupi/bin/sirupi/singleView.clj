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

(defn izmeniti [narudzbina sirupi]
   (map 
      (fn [narudzbina]
                     (form/form-to [:post "/update"]
                       (anti-forgery/anti-forgery-field)
                      [:div {:class "col-md-6"}
                        [:label {:for "sirup"} "Sirup"]
                        [:select {:name "sirupid" :class "form-control" :id "sirup" :value (:sirupid narudzbina)}
                         (map (fn [sirup]
                                [:option {:value (:sirupid sirup)} (:nazivvrste sirup)]) sirupi)
                         ]
                       ]

                      [:div {:class "col-md-12"}
                        [:label {:for "kolicina"} "Količina"]
                        [:input {:type "number" :name "kolicina" :class "form-control" :id "kolicina" :value (:kolicina narudzbina)}]
                     ]
                      [:div {:class "col-md-12"}
                        [:label {:for "id" }]
                        [:input {:type "hidden" :name "id" :class "form-control" :id "kolicina" :value (:narudzbinaid narudzbina)}]
                      ]
                      [:div {:class "col-md-12"}
                        [:label {:for "button"}]
                        [:input {:type "submit" :class "form-control btn-info" :id "button" :value "Izmeni narudžbinu"}]
                      ]
                      )) narudzbina)
  
  )

(defn izmena [narudzbina sirupi]
  (izgledStr/view 

    [:section {:id "narudzbina"}
         [:div {:class "container"}
          [:div {:class "center wow fadeInDown"}
                [:h2 "Izmeni narudžbinu"]
                 [:p {:class "lead"} "Izmena narudžbine"]
             ]

             [:div {:class "row"}
                 [:div  {:class "narudzbine"}
                (izmeniti narudzbina sirupi)
                    ]
                 ]
            ]
        ]
    )
  )

