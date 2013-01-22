(ns sbrian.conics.core
  (:use clojure.contrib.generic.math-functions))


(defn y-from-eccentricity-and-focus-zero-directrix [x e c]
  "Assumes directrix at x=0 and goes from there to find y from x, eccentricity and focus"
  "Returns nil if no solution for this x"
  (let [i (+ (* (pow e 2) (pow x 2)) (- (pow x 2)) (* 2 c x) (- (pow c 2)))]
    (if (>= i 0 ) (sqrt i) nil)))

(defn positive-parts-from-eccentricity-and-focus-zero-directrix
  [x e c h-size point-spacing]
  (let [x-max (+ x (- h-size 1))]
    (apply vector
      (loop [n x vects []]
        (if (>= n x-max)
          vects
          (recur
            (+ n point-spacing)
            (conj vects [n (y-from-eccentricity-and-focus-zero-directrix n e c)])))))))

