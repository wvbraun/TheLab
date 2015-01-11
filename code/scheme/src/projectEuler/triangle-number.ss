;; problem 12

(define (triangle-number n)
  (let iter ((n n) (sum 0))
  	(if (zero? n)
  	    sum
  	    (iter (- n 1) (+ sum n)))))

(define (factors n)
  (define (divides? x y) (zero? (remainder x y)))
  (let iter ((x n) (ls '()))
  	(cond ((zero? x) ls)
  		  ((divides? n x) (iter (- x 1) (cons x ls)))
  		  (else (iter (- x 1) ls)))))


(define (prog amt)
  (let iter ((n 1))
  	(let ((ls (factors (triangle-number n))))
  	  (if (> (length ls) amt)
  	  	  (triangle-number n)
  	  	  (iter (+ n 1))))))


(prog 5)
