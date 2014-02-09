(ns vyrlynd.components
  (:require-macros [vyrlynd.macro :refer [defcomponent]]))

(defprotocol component-proto (component-name [_]))

(defcomponent id [id])
