(define (reverse ls)
  (let iter ((ls ls) (new '()))
  	(if (null? ls)
  	    new
  	    (iter (cdr ls) (cons (car ls) new)))))


(define (deep-reverse ls)
  (cond ((null? ls) ls)
  		((pair? (car ls))
  		 (append (deep-reverse (cdr ls))
  		 		 (list (deep-reverse (car ls)))))
  		(else (append (deep-reverse (cdr ls))
  					  (list (car ls))))))


(deep-reverse '((1 2) 3 (4 5)))
