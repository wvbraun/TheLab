
(define (square x) (* x x))

(define (sum-squares total)
  (let iter ((i 1) (sum 0))
  	(if (> i total)
  	    sum
  	    (iter (+ i 1) (+ sum (square i))))))


(define (square-sums total)
  (let iter ((i 1) (sum 0))
  	(if (> i total)
  	    (square sum)
  	    (iter (+ i 1) (+ sum i)))))


(- (square-sums 100) (sum-squares 100))



