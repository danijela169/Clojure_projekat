(ns sirupi.pageView
  (:use [hiccup.element :only (link-to)])
  (:require [hiccup.page :as h]
            [hiccup.page :refer [html5 include-css]]))
(defn view [body]
  (h/html5
    [:head
     [:title "Sirup za mršavljenje"]
     (include-css "/css/bootstrap.css" "/css/style1.css" "/css/bootstrap.min.css" "/css/responsive.css" "/css/style.css" "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css")
     ]
    [:body {:class "homepage"}
     [:header {:id "header"}
      [:nav {:class "navbar navbar-fixed-top" :role "banner"}
            [:div {:class "container"}
                [:div {:class "navbar-header"}
                    [:button {:type "button" :class "navbar-toggle" :data-toggle "collapse" :data-target ".navbar-collapse"}
                        [:span {:class "sr-only"} "Toggle navigation"]
                        [:span {:class "icon-bar"}]
                        [:span {:class "icon-bar"}]
                        [:span {:class "icon-bar"}]
                     
                     ]
                    [:a {:class "navbar-brand" :href "/"} "Sirup za mrsavljenje"]
                ]

                [:div {:class "collapse navbar-collapse navbar-right"}
                    [:ul {:class "nav navbar-nav"}
                     [:li [:a {:href "/novanarudzbina"} "Dodaj novu narudžbinu"]]
                     [:li [:a {:href "/narudzbine"} "Narudžbine"]]
                     [:li [:a {:href "/pretraganar"} "Pretraži narudžbine po vrsti sirupa"]]
                   
					
                    ]
                ]
             ]
            ]
      ]
     body
         [:footer {:id "footer" :class "midnight-blue"}
        [:div {:class "container"}
            [:div {:class "row"}
              [:div {:class "col-sm-6"}
                    "Proizvodnja: Beogradska 12, Beograd, Stari grad"[:br]
                    "Broj telefona: 065 916 1995"[:br]
                    "Naručivanje 00–24 online ili telefonom, nedeljom ne dostavljamo"[:br]
                    "sirupizamrsavljenje@gmail.com"[:br][:br]                
                    "Sirupi za mršavljenje. All Rights Reserved. Snaga prirode."
               ]
           ]
   ]]]
))
