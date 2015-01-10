
; 3.1 assignment and local state

;3.1.1 Local State Variables


(define balance 100)

(define (withdraw amount)
  (if (>= balance amount)
  	  (begin (set! balance (- balance amount))
  	  		 balance)
  	  "Insufficient Funds"))


; balance internal to withdraw:

(define withdraw
  (let ((balance 100))
  	(lambda (amount)
  	  (if (>= balance amount)
  	  	  (begin (set! balance (- balance amount))
  	  	  		 balance)
  	  	  "Insufficient Funds"))))


; make-withdraw creates "withdrawal processors"

(define (make-withdraw balance)
  (lambda (amount)
  	(if (>= balance amount)
  	    (begin (set! balance (- balance amount))
  	    	   balance)
  	    "Insufficient Funds")))



(define (make-account balance)
  (define (withdraw amount)
  	(if (>= balance amount)
  	    (begin (set! balance (- balance amount))
  	    	   balance)
  	    "Insufficient Funds"))
  (define (deposit amount)
  	(set! balance (+ balance amount))
  	balance)
  (define (dispatch m)
  	(cond ((eq? m 'withdraw) withdraw)
  		  ((eq? m 'deposit) deposit)
  		  (else (error "Unknown Request -- MAKE-ACCOUNT" m))))
  dispatch)


; Exercises 
; 3.1
; Write a procedure make-accumulator that generates accumulators,
; each maintaining an independent sum 
;
; (define a (make-accumulator 5))
; (a 10)
; => 15

(define (make-accumulator sum)
  (lambda (amount)
  	(set! sum (+ sum amount)) sum))

; 3.2
; write a procedure make-monitored that takes
; as input a procedure f, that itself takes one input. 
; the result returned is a third procedure, say mf, that 
; keeps track of the number of time it has been called by 
; mainiting an internal counter. If the input to mf is the special symbol
; how-many-calls?, then mf returns the value of the counter. 
; if the input is the special symobl, reset-count, then mf resets the 
; counter to sero. For any other input, mf returns the result of 
; calling f on that input and increments the counter.
;
; (define s (make-monitored sqrt))
; (s 100)
; 10
; (s 'how-many-calls?)
; 1

(define (make-monitored f)
  (let ((counter 0))
  	(lambda (arg)
  	  (cond ((eq? arg 'how-many-calls?) counter)
  	  		((eq? arg 'reset-count)
  	  		 (begin (set! counter 0) counter))
  	  		(else 
  	  		  (begin (set! arg (f arg))
  	  		  		 (set! counter (+ counter 1))
  	  		  		 arg))))))


; 3.3
; modify make-account so that it creates password-protected
; accounts. That is, make-account should takte a symbol as an 
; additional argument, as in
; (define acc (make-account 100 'secret-password))
; The resulting account object should process a request only if
; it is accompaniedby the password it was created with.
;
; ((acc 'secret-password 'withdraw) 40)
; => 60
; ((acc 'some-other-password 'deposit) 50)
; => "Incorrect Password"

(define (make-account balance password)
  (define (withdraw amount)
  	(if (>= balance amount)
  	    (begin (set! balance (- balance amount))
  	    	   balance)
  	    "Insufficient Funds"))
  (define (deposit amount)
  	(set! balance (+ balance amount))
  	balance)
  (define (dispatch m p)
  	(cond ((and (eq? m 'withdraw) (eq? p password))
  		   withdraw)
  		  ((and (eq? m 'deposit) (eq? p password))
  		   deposit)
  		  ((not (eq? p password)) 
  		   (error "Incorrect Password"))
  		  (else (error "Unknown Request -- MAKE-ACCOUNT" m))))
  dispatch)


; 3.4
; Modify the make-account procedure of exercise 3.3 by adding another local
; state variable so that, if an account is accessed more than seven 
; consecutive times with an incorrect password, it invokes the procedure
; call-the-cops.

(define (make-account balance password)
  (let ((incorrect-attempts 0))
  	(define (withdraw amount)
  	  (if (>= balance amount)
  	      (begin (set! balance (- balance amount))
  	    	     balance)
  	      "Insufficient Funds"))
    (define (deposit amount)
  	  (set! balance (+ balance amount))
  	  balance)
    (define (dispatch m p)
  	  (cond ((and (eq? m 'withdraw) (eq? p password)) 
  	  		 (set! incorrect-attempts 0) withdraw)
  		    ((and (eq? m 'deposit) (eq? p password))
  		     (set! incorrect-attempts 0) deposit)
  		    ((= incorrect-attempts 7) (call-the-cops))
  		    ((not (eq? p password)) 
  		     (begin (set! incorrect-attempts (+ incorrect-attempts 1))
  		     		incorrect-attempts))
  		    (else (error "Unknown Request -- MAKE-ACCOUNT" m))))
  	dispatch))



; -------------------------------------------------------------------------
; 3.1.2 The Benefits of Introducing Assignment 

; x2 = (rand-update x1)
; x3 = (rand-update x2)

(define rand
  (let ((x random-init))
  	(lambda ()
  	  (set! x (rand-update x)) x)))


; using rand so we have assignment

(define (estimate-pi trials)
  (sqrt (/ 6 (monte-carlo trials cesaro-test))))

(define (cesaro-test)
  (= (gcd (rand) (rand)) 1))

(define (monte-carlo trials experiment)
  (define (iter trials-remaining trials-passed)
  	(cond ((= trials-remaining 0) (/ trials-passed trials))
  		  ((experiment) (iter (- trials-remaining 1) (+ trials-remaining 1)))
  		  (else (iter (- trials-remaining 1) trials-passed))))
  (iter trials 0))



; same thing a above, except we use rand-update instead of rand
; this means that we do not use assignment to model local state

(define (estimate-pi trials)
  (sqrt (/ 6 (random-gcd-tests trials random-init))))

(define (random-gcd-tests trials initial-x)
  (define (iter trials-remaining trials-passed x)
  	(let* ((x1 (rand-update x))
  		   (x2 (rand-updae x1)))
  	  (cond ((= trials-remaining 0) (/ trials-passed trials))
  	  		((= (gcd x1 x2) 1)
  	  		 (iter (- trials-remaining 1) (+ trials-passed 1) x2))
  	  		(else (iter (- trials-remaining 1) trials-passed x2)))))
  (iter trials 0 initial-x))

; ----------------------------------------------------------------------
; Exercises

#|
 3.5
 Monte Carlo integration is a method of estimating definite integrals by
 means of Monte Carlo simulation. Consider computing the area of a region
 of space described by a predicate P(x,y) that is true for points (x,y) in
 the region and false for points not in the region. For example, the region
 contained withina circle of 3 centered at (5,7) is described by the 
 predicate that tests whether (x-5)^2 + (y-7)^2 =< 3^2. To est. the area
 of the region described by such a predicate, begin by choosing a rectangle
 that contains the region. For example, a rectangle w. diagonally opposite 
 corners at (2,4) and (8,10) contains the circle above. The desired integral
 is the area of that portion of the rectangle that lies in the region. We 
 canest the integral by picking, at random, points (x,y) that lie in the 
 rectangle, and testing P(x,y) for each point to determine whether the point
 lies in the region. If we try this w/ many points, then the fraction of 
 points that fall in the region should give an est of the proportion of 
 the rectangle that liesin the region. Thus, multiplying this fraction
 by the area of the rect. should produce an est. of the integral. 

 Implement Monte Carlo integration as a procedure estimate-integral that
 takes as arguments a Predicate P, upper and lower bounds x1,x2,y1, and y2
 for the rect., and the number of trials to perform in order to produce
 the est. 

 You will find it useful to have a procdure that returns a number chosen
 at random from a given range. Below, random-in-range implements this, and
 returns a non-negatvie number less than its input. 

|#

(define (random-in-range low high)
  (let ((range (- high low)))
  	(+ low (random range))))

(define (square x) (* x x))

(define (estimate-integral P x1 x2 y1 y2 trials)
  (define (test)
  	(P (random-in-range x1 x2) (random-in-range y1 y2)))
  (* (* (- x1 x2) (- y1 y2))
  	 (monte-carlo trials test)))

(define (estimate-pi trials)
  (define (P x y)
  	(<= (+ (square x) (square y)) 1.0))
  (estimate-integral P -1.0 1.0 -1.0 1.0 trials))





#|
 3.6
 It is useful to be able to reset a random-number generator to produce a 
 sequence starting from a given value. Design a new rand procedure that 
 is called w. an argument that is either the symbol generate or the 
 symbol reset and behaves as follows:
 (rand 'generate) produces a new random number. 
 ((rand 'reset) <new-value>) resets the internal state variable to the
 designated <new-value>. 

|#

(define rand
  (let ((x random-init))
  	(lambda ()
  	  (set! x (rand-update x)) x)))


(define (rand-init)
  (random 100))

(define (rand-update x)
  (let ((y (rand-init)))
  	(if (not (= x y))
  	    y
  	    (rand-update y))))

(define rand
  (let ((x rand-init))
  	(define (dispatch m)
  	  (cond ((eq? m 'generate)
  	  		 (begin (set! x (rand-update x)) x))
  	  		((eq? m 'reset)
  	  		 (lambda (new-value)
  	  		   (set! x new-value)))
  	  		(else (error "blah" m))))
  	dispatch))


(+ 3 (estimate-pi 100000))


;-------------------------------------------------------
; 3.1.3 The Costs of Introducing Assignment

(define (make-simple-withdraw balance)
  (lambda (amount)
  	(set! (balance (- balance amount))
  	  balance)))

(define w (make-simple-withdraw 25))
; (w 20) => 5
; (w 10) => -5


(define (make-decrementer balance)
  (lambda (amount)
  	(- balance amount)))

(define d (make-decrementer 25))
;(d 20) => 5
;(d 10) => 15


(define (factorial n)
  (define (iter product counter)
  	(if (> counter n)
  	    product
  	    (iter (* counter product)
  	    	  (+ counter 1))))
  (iter 1 1))


(define (factorial n)
  (let ((product 1)
  		(counter 1))
  	(define (iter)
  	  (if (> counter n)
  	  	  prodcut
  	  	  (begin (set! product (* counter product))
  	  	  		 (set! counter (+ counter 1))
  	  	  		 (iter))))
  	(iter)))


; ----------------------------------------------
; Exercises
;
; 3.7
#|
Define a procedure make-joint that takes 3 arguments. 
The first is a password-protected account. The second
must match the password with whichthe account was dfined 
in order for the make-joint operation to proceed. The third
is a new password. make-join is to create additional access
to the original account using the new password. For example,
if peter-acc is a bank acount w/ password open-sesame, then:

(define paul-acc
  (make-joint peter-acc 'open-sesame 'rosebud))

will allow one ot make transactions on peter-acc using the 
name paul-acc and the password rosebud. 


(define (make-account balance password)
  (define (withdraw amount)
  	(if (>= balance amount)
  	    (begin (set! balance (- balance amount))
  	    	   balance)
  	    "Insufficient Funds"))
  (define (deposit amount)
  	(set! balance (+ balance amount))
  	balance)
  (define (make-joint acc pass new-pass)
  	(if (eq? pass password)
  	    (dispatch 
  (define (dispatch m p)
  	(cond ((and (eq? m 'withdraw) (eq? p password))
  		   withdraw)
  		  ((and (eq? m 'deposit) (eq? p password))
  		   deposit)
  		  ((not (eq? p password)) 
  		   (error "Incorrect Password"))
  		  (else (error "Unknown Request -- MAKE-ACCOUNT" m))))
  dispatch)


|#

#|
3.8 

Define a simple procedure f, such that evaluating 
(+ (f 0) (f 1)) will return 0 if the arguments to 
+ are evaluated from left to right, but will return 
1 if the arguments are evaluated from right to left.

|#

(define f
  (let ((state 0))
  	(define (switch-state x)
  	  (let ((old-state state))
  	   (set! state (+ x state))
  	   old-state))
  	switch-state))


(+ (f 1) (f 0))
