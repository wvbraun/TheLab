(ns guestbook.routes.home
  (:use compojure.core)
  (:require [guestbook.views.layout :as layout]
            [guestbook.util :as util]
            [guestbook.models.db :as db]))

(defn home-page [& [name message error]]
  (layout/render "home.html" 
                 {:error    error
                  :name     name
                  :message  message
                  :messaes  (db/get-messages)}))

(defn about-page []
  (layout/render "about.html"))

(defn save-message [name message]
  (cond 

    (empty? name)
    (home-page name message "Somebody forgot to leave a name")

    (empty? message)
    (home-page name message "Don't you have something to say?")

    :else 
    (do 
      (db/save-message name message)
      (home-page))))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/" [name message] (save-message name message))
  (GET "/about" [] (about-page)))
