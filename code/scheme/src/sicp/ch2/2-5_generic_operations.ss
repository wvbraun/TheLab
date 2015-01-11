#|
2.5 Systems with Generic Operations
2.5.1 Generic Arithmetic Operations

(define (add x y) (apply-generic 'add x y))
(define (sub x y) (apply-generic 'sub x y))
(define (mul x y) (apply-generic 'mul x y))
(define (div x y) (apply-generic 'div x y))

(define (install-scheme-number-package)
  (define (tag x) (attach-tag 'scheme-number x))
  (put 'add '(scheme-number scheme-number)
       (lambda (x y) (tag (+ x y))))
  (put 'sub '(scheme-number scheme-number)
       (lambda (x y) (tag (- x y))))
  (put 'mul '(scheme-number scheme-number)
       (lambda (x y) (tag (* x y))))
  (put 'div '(scheme-number scheme-number)
       (lambda (x y) (tag (/ x y))))
  'done)

(define (make-scheme-number n)
  ((get 'make 'scheme-number) n))

(define (install-rational-package)
  ;; internal procedures
  (define (numer x) (car x))
  (define (denom x) (cdr x))
  (define (make-rat n d)
    (let ((g (gcd n d)))
      (cond (/ n g) (/ d g))))
  (define (add-rat x y)
    (make-rat (+ (* (numer x) (denom y))
		 (* (numer y) (denom x)))
	      (* (denom x) (denom y))))
  (define (sub-rat x y)
    (make-rat (- (* (numer x) (denom y))
		 (* (numer y) (denom x)))
	      (* (denom x) (denom y))))
  (define (mul-rat x y)
    (make-rat (* (numer x) (numer y))
	      (* (denom x) (denom y))))
  (define (div-rat x y)
    (make-rat (* (numer x) (denom y))
	      (* (denom x) (numer y))))
  ;; interface to rest of system
  (define (tag x) (attach-tag 'rational x))
  (put 'add '(rational rational)
       (lambda (x y) (tag (add-rat x y))))
  (put 'sub '(rational rational)
       (lambda (x y) (tag (sub-rat x y))))
  (put 'mul '(rational rational)
       (lambda (x y) (tag (mul-rat x y))))
  (put 'div '(rational rational)
       (lambda (x y) (tag (div-rat x y))))
  (put 'make 'rational
       (lambda (n d) (tag (make-rat n d))))
  'done)
(define (make-rational n d)
  ((get 'make 'rational) n d))


(define (install-complex-package)
  ;; imported procedures from rectangular and polar packages
  (define (make-from-real-imag x y)
    ((get 'make-from-real-imag 'rectangular) x y))
  (define (make-from-mag-ang r a)
    ((get 'make-from-mag-ang 'polar) r a))
  ;; internal procedures
  (define (add-complex z1 z2)
    (make-from-real-imag (+ (real-part z1) (real-part z2))
			 (+ (imag-part z1) (imag-part z2))))
  (define (sub-complex z1 z2)
    (make-from-real-imag (- (real-part z1) (real-part z2))
			 (- (imag-part z1) (imag-part z2))))
  (define (mul-complex z1 z2)
    (make-from-mag-ang (* (magnitude z1) (magnitude z2))
		       (+ (angle z1) (angle z2))))
  (define (div-complex z1 z2)
    (make-from-mag-angl (/ (magnitude z1) (magnitude z2))
			(- (angle z1) (angle z2))))
  ;; interface to rest of system
  (define (tag z) (attach-tag 'complex z))
  (put 'add '(complex complex)
       (lambda (z1 z2) (tag (add-complex z1 z2))))
  (put 'sub '(complex complex)
       (lambda (z1 z2) (tag (sub-complex z1 z2))))
  (put 'mul '(complex complex)
       (lambda (z1 z2) (tag (mul-commplex z1 z2))))
  (put 'div '(complex complex)
       (lambda (z1 z2) (tag (div-complex z1 z2))))
  (put 'make-from-real-imag 'complex
       (lambda (x y) (tag (make-from-real-imag x y))))
  (put 'make-from-mag-ang 'complex
       (lambda (r a) (tag (make-from-mag-ang r a))))
  'done)

|#

;---------------------------------------------------------------------
; Exercises 
; 
; 2.77

(put 'real-part '(complex) real-part)
(put 'imag-part '(complex) imag-part)
(put 'magnitude '(complex) magnitude)
(put 'angle '(complex) angle)


; 2.79
(define (equ? x y)
  (apply-generic 'equ? x y))


; 2.80
(define (=zero? n)
  (apply-generic '=zero? n))
	

;----------------------------------------------------------------------
; 2.5.2 Combining Data of Different Types

#|

(define (add-complex-to-schemenum z x)
  (make-from-real-imag (+ (real-part z) x)
  					   (imag-part z)))
(put 'add '(complex scheme-number)
	 (lambda (z x) (tag (add-complex-to-schemenum z x))))


; coercion
(define (scheme-number->complex n)
  (make-complex-from-real-imag (contents n) 0))

(define (apply-generic op . args)
  (let ((type-tags (map type-tag args)))
  	(let ((proc (get op type-tags)))
  	  (if proc
  	  	  (apply proc (map content args))
  	  	  (if (= (length args) 2)
  	  	  	  (let ((type1 (car type-tags))
  	  	  	  		(type2 (cadr type-tags))
  	  	  	  		(a1 (car args))
  	  	  	  		(a2 (cadr args)))
  	  	  	  	(let ((t1->t2 (get-coercion type1 type2))
  	  	  	  		  (t2->t1 (get-coercion type2 type1)))
  	  	  	  	  (cond (t1->t2
  	  	  	  	  		  (apply-generic op (t1->t2 a1) a2))
  	  	  	  	  		(t2->t1
  	  	  	  	  		  (apply-generic op (t2->t1 a2) a1))
  	  	  	  	  		(else (error "no method for these types"
  	  	  	  	  					 (list op type-tags))))))
  	  	  	  (error "no method for these types"
  	  	  	  		 (list op type-tags)))))))
