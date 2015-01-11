(define (square x) (* x x))

#|
; 2.4.1

(define (add-complex z1 z2)
  (make-from-real-image (+ (real-part z1) (real-part z2))
  						(+ (imag-part z1) (imag-part z2))))

(define (sub-complex z1 z2)
  (make-from-real-imag (- (real-part z1) (real-part z2))
  					   (- (imag-part z1) (imag-part z2))))

(define (mul-complex z1 z2)
  (make-from-mag-ang (* (magnitude z1) (magnitude z2))
  					 (+ (angle z1) (angle z2))))

(define (div-complex z1 z2)
  (make-from-mag-ang (/ (magnitude z1) (magnitude z2))
  					 (- (angle z1) (angle z2))))


; x = rcos(A)
; y = rsin(A)
; r = sqrt(x^2 + y^2)
; A = arctan(y,x)


;-------------------------------------------------------------
; 2.4.2

(define (attach-tag type-tag contents)
  (cons type-tag contents))

(define (type-tag datum)
  (if (pair? datum)
  	  (car datum)
  	  (error "Bad tagged datum -- TYPE-TAG" datum)))

(define (contents datum)
  (if (pair? datum)
  	  (cdr datum)
  	  (error "Bad tagged datum -- CONTENTS" datum)))


(define (rectangular? z)
  (eq? (type-tag z) 'rectangular))

(define (polar? z)
  (eq? (type-tag z) 'polar))

; Ben's Rectangular representation:

(define (real-part-rectangular z) (car z))

(define (imag-part-rectangular z) (cdr z))

(define (magnitude-rectangular z)
  (sqrt (+ (square (real-part-rectangular z))
  		   (square (imag-part-rectangular z)))))

(define (angle-rectangular z)
  (atan (imag-part-rectangular z)
  		(real-part-rectangular z)))

(define (make-from-real-imag-rectangular x y)
  (attach-tag 'rectangular (cons x y)))

(define (make-from-mag-ang-rectangular r a)
  (attach-tag 'rectangular
  			  (cons (* r (cos a)) (* r (sin a)))))


; Alyssa's Polar Representation:

(define (real-part-polar z)
  (* (magnitude-polar z) (cos (angle-polar z))))

(define (imag-part-polar z)
  (* (magnitude-polar z) (sin (angle-polar z))))

(define (magnitude-polar z) (car z))

(define (angle-polar z) (cdr z))

(define (make-from-real-imag-polar x y)
  (attach-tag 'polar
  			  (cons (sqrt (+ (square x) (square y)))
  			  		(atan y x))))

(define (make-from-mag-ang-polar r a)
  (attach-tag 'polar (cons r a)))



(define (real-part z)
  (cond ((rectangular? z) (real-part-rectangular (contents z)))
  		((polar? z) (real-part-polar (contents z)))
  		(else (error "Unknown type -- REAL-PART" z))))

(define (imag-part z)
  (cond ((rectangular? z) (imag-part-rectangular (contents z)))
  		((polar? z) (imag-part-polar (contents z)))
  		(else (error "Unknown type -- IMAG-PART" z))))


(define (magnitude z)
  (cond ((rectangular? z) (magnitude-rectangular (contents z)))
  		((polar? z) (magnitude-polar (contents z)))
  		(else (error "Unknown type -- MAGNITUDE" z))))

(define (angle z)
  (cond ((rectangular? z) (angle-rectangular (contents z)))
  		((polar? z) (angle-polar (contents z)))
  		(else (error "Unknown type -- ANGLE" z))))


; to decide to use the rectangular or polar representation,
; we will just construct rectangular numbers whenever we have
; real and imaginary parts, and we will construct polar numbers
; whenever we have magnitude and angle parts

(define (make-from-real-imag x y)
  (make-from-real-imag-rectangular x y))

(define (make-from-mag-ang r a)
  (make-from-mag-ang-polar r a))


;----------------------------------------------------------------------
; 2.4.3

; ben's rectangular representation w/ data-directed programming

(define (install-rectangular-package)
  (define (real-part z) (car z))
  (define (imag-part z) (cdr z))
  (define (make-from-real-imag x y) (cons x y))
  (define (magnitude z)
    (sqrt (+ (square (real-part z)) (square (imag-part z)))))
  (define (angle z)
    (atan (imag-part z) (real-part z)))
  (define (make-from-mag-ang r a)
    (cons (* r (cos a)) (* r (sin a))))
  (define (tag x) (attach-tag 'rectangular x))
  (put 'real-part '(rectangular) real-part)
  (put 'imag-part '(rectangular) imag-part)
  (put 'magniute '(rectangular) magnitude)
  (put 'angle '(rectangular) angle)
  (put 'make-from-real-imag 'rectangular
       (lambda (x y) (tag (make-from-real-imag x y))))
  (put 'make-from-mag-ang 'rectangular
       (lambda (x y) (tag (make-from-mag-ang r a))))
  'done)


; alyssa's

(define (install-polar-package)
  (define (magnitude z) (car z))
  (define (angle z) (cdr z))
  (define (real-part z)
    (* (magnitude z) (cos (angle z))))
  (define (imag-part z)
    (* (magnitude z) (sin (angle z))))
  (define (make-from-real-imag x y)
    (cons (sqrt (+ (square x) (square y)))
	  (atan y x)))
  (define (make-from-mag-ang r a) (cons r a))
  (define (tag x) (attach-tag 'polar x))
  (put 'real-part '(polar) real-part)
  (put 'imag-part '(polar) imag-part)
  (put 'magnitude '(polar) magnitude)
  (put 'angle '(polar) angle)
  (put 'make-from-real-imag 'polar
       (lambda (x y) (tag (make-from-real-imag x y))))
  (put 'make-from-mag-ang 'polar
       (lambda (r a) (tag (make-from-mag-ang r a))))
  'done)


(define (apply-generic op . args)
  (let ((type-tags (map type-tag args)))
    (let ((proc (get op type-tags)))
      (if proc
	  (apply proc (map contents args))
	  (error "No method for these types -- APPLY-GENERIC"
		 (list op type-tags))))))

(define (real-part z) (apply-generic 'real-part z))
(define (imag-part z) (apply-generic 'imag-part z))
(define (magnitude z) (apply-generic 'magnitude z))
(define (angle z) (apply-generic 'angle z))

(define (make-from-real-imag x y)
  ((get 'make-from-real-imag 'rectangluar) x y))

(define (make-from-mag-ang r a)
  ((get 'make-from-mag-ang 'polar) r a))


|#

; -----------------------------------------------------------
; Exercises 

; 2.73

(define (deriv exp var)
  (cond ((number? exp) 0)
	((variable? exp) (if (same-variable? exp var) 1 0))
	(else ((get 'deriv (operator exp)) (operands exp) var))))

(define (operator exp) (car exp))
(define (operands exp) (cdr exp))

(define (install-deriv-package)
  (define (=number? exp num)
    (and (number? exp) (= exp num)))

  ;sum
  (define (make-sum a1 a2)
    (cond ((=number? a1 0) a2)
	  ((=number? a2 0) a1)
	  ((and (number? a1) (number? a2)) (+ a1 a2))
	  (else (list '+ a1 a2))))
  (define (addend s) (car s))
  (define (augend s) (cadr s))
  (define (deriv-sum exp var)
    (make-sum (deriv (addend exp) var)
	      (deriv (augend exp) var)))

  ;product
  (define (make-product m1 m2)
    (cond ((or (=number? m1 0) (=number? m2 0)) 0)
	  ((=number? m1 1) m2)
	  ((=number? m2 1) m1)
	  ((and (number? m1) (number? m2)) (* m1 m2))
	  (else (list '* m1 m2))))
  (define (multiplier m) (car m))
  (define (multiplicand m) (cadr m))
  (define (deriv-product exp var)
    (make-sum
     (make-product (multiplier exp)
		   (deriv (multiplicand exp) var))
     (make-product (multiplicand exp)
		   (deriv (multiplier exp) var))))
  (put 'deriv '+ deriv-sum)
  (put 'deriv '* deriv-product)
  'done)

(define get 2d-get)
(define put 2d-put!)

(define (variable? x) (symbol? x))
(define (same-variable? v1 v2)
  (and (variable? v1) (variable? v2) (eq? v1 v2)))



; message passing

(define (make-from-real-imag x y)
  (define (dispatch op)
    (cond ((eq? op 'real-part) x)
	  ((eq? op 'imag-part) y)
	  ((eq? op 'magnitude) (sqrt (+ (square x) (square y))))
	  ((eq? op 'angle) (atan y x))
	  (else (error "Unknown Op -- MAKE-FROM-REAL-IMAG" op))))
  dispatch)

; exercises
; 2.75

(define (make-from-mag-ang r a)
  (define (dispatch op)
    (cond ((eq? op 'magnitude) r)
	  ((eq? op 'angle) a)
	  ((eq? op 'real-part) (* r (cos a)))
	  ((eq? op 'imag-part (* r (sin a))))
	  (else (error "Unknown Op -- MAKE-FROM-MAG-ANG" op))))
  dispatch)

; 2.76
