#|
; 3.3.1


(define (cons x y)
  (let ((new (get-new-par)))
  	(set-car! new x)
  	(set-cdr! new y)
  	new))


; exercises

; 3.12

#|
(define (append x y)
  (if (null? x)
  	  y
  	  (cons (car x) (append (cdr x) y))))

(define (append! x y)
  (set-cdr! (last-pair x) y)
  x)

|#

(define (last-pair x)
  (if (null? (cdr x))
  	  x
  	  (last-pair (cdr x))))


(define x (list 'a 'b))
(define y (list 'c 'd))
(define z (append x y))

;z => (a b c d)
;(cdr x) => (b)

(define w (append! x y))
; w => (a b c d)
; (cdr x) => (b c d)


; 3.13

(define (make-cycle x)
  (set-cdr! (last-pair x) x)
  x)

(define z (make-cycle (list 'a 'b 'c)))

; ^^ this is an infinite cycle. 

; 3.14

(define (mystery x)
  (define (loop x y)
  	(if (null? x)
  	    y
  	    (let ((temp (cdr x)))
  	      (set-cdr! x y)
  	      (loop temp x))))
  (loop x '()))

(define v (list 'a 'b 'c 'd))
; v => (a b c d)

(define w (mystery v))
; v => (a)
; w => (d c b a



; Sharing and Identity

(define x (list 'a 'b))
(define z1 (cons x x))
(define z2 (cons (list 'a 'b) (list 'a 'b)))

; z1 => ((a b) a b)
; z2 => ((a b) a b)

(define (set-to-wow! x)
  (set-car! (car x) 'wow)
  x)

; (set-to-wow! z1) => ((wow b) wow b)
; (set-to-wow! z2) => ((wow b) a b)


; Exercises 


; 3.17

(define (count-pairs x)
  (let ((aux '()))
  	(define (count z)
  	  (cond ((not (pair? z)) 0)
  	  		((memq z aux) 0)
  	  		(else 
  	  		  (if (null? aux)
  	  		  	  (set! aux (list z))
  	  		  	  (set-cdr! (last-pair aux) (list z)))
  	  		  (+ (count (car z))
  	  		  	 (count (cdr z))
  	  		  	 1))))
  	(count x)))

; 3.18

(define (cycle? ls)
  (let iter ((ls ls) (visited '()))
  	(set! visited (cons ls visited))
  	(cond ((null? (cdr ls)) #f)
  		  ((memq (cdr ls) visited) #t)
  		  (else (iter (cdr ls))))))
; 3.19

(define (cycle2? ls)
  (define (safe-cdr l)
  	(if (pair? l)
  	    (cdr l)
  	    '()))
  (let iter ((a (safe-cdr ls)) (b (safe-cdr (safe-cdr ls))))
  	(cond ((not (pair? a)) #f)
  		  ((not (pair? b)) #f)
  		  ((eq? a b) #t)
  		  ((eq? a (safe-cdr b)) #t)
  		  (else (iter (safe-cdr a) (safe-cdr (safe-cdr b)))))))
|#

#|
; --------------------------------------------------------------------
; 3.3.2 Representing Queues

(define (front-ptr queue) (car queue))
(define (rear-ptr queue) (cdr queue))
(define (set-front-ptr! queue item) (set-car! queue item))
(define (set-rear-ptr! queue item) (set-cdr! queue item))

(define (empty-queue? queue) (null? (front-ptr queue)))

(define (make-queue) (cons '() '()))

(define (front-queue queue)
  (if (empty-queue? queue)
  	  (error "FRONT! called with an empty queue" queue)
  	  (car (front-ptr queue))))

(define (insert-queue! queue item)
  (let ((new-pair (cons item '())))
  	(cond ((empty-queue? queue)
  		   (set-front-ptr! queue new-pair)
  		   (set-rear-ptr! queue new-pair)
  		   queue)
  		  (else 
  		  	(set-cdr! (rear-ptr queue) new-pair)
  		  	(set-rear-ptr! queue new-pair)
  		  	queue))))

(define (delete-queue! queue)
  (cond ((empty-queue? queue)
  		 (error "DELETE! called with an empty queue" queue))
  		(else
  		  (set-front-ptr! queue (cdr (front-ptr queue)))
  		  queue)))


; exercises 
; 3.21


(define q1 (make-queue))
(insert-queue! q1 'a)

(define (print-queue queue)
  (front-ptr queue))


; 3.22

(define (make-queue)
  (let ((front-ptr '())
  		(rear-ptr '()))
  	(define (empty-queue? queue) (null? (front-ptr queue)))
  	(define (set-front-ptr! queue item) (set! front-ptr item))
  	(define (set-rear-ptr! queue item) (set! rear-ptr item))
  	(define (front-queue queue)
  	  (if (empty-queue? queue)
  	  	  (error "FRONT! called with an empty queue" queue)
  	  	  (car (front-ptr queue))))
  	(define (insert-queue! queue item)
  	  (let ((new-pair (cons item '())))
  	  	(cond ((empty-queue? queue)
  	  		   (set-front-ptr! queue new-pair)
  	  		   (set-rear-ptr! queue new-pair))
  	  		  (else
  	  		  	(set-cdr! (rear-ptr queue) new-pair)
  	  		  	(set-rear-ptr! queue new-pair)))))
  	(define (delete-queue! queue)
  	  (if (empty-queue? queue)
  	  	  (error "DELETE! called with an empty queue" queue)
  	  	  (set-front-ptr! queue (cdr (front-ptr queue)))))
  	(define (print-queue) front-ptr)
  	(define (dispatch m)
  	  (cond ((eq? m 'empty-queue) empty-queue?)
  	  		((eq? m 'front-queue) front-queue)
  	  		((eq? m 'insert-queue) insert-queue!)
  	  		((eq? m 'delete-queue) delete-queue!)
  	  		((eq? m 'print-queue) print-queue)
  	  		(else (error "undefined operation -- QUEUE" m))))
  	dispatch))


; 3.23

(define (make-deque) (cons '() '()))
(define (front-ptr deque) (car deque))
(define (rear-ptr deque) (cdr deque))
(define (empty-deque? deque) (null? (front-ptr deque)))
(define (set-front! deque item) (set-car! deque item))
(define (set-rear! deque item) (set-cdr! deque item))

(define (get-item deque end)
  (if (empty-deque? deque)
  	  (error "GET-ITEM called with an empty deque" deque)
  	  (caar (end deque))))

(define (insert-deque! deque item end)
  (let ((new-pair (cons (cons item '()) '())))
  	(cond ((empty-deque? deque)
  		   (set-front! deque new-pair)
  		   (set-rear! deque new-pair))
  		  ((eq? end 'front)
  		   (set-cdr! new-pair (front-ptr deque))
  		   (set-cdr! (car (front-ptr deque)) new-pair)
  		   (set-front! deque new-pair))
  		  (else (set-cdr! (rear-ptr deque) new-pair)
  		  		(set-cdr! (car new-pair) (rear-ptr deque))
  		  		(set-rear! deque new-pair)))))

(define (front-delete-deque deque)
  (cond ((empty-deque? deque)
  		 (error "FRONT-DELETE! called with an empty deque" deque))
  		(else
  		  (set-front! deque (cdr (front-ptr deque)))
  		  (or (empty-deque? deque) 
  		  	  (set-cdr! (car (front-ptr deque)) '())))))


(define (rear-delete-deque deque)
  (cond ((empty-deque? deque)
  		 (error "REAR-DELETE called with an empty deque" deque))
  		(else (set-rear! deque (cdar (rear-ptr deque)))
  			  (if (null? (rear-ptr deque))
  			  	  (set-front! deque '())
  			  	  (set-cdr! (rear-ptr deque '()))))))

(define (front-insert-deque! deque item)
  (insert-deque! deque item 'front))

(define (rear-insert-deque! deque item)
  (insert-deque! deque item 'rear))

(define (front-deque deque) (get-item deque front-ptr))
(define (rear-deque deque) (get-item deque rear-ptr))

(define (print-deque d)
  (let iter ((res '()) (d d))
  	(if (or (null? d) (empty-deque? d))
  	   res
  	   (iter (append res (list (caaar d))) (cons (cdar d) (cdr d))))))


|#
; ----------------------------------------------------------
; 3.3.3 Representing Tables

; 1-D tables

(define (lookup key table)
  (let ((record (assoc key (cdr table))))
  	(if record
  	    (cdr record)
  	    #f)))

(define (assoc key records)
  (cond ((null? records) #f)
  		((equal? key (caar records)) (car records))
  		(else (assoc key (cdr records)))))

(define (insert! key value table)
  (let ((record (assoc key (cdr table))))
  	(if record
  	  (set-cdr! record value)
  	  (set-cdr! table (cons (cons key value) (cdr table)))))
  'ok)

(define (make-table1) (list '*table*))

; 2-D tables

#|
(define (lookup key-1 key-2 table)
  (let ((subtable (assoc key-1 (cdr table))))
  	(if subtable
  	    (let ((record (assoc key-2 (cdr subtable))))
  	      (if record
  	      	  (cdr record)
  	      	  #f))
  	    #f)))

(define (insert! key-1 key-2 value table)
  (let ((subtable (assoc key-1 (cdr table))))
  	(if subtable
  	    (let ((record (assoc key-2 (cdr subtable))))
  	      (if record
  	      	  (set-cdr! record value)
  	      	  (set-cdr! subtable (cons (cons key-2 value) (cdr subtable)))))
  	    (set-cdr! table (cons (list key-1 (cons key-2 value)) (cdr table)))))
  'ok)
|#

; Creating local tables

(define (make-table)
  (let ((local-table (list '*table*)))
  	(define (lookup key-1 key-2)
  	  (let ((subtable (assoc key-1 (cdr local-table))))
  	  	(if subtable
  	  	    (let ((record (assoc key-2 (cdr subtable))))
  	  	      (if record
  	  	      	  (cdr record)
  	  	      	  #f))
  	  	    #f)))
  	(define (insert! key-1 key-2 value)
  	  (let ((subtable (assoc key-1 (cdr local-table))))
  	  	(if subtable
  	  	    (let ((record (assoc key-2 (cdr subtable))))
  	  	      (if record
  	  	      	  (set-cdr! record value)
  	  	      	  (set-cdr! subtable (cons (cons key-2 value) (cdr subtable)))))
  	  	    (set-cdr! local-table (cons (list key-1 (cons key-2 value))
  	  	    							(cdr local-table)))))
  	  'ok)
  	(define (dispatch m)
  	  (cond ((eq? m 'lookup-proc) lookup)
  	  		((eq? m 'insert-proc!) insert!)
  	  		(else (error "Unknown Operation -- TABLE" m))))
  	dispatch))


(define operation-table (make-table))

; get takes 2 keys
(define get (operation-table 'lookup-proc))

; put takes 2 keys and a value
(define put (operation-table 'insert-proc!))


; Exercises

#|
; 3.24
(define (make-table same-key?)
  (let ((local-table (list '*table*)))
  	(define (assoc key records)
  	  (cond ((null? records) #f)
  	  		((same-key? key (caar records)) (car records))
  	  		(else (assoc key (cdr records)))))
  	(define (lookup key-1 key-2)
  	  (let ((subtable (assoc key-1 (cdr local-table))))
  	  	(if subtable
  	  	    (let ((record (assoc key-2 (cdr subtable))))
  	  	      (if record
  	  	      	  (cdr record)
  	  	      	  #f))
  	  	    #f)))
  	(define (insert! key-1 key-2 value)
  	  (let ((subtable (assoc key-1 (cdr local-table))))
  	  	(if subtable
  	  	    (let ((record (assoc key-2 (cdr subtable))))
  	  	      (if record
  	  	      	  (set-cdr! record value)
  	  	      	  (set-cdr! subtable (cons (cons key-2 value) (cdr subtable)))))
  	  	    (set-cdr! local-table (cons (list key-1 (cons key-2 value))
  	  	    							(cdr local-table)))))
  	  'ok)
  	(define (dispatch m)
  	  (cond ((eq? m 'lookup-proc) lookup)
  	  		((eq? m 'insert-proc!) insert!)
  	  		(else (error "Unknown Operation -- TABLE" m))))
  	dispatch))

; 3.25

; 1-d
(define table1 (make-table1))
(insert! '(a) 2 table1)
(insert! '(b) 3 table1)
(insert! 'c 4 table1)

(lookup '(a) table1)
(lookup '(b) table1)
(lookup 'c table1)

; 2-D

(define table2 (make-table))
(define get2 (table2 'lookup-proc))
(define put2 (table2 'insert-proc!))

(put2 'a 'x 2)
(put2 'a 'y 3)
(put2 'a 'z 4)
(put2 'b '1 10)
(put2 'b '2 25)
(put2 'b '3 400)
(put2 'c 'r 'hello)
(put2 'c 'd 'world)

(get2 'a 'x)
(get2 'a 'z)

(get2 'b '2)
(get2 'c 'r)


; 3.27
; memoization fib

(define memo-fib
  (memoize (lambda (n)
  			 (cond ((= n 0) 0)
  			 	   ((= n 1) 1)
  			 	   (else (+ (memo-fib (- n 1))
  			 	   			(memo-fib (- n 2))))))))

(define (memoize f)
  (let ((table (make-table)))
  	(lambda (x)
  	  (let ((previously-computed-result (lookup x table)))
  	  	(or previously-computed-results
  	  		(let ((result (f x)))
  	  		  (insert! x result table)
  	  		  result))))))



|#
; -----------------------------------------------------
; 3.3.4 A Simulator for Digital Circuits

#|

(define a (make-wire))
(define b (make-wire))
(define c (make-wire))
(define d (make-wire))
(define e (make-wire))
(define s (make-wire))

|#

(define (half-adder a b s c)
  (let ((d (make-wire))
  		(e (make-wire)))
  	(or-gate a b d)
  	(and-gate a b c)
  	(inverter c e)
  	(and-gate d e s)
  	'ok))

(define (full-adder a b c-in sum c-out)
  (let ((s (make-wire))
  		(c1 (make-wire))
  		(c2 (make-wire)))
  	(half-adder b c-in s c1)
  	(half-adder a s sum c2)
  	(or-gate c1 c2 c-out)
  	'ok))

#|

(get-signal <wire>) - returns the current value of the signal onthe wire
(set-signal! <wire> <new value>) - changes value of the signal to the new-wire
(add-action! <wire> <procedure of no arguments>)

|#

(define (inverter input output)
  (define (invert-input)
  	(let ((new-value (logical-not (get-signal input))))
  	  (after-delay inverter-delay
  	  			   (lambda ()
  	  			   	 (set-signal! output new-value)))))
  (add-action! input invert-input)
  'ok)

(define (logical-not s)
  (cond ((= s 0) 1)
  		((= s 1) 0)
  		(else (error "Invalid Signal" s))))

(define (and-gate a1 a2 output)
  (define (and-action-procedure)
  	(let ((new-value (logical-and (get-signal a1) (get-signal a2))))
  	  (after-delay and-gate-delay
  	  			   (lambda ()
  	  			   	 (set-signal! output new-value)))))
  (add-action! a1 and-action-procedure)
  (add-action! a2 and-action-procedure)
  'ok)

; Exercises

; 3.28 
; Define an or-gate procedure

(define (or-gate a1 a2 output)
  (define (or-action-procedure)
  	(let ((new-value (logical-or (get-signal a1) (get-signal a2))))
  	  (after-delay or-gate-delay
  	  			   (lambda ()
  	  			   	 (set-signal! output new-value)))))
  (add-action! a1 or-action-procedure)
  (add-action! a2 or-action-procedure)
  'ok)

; 3.29
;
; a) (A or B) == (not ((not A) and (not B)))

(define (or-gate a1 a2 output)
  (let ((c1 (make-wire))
  		(c2 (make-wire))
  		(c3 (make-wire)))
  	(inverter a1 c1)
  	(inverter a2 c2)
  	(and-gate c1 c2 c3)
  	(inverter c3 output)))

; b) the delay is the sum of of and-gate-delay plus (* 2 inverter-delay)

; 3.30

(define (ripple-carry-adder a b s c)
  (let ((c-in (make-wire)))
  	(if (null? (cdr a))
  	    (set-signal! c-in 0)
  	    (ripple-carry-adder (cdr a) (cdr b) (cdr s) c-in))
  	(full-adder (car a) (car b) c-in (car s) c)))

#|
the ripple-carry-adder delay is 
= n * full-adder-delay
= n * (2 * half-adder-delay + or-gate-delay) 
= n * (2 * max(and-gate-delay+inverter-delay, or-gate-delay)
	    + and-gate-dleay) + or-gate-delay
