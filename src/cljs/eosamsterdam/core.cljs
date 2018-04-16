(ns eosamsterdam.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [eosamsterdam.events :as events]
            [eosamsterdam.routes :as routes]
            [eosamsterdam.views :as views]
            [eosamsterdam.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
