(ns cloj-test.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn advent-of-code-1
  [floors]
  (reduce + (map #(cond (= \( %) 1 (= \) %) -1 :else 0) floors)))