
r = s / (2 * sin(pi/n)) = a / cos(pi/n)

(define (poly-p n r)
  (let ((s (* r (* 2 (sin (/ 3.141596 n))))))
  	(* s n)))

