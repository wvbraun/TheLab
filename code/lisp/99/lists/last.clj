; Problem 1
; Find the last box of a list. 
; (my-last '(a b c d))
; => (d)


(ns last.clj
  (:use clojure.test))

(defn my_last [x]
  (nth  x (- (count x) 1)))

(defn last2 [x]
  (first (reverse x)))

(defn last3 [x]
  (drop (- (count x) 1)  x))

(defn last4 [x]
  (take 1 (reverse x)))

(defn last5 [x]
  (take-last 1 x))


(deftest last_test
    (is (= 4 (my_last [1 2 3 4]))))

(deftest last2_test 
  (is (= 4 (last2 [1 2 3 4]))))

(deftest last3_test
  (is (= 4 (last3 [1 2 3 4]))))

(deftest last4_test
  (is (= 4 (last4 [1 2 3 4]))))

(deftest last5_test
  (is (= 4 (last4 [1 2 3 4]))))

(run-all-tests #"last.clj")
