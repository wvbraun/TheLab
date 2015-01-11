; problem 15

(define (factorial n)
  (let iter ((n n) (sum 1))
  	(if (zero? n)
  	    sum
  	    (iter (- n 1) (* sum n)))))


(define (count-paths m n)
  (/ (factorial (+ m n))
  	 (* (factorial (- (+ m n) m))
  	 	(factorial m))))

(count-paths 2 2)
(count-paths 20 20)
