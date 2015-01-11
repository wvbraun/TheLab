
(define (nth-prime n)
  (let iter ((i 2) (amt 1) (num '()))
  	(cond ((> amt n) num)
  		  ((prime? i) (iter (+ i 1) (+ amt 1) i))
  		  (else (iter (+ i 1) amt num)))))

(define (square x) (* x x ))

(define (smallest-divisor n)
  (find-divisor n 2))

(define (find-divisor n test)
  (cond ((> (square test) n) n)
  		((divides? test n) test)
  		(else (find-divisor n (+ test 1)))))

(define (divides? a b)
  (zero? (remainder b a)))

(define (prime? n)
  (= n (smallest-divisor n)))


(nth-prime 10001)
