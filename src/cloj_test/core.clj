(ns cloj-test.core
  (:require [clojure.string :as str])
  (:import (java.io File)))

(defn read-advent-of-code-1
  []
  (mapv #(cond (= \( %) 1
               (= \) %) -1)
        (slurp (File. "resources/input-1.txt"))))

(defn advent-of-code-1
  [steps]
  (println "End floor:" (reduce + steps))
  (println "First basement:" (first (keep-indexed (fn [n _]
                                                    (when (= (reduce + (take n steps)) -1) n))
                                                  steps))))

(defn read-advent-of-code-2
  []
  (let [dimensions-list (str/split (slurp (File. "resources/input-2.txt")) #"\n")]
    (map #(let [dimensions (str/split % #"x")
                l (Integer/parseInt (nth dimensions 0))
                w (Integer/parseInt (nth dimensions 1))
                h (Integer/parseInt (nth dimensions 2))]
           {:l l :w w :h h})
         dimensions-list)))

(defn advent-of-code-2
  [dimensions]
  (reduce + (map #(let [top-bottom (* 2 (:l %) (:w %))
                        front-back (* 2 (:w %) (:h %))
                        sides (* 2 (:h %) (:l %))]
                   (+ top-bottom front-back sides (/ (min top-bottom front-back sides) 2))) dimensions)))

;;(+ (* 2 l w) (* 2 w h) (* 2 h l))