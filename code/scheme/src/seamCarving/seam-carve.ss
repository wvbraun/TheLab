(require pkg)
(install "github://github.com/iu-c211/c211-libs/master")
(require "energy.ss")
(require "infinity.ss")

; image-copy
(define (image-copy img)
  (make-image 
  	(image-rows img)
    (image-cols img)
    (lambda (r c) (image-ref img r c))))

; image-crop
(define (image-crop img n)
  (make-image
  	(image-rows img)
  	(if (> n (image-cols img))
  	    0
  	    (- (image-cols img) n))
  	(lambda (r c) (image-ref img r c))))



; ------------------------------------------------------------------------
; Problem 2

(define (highlight-seam! img ls c)
  (let iter ((r 0) (ls ls))
  	(unless (null? ls)
  	  (image-set! img r (car ls) c)
  	  (iter (+ r 1) (cdr ls)))))


; ------------------------------------------------------------------------
; Problem 3
; A

(define (make-energy-matrix img)
  (matrix-generator
  	(image-rows img)
  	(image-cols img)
  	(lambda (r c)
  	  ;; i round down to only return integers
  	  (inexact->exact (round (energy img r c)))))) 


;B

(define (matrix-map proc mat)
  (matrix-generator
  	(matrix-rows mat)
  	(matrix-cols mat)
  	(lambda (r c)
  	  (proc (matrix-ref mat r c)))))

; C

(define (matrix-copy mat)
  (matrix-map (lambda (x) x) mat))


; D

(define (cropped-matrix-ref mat r c n)
  (cond ((<= n c) (infinity))
  		((or (< r 0) (< c 0)) (infinity))
  		(else (matrix-ref mat r c))))


; ------------------------------------------------------------------------
; Problem 4

(define (best-direction c1 c2 c3)
  (if (:< c1 c2)
  	  (if (:< c1 c3) ;; if c1 < c2 do this
  	  	  -1
  	  	  1)
  	  (if (:< c2 c3) ;; if c1 > c2 do this
  	  	  0
  	  	  1)))


; ------------------------------------------------------------------------
; Problem 5

(define (seam-origin mat n)
  (let iter ((c 1) (tmp (list 0 (matrix-ref mat 0 0))))
  	(cond ((= c (matrix-cols mat)) (car tmp))
  		  ((= c n) (car tmp))
  		  ((:< (matrix-ref mat 0 c) (cadr tmp))
  		   (iter (+ c 1) (list c (matrix-ref mat 0 c))))
  		  (else (iter (+ c 1) tmp)))))


; ------------------------------------------------------------------------
; Problem 6

(define (walk-seam sm c)
  (let iter ((r 0) (c c))
  	(let ((next (matrix-ref sm r c)))
  	  (if (= r (- (matrix-rows sm) 1))
  	  	  (list c)
  	  	  (cons c
  	  	  		(iter (+ r 1) next))))))


; ------------------------------------------------------------------------
; Problem 7
 
(define (least-energy-seam em n)
  (let ((cm (matrix-copy em))
  		(sm (make-matrix (matrix-rows em) (matrix-cols em)))
  		(rows (- (matrix-rows em) 2))
  		(cols n))
  	(let loop-r ((r rows))
  	  (unless (= r -1)
  	  	(let loop-c ((c 0))
  	  	  (unless (= c cols)
  	  	  	;; we want to take the best direction of the neighboring
  	  	  	;; columns in the row below it. it will either be -1, 0, or 1
  	  	  	(let ((best (best-direction
  	  	  				  (cropped-matrix-ref cm (+ r 1) (- c 1) n)
  	  	  				  (cropped-matrix-ref cm (+ r 1) c n)
  	  	  				  (cropped-matrix-ref cm (+ r 1) (+ c 1) n))))
  	  	  	  ;; we do (+ c best) because best will either be -1, 0, or 1
  	  	  	  ;; so it will either be 1 less col, same col, or 1 more col.
  	  	  	  (matrix-set! sm r c (+ c best))
  	  	  	  (matrix-set! cm r c (+ (matrix-ref cm r c)
  	  	  	  						 (matrix-ref cm (+ r 1) (+ c best))))
  	  	  	  (loop-c (+ c 1)))))
  	  	(loop-r (- r 1))))
  	;; once all the above stuff has been evaluated
  	(walk-seam sm (seam-origin cm n))))


(define (least-energy-seam1 em n)
  (let ((cm (matrix-copy em))
  		(sm (make-matrix (matrix-rows em) (matrix-cols em)))
  		(rows (- (matrix-rows em) 2))
  		(cols n))
  	(let loop-r ((r rows))
  	  (when (> r -1)
  	  	(let loop-c ((c 0))
  	  	  (when (< c cols)
  	  	  	(let ((best (best-direction
  	  	  				  (cropped-matrix-ref cm (+ r 1) (- c 1) n)
  	  	  				  (cropped-matrix-ref cm (+ r 1) c n)
  	  	  				  (cropped-matrix-ref cm (+ r 1) (+ c 1) n))))
  	  	  	  (matrix-set! sm r c (+ c best))
  	  	  	  (matrix-set! cm r c (+ (matrix-ref cm r c)
  	  	  	  						 (matrix-ref cm (+ r 1) (+ c best))))
  	  	  	  (loop-c (+ c 1)))))
  	  	(loop-r (- r 1))))
  	(walk-seam sm (seam-origin cm n))))
  	  		           
 


