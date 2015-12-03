(ns cloj-test.core)

(defn advent-of-code-1
  [floors]
  (reduce + (map #(cond (= \( %) 1 (= \) %) -1 :else 0) floors)))