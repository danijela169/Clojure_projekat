(ns sirupi.broker
   (:require [clojure.java.jdbc :as sql]))
(def connection 
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//localhost/sirup_za_mrsavljenje"
   :user "root"
   :password ""})