
(define (prob n)
  (let iter ((x n) (ls '((1 0) (2 0) (3 0) (4 0) (5 0) (6 0))))
  	(if (zero? x)
  	    (map (lambda (x) (list (car x) (* (/ (cadr x) n) 100))) ls)
  	    (let ((rand (+ 1 (random 6))))
  	      (iter (- x 1) (map (lambda (x)
  	      					   (if (= rand (car x))
  	      		                   (list (car x) (+ (cadr x) 1))
  	      		                   x)) ls))))))


(prob 10)
(prob 100)
(prob 1000.0)
(prob 10000.0)
