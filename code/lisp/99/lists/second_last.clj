; Problem 2
; Find the last but one box of a list
; Ex: (my-but-last '(a b c d)) 
; => (c d)

(ns blah
     (:use clojure.test))


(defn sec_last1 [x]
  (take-last 2 x))

(defn sec_last2 [x]
  (reverse (take 2 (reverse x))))

(defn sec_last3 [x]
  (nthnext x (- (count x) 2)))

(defn sec_last4 [x]
  (drop (- (count x) 2) x))

(defn sec_last5 [x]
  (reverse (drop-last (- (count x) 2) (reverse x))))








(deftest test1 
  (is (= '(c d) (sec_last1 '(a b c d)))))

(deftest test2
  (is (= '(2 1) (sec_last2 [4 3 2 1]))))

(deftest test3
  (is (= '(a b) (sec_last3 '(h k l m n o p a b)))))

(deftest test4
  (is (= '("moe" "larry") (sec_last4 '("curly" "shemp" "moe" "larry")))))

(deftest test5 
  (is (= [3 4] (sec_last5 [1 2 :a :b 3 4]))))


(run-all-tests #"blah")
