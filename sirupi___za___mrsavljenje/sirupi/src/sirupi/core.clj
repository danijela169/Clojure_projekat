(ns sirupi.core
 (:use ring.util.json-response 
        ring.adapter.jetty
        compojure.core)
  (:require [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as ring] 
            [compojure.route :as route]
            [compojure.core :refer [defroutes GET POST]]
            [sirupi.singleView :as view]
            [sirupi.broker :as b])
)



(defn pocetnaStr []
   (view/index )
  )


(defn narudzbine []
   (view/narudzbine (b/data))
  )

(defn izmenaNarudzbine [id sirupid kolicina]
  (b/updateNarudzbina id sirupid kolicina) 
  (ring/redirect "/narudzbine")
  )


(defn izmenaNar [id]
  (view/izmena (b/dataNarudzbine id) (b/dataSirupi))
  )


(defroutes my_routes
 (GET "/" [] (pocetnaStr))
 (GET "/narudzbine" [] (narudzbine))
 (GET "/izmena/:id" [id] (izmenaNar id))
 (POST "/update" [sirupid kolicina id] (izmenaNarudzbine id sirupid kolicina))
 (route/resources "/"))


