(define (common vec)
  (let* iter ((v (sort! vec <))
  			 (i 1)
  			 (amt 1)
  			 (n (vector-ref v 0))
  	(cond ((= (+ i 1) (vector-length vec)) n)
  		  ((= n (vector-ref vec i))
  		   (iter v (+ i 1) (+ amt 1) n))
  		  (else (iter v (+ i 1) 0
