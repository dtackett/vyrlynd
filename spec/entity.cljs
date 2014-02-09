(ns vyrlynd.spec.entity
    (:require [specljs.core :as speclj]
              [vyrlynd.entity :as entity])
    (:require-macros [specljs.core :refer [describe it should should-not should-be-nil should==]]
                     [vyrlynd.macro :refer [defcomponent]]))

(defcomponent position [x y])

;; Add a component to an entity
;; Compose an entity

(describe "Composing an entity"
          (it "with no components"
              (should==
               (entity/compose-entity [])
               {})))


(describe "Checking if an entity has a component"
          (it "that it has"
              (should (entity/has-component
                       (entity/compose-entity [(position. [10 10])])
                       :position)))

          (it "that it doesn't have"
              (should-not (entity/has-component
                           (entity/compose-entity [(position. [10 10])])
                           :aabb))))
