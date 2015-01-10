; Problem 3
; Find the K'th element of a list
; Ex: (element-at '(a b c d e) 2) => c

(ns boom
  (:use clojure.test))


(defn element1 [x y]
  (loop [x x cnt y y y]
    (if (= cnt y)
        (last x)
        (recur (take y x) (dec 1) y)))) 

(defn element2 [x y]
  (loop [x x y y cnt 0] 
    (when (> cnt y)
    (x) 
    (recur (next x) y (inc cnt)))))

(defn element3 [x y]
  (first (nthnext x y)))

(defn element4 [x y]
  (loop [x x y y cnt 0]
    (when (> cnt y)
    (x)
    (recur (drop-last x) y (inc cnt)))))
    











(deftest test1
  (is (= "c" (element1 '(a b c d e) 2))))

(deftest test2 
  (is (= 4 (element2 [1 2 3 4 5 6] 3))))

(deftest test3
  (is (= "a" (element3 '("q" "s" "t" "r" "a" 5) 4))))

(deftest test4
  (is (= 5 (element4 (range 10) 5))))




(run-all-tests #"boom")
