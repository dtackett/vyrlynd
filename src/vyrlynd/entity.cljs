(ns vyrlynd.entity
  (:require [vyrlynd.components :as components]))

; Entities
; [the entities in our system]

; Entity composition functions
(defn add-component
  "Add a component by its name to the given map"
  [entity component]
  (assoc entity (components/component-name component) component))

;; TOTHINK Should this be expanded allow multiple component updates at a time?
(defn update-component
  "Update a component"
  [entity component-name component-data]
  (add-component entity (merge (get entity component-name) component-data)))

(defn compose-entity
  "Create a new entity from a series of components"
  [components]
  (reduce add-component {} components))

(defn has-component
  "Check if the given entity has the given component"
  [entity component]
  (contains? entity component))
