; easy

(define (tree base trunk leaves)
  (let iter ((n 1) (s 0) (trunk trunk) (leaves leaves))
  	(cond ((> n base) (list trunk trunk trunk))
  		  ((= s n) (iter (+ n 2) 0 trunk leaves))
  		  (else
  		  	(
