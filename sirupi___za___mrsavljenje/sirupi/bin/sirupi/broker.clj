(ns sirupi.broker
   (:require [clojure.java.jdbc :as sql]))
(def connection 
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//localhost/sirup_za_mrsavljenje"
   :user "root"
   :password ""})

(defn data []
   (into [] (sql/query connection ["SELECT * FROM narudzbina, sirup WHERE narudzbina.sirupID = sirup.sirupID"])))


(defn deleteNar [id]
  (sql/delete! connection :narudzbina ["narudzbinaid = ?" id])
  )

(defn dataNarudzbine [id]
  (into [] (sql/query connection ["SELECT * FROM narudzbina, sirup WHERE narudzbina.sirupID = sirup.sirupID && narudzbina.narudzbinaID=?" id])))


(defn updateNarudzbina [id sirupid kolicina]
  (sql/update! connection :narudzbina {:narudzbinaid id :sirupid sirupid :kolicina kolicina} ["narudzbinaid = ?" id]))

(defn dataSirupi []
   (into [] (sql/query connection ["SELECT * FROM sirup"])))

(defn dataSearch [rez]
  (into [] (sql/query connection ["SELECT *, SUM(narudzbina.kolicina) as broj FROM narudzbina, sirup WHERE narudzbina.sirupID = sirup.sirupID && sirup.nazivVrste LIKE ? group by sirup.sirupID" (str "%" rez "%")]))
  )

(defn addNar [sirupid kolicina]
  (sql/insert! connection :narudzbina [:sirupid :kolicina :datumpreuzimanja] [sirupid (read-string kolicina) (java.time.LocalDateTime/now)]))