; ------------------------------------------------------------------------
; Problem 8

(define (image-seam-carve! img sm n)
  (let outer ((r 0) (cols sm))
  	(if (null? cols)
  	    img
  	    (let inner ((r r) (c (car cols)))
  	      (if (= (+ r 1) (image-rows img))
  	  	      (inner 0 (+ c 1))
  	  	      (if (= (+ c 1) n)
  	  	          (outer (+ r 1) (cdr cols))
  	  	          (begin
  	  	            (image-set! img r c (image-ref img r (+ c 1)))
  	  	            (inner r (+ c 1)))))))))


(define (image-seam-carve1! img sm n)
  (let iter ((r 0) (c (list-ref sm 0)))
  	(cond
  	  ((and (= (+ c 1) n) (= (+ r 1) (image-rows img))) img)
  	  ((= (+ c 1) n)
  	   (iter (+ r 1) (list-ref sm r)))
  	  (else
  	  	(begin
  	  	  (image-set! img r c (image-ref img r (+ c 1)))
  	  	  (iter r (+ c 1)))))))


; ----------------------------------------------------------------------
; Problem 9

(define (content-aware-resize img-orig pixels)
  (let iter ((p pixels)
  			 (img (image-copy img-orig))
  			 (n (- (image-cols img-orig) 1)))
  	(let* ((em (make-energy-matrix img))
  		   (sm (least-energy-seam em n)))
  	  (if (zero? p)
  	  	  (image-crop img pixels)
  	  	  (iter (- p 1)
  	  	  		(image-seam-carve! img sm n)
  	  	  		(- n 1))))))


; ----------------------------------------------------------------------
; Problem 10

#|
I have been unsucessfully trying to get this procedure to work. 
Instead of creating the energy matrix at each step, I am 
attempting to left-shift the matrix elements along the seam
in a similar manner to image-seam-carve!. I then will set
the item to the left of the column to the energy at the position,
and do the same for the item to the right...

|#

(define (better-content-aware-resize img-orig pixels)
  (define (matrix-seam-carve! img mat sm n)
  	(let iter ((r 0))
  	  (when (< r (image-rows img))
  	  	(let ((c (list-ref sm r)))
  	  	  (matrix-set! mat r (- c 1) (matrix-ref mat r c))
  	  	  (matrix-set! mat r c (matrix-ref mat r (+ c 1)))
  	  	  (matrix-set! mat r (+ c 1) (matrix-ref mat r (+ c 2)))
  	  	  (matrix-set! mat (+ r 1) (- c 1) (matrix-ref mat (+ r 1) c))
  	  	  (matrix-set! mat (+ r 1) c (matrix-ref mat (+ r 1) (+ c 1)))
  	  	  (matrix-set! mat (+ r 1) (+ c 1) (matrix-ref mat (+ r 1) (+ c 2)))
  	  	  (matrix-set! mat r (- c 1) (energy img r (- c 1)))
  	  	  (matrix-set! mat r c (energy img r c))
  	  	  (matrix-set! mat r (+ c 1) (energy img r (+ c 1)))
  	  	  (iter (+ r 1)))))
  	mat)
  (let iter ((p pixels)
  			 (img (image-copy img-orig))
  			 (n (- (image-cols img-orig) 1))
  			 (em (make-energy-matrix img)))
  	(let ((sm (least-energy-seam em n)))
  	  (if (zero? p)
  	  	  (image-crop img pixels)
  	  	  (iter (- p 1)
  	  	  		(image-seam-carve! img sm n)
  	  	  		(- n 1)
  	  	  		(matrix-seam-carve! img em sm n))))))
 
(define (better-content-aware-resize1 img-orig pixels)
  (define (matrix-seam-carve! img mat sm n)
  	(let outer ((r 0) (cols sm))
  	  (if (null? cols)
  	    mat
  	    (let inner ((r r) (c (car cols)))
  	      (if (= (+ r 1) (image-rows img))
  	      	  (inner 0 (+ c 1))
  	      	  (if (= (+ c 1) n)
  	      	  	  (outer (+ r 1) (cdr cols))
  	      	  	  (begin
  	      	  	  	(matrix-set! mat r c (matrix-ref mat r (+ c 1)))
  	      	  	  	(matrix-set! mat r (- c 1) (energy img r (- c 1)))
  	      	  	  	(matrix-set! mat r (+ c 1) (energy img r (+ c 2)))
  	      	  	  	;(matrix-set! mat r (+ c 2) (energy img r (+ c 2)))
  	      	  	  	(inner r (+ c 1)))))))))
  (let iter ((p pixels)
  			 (img (image-copy img-orig))
  			 (n (- (image-cols img-orig) 1))
  			 (em (make-energy-matrix img)))
  	(let ((sm (least-energy-seam em n)))
  	  (if (zero? p)
  	  	  (image-crop img pixels)
  	  	  (begin
  	  	  	(image-seam-carve! img sm n)
  	  	  	(iter (- p 1)
  	  	  		  img
  	  	  		  (- n 1)
  	  	  		  (matrix-seam-carve! img em sm n)))))))

