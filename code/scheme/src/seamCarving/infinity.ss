
(define (infinity) 'oo)

(define (infinity? sym)
  (equal? sym (infinity)))


(define (:+ x y)
  (if (or (infinity? x) (infinity? y))
  	  infinity
  	  (+ x y)))

(define (:< x y)
  (cond ((infinity? x) #f)
  		((infinity? y) #t)
  		(else (< x y))))

