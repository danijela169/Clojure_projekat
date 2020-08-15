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

(defn dodatiNovu [sirupi]
  (form/form-to [:post "/add"]
    (anti-forgery/anti-forgery-field)
      [:div {:class "col-md-6"}
        [:label {:for "sirup"} "Sirup"]
         [:select {:name "sirup" :class "form-control" :id "sirup"}
              (map (fn [sirup]
                 [:option {:value (:sirupid sirup)} (:nazivvrste sirup)]) sirupi)
              ]
         ]
         [:div {:class "col-md-12"}
          [:label {:for "kolicina"} "Količina"]
           [:input {:type "number" :name "kolicina" :class "form-control" :id "kolicina" :min "1" :value (:kolicina sirupi):placeholder "Količina"}]]
         [:div {:class "col-md-12"}
          [:label {:for "button"} ]
           [:input {:type "submit" :name "button" :class "form-control btn-info" :id "button" :value "Sačuvaj narudžbinu"}]
           ]
  )
  )

(defn novaNarudzbina [sirupi]
  (izgledStr/view
     [:section {:id "narudzbina"}
     [:div {:class "container"}
          [:div {:class "center wow fadeInDown"}
                [:h2 "Dodaj narudžbinu"]
                 [:p {:class "lead"} "Dodavanje nove narudžbine"]
             ]

             [:div {:class "row"}
                 [:div  {:class "narudzbine"}
                  (dodatiNovu sirupi)
                  ]
                 ]
             ]
     ]
    )
  )

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
                                [:td [:a {:class "btn btn-danger" :href (str "/deleteNar/" (h (:narudzbinaid singleData)))} "Obrišite narudžbinu" ]]
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
                        [:input {:type "number" :name "kolicina" :class "form-control" :id "kolicina" :min "1" :value (:kolicina narudzbina)}]
                     ]
                      [:div {:class "col-md-12"}
                        [:label {:for "id" }]
                        [:input {:type "hidden" :name "id" :class "form-control" :id "kolicina" :value (:narudzbinaid narudzbina)}]
                      ]
                      [:div {:class "col-md-12"}
                        [:label {:for "button"}]
                        [:input {:type "submit" :class "form-control btn-info" :id "button" :value "Izmenite narudžbinu"}]
                      ]
                      )) narudzbina)
  
  )

(defn izmena [narudzbina sirupi]
  (izgledStr/view 

    [:section {:id "narudzbina"}
         [:div {:class "container"}
          [:div {:class "center wow fadeInDown"}
                [:h2 "Izmenite narudžbinu"]
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

(defn rezultat [dataSearch]
  [:div {:id "tabela" :class "col-md-12"}
   [:table {:class "table table-hover"}
   [:thead
     [:tr
       [:th "Sirup"]
       [:th "Cena sirupa po komadu"]
       [:th "Naručena količina"]
       [:th "Ukupna cena narudžbine"]
     ]
   ]
    [:tbody
      [:tr 
        (map 
          (fn [singleData]
            [:tr
             [:td (:nazivvrste singleData)]
             [:td (:cenasirupa singleData)]
             [:td (:kolicina  singleData)] 
             [:td (* (:cenasirupa singleData) (:kolicina singleData))]
            ] ) dataSearch)]
   ]
]]
  )

 
(defn pretraganar [svi rezultati dataSearch] 
  (izgledStr/view
     [:section {:id "narudzbina"}
     [:div {:class "container"}
          [:div {:class "center wow fadeInDown"}
                [:h2 "Sirupi"]
                 [:p {:class "lead"} "Pretraga po vrsti sirupa"]
             ]
     [:div {:class "row"}
     [:div  {:class "narudzbine"}

		(form/form-to [:post "/pretraganar"]
    (anti-forgery/anti-forgery-field)
     [:div {:class "col-md-12"}
      
   [:input {:clas "form-control" :id "rez" :name "rez" :placeholder "Nazivu vrste sirupa" :value rezultati}]
   ]
      [:div {:class "col-md-12"}
   [:label {:for "button"}]
   [:button {:class "btn btn-info form-control":type "submit" :name "button"} "Pretraži sirupe"]
  ]
  )
  (if (= svi true) 
    (do (rezultat dataSearch)))
  ]]]]
))



















