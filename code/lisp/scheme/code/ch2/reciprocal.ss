; this will return the reciprocal of a number
; 10 = 1/10

(define reciprocal
  (lambda (n)
  	(if (= n 0) ; if n == 0 
  	  "oops!"	; retun 0
  	  (/ 1 n)))); else return 1/n

(reciprocal 10)
