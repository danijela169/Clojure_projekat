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


(defn novaNar []
  (view/novaNarudzbina (b/dataSirupi))
  )

(defn dodatiNarudzbinu [sirupid kolicina]
  (b/addNar sirupid kolicina)
   (ring/redirect "/narudzbine")
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

(defn pretraganar [rezultatPret rez]
  (if (= rez "")
    (do (view/pretraganar rezultatPret rez ""))
    (view/pretraganar rezultatPret rez (b/dataSearch rez)
      ))
  
  )


(defn deleteNar [id]
  (b/deleteNar id)
  (ring/redirect "/narudzbine")
  )

(defroutes my_routes
 (GET "/" [] (pocetnaStr))
 (GET "/novanarudzbina" [] (novaNar))
 (POST "/add" [sirup kolicina] (dodatiNarudzbinu sirup kolicina))
 (GET "/narudzbine" [] (narudzbine))
 (GET "/izmena/:id" [id] (izmenaNar id))
 (POST "/update" [sirupid kolicina id] (izmenaNarudzbine id sirupid kolicina))
 (GET "/pretraganar" [] (pretraganar false ""))
 (POST "/pretraganar" [rez] (pretraganar true rez))
 (GET "/deleteNar/:id" [id] (deleteNar id))
 (route/resources "/"))



