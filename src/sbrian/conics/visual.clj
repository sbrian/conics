(ns sbrian.conics.visual
  (:use sbrian.conics.core)
  (:use sbrian.plotting.core))

(defn plot-eccentricity [e]
  (show-m
  (positive-parts-from-eccentricity-and-focus-zero-directrix -300 e 30 600 0.1)))

(defn plot-range-of-eccentricities [e0 e1 inc]
  (loop [n e0]
    (if (> n e1) nil
      (do (plot-eccentricity n)
        (recur (+ n inc))))))

(defn four-hyperbolas-a-parabola-and-four-ellipses []
  (plot-range-of-eccentricities 1.5 3.0 0.5)
  (plot-range-of-eccentricities 0.2 0.8 0.2)
  (plot-eccentricity 1)
  nil)
