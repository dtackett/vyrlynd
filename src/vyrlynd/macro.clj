(ns vyrlynd.macro)

(defmacro defcomponent [comp-name props & r]
  `(defrecord
     ~(symbol (name comp-name)) ~props
     vyrlynd.components/component-proto
       (~(symbol "component-name") [~(symbol "_")] ~(keyword comp-name))
     ~@r))

; (macroexpand-1 '(defcomponent :position [x y z]))
