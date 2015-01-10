; The Metacircular Evaluator

; 4.1.1 The Core of the Evaluator

#|
; eval
(define (eval exp env)
  (cond ((self-evaluating? exp) exp)
  		((variable? exp) (lookup-variable-value exp env))
  		((quoted? exp) (text-of-quotation exp))
  		((assignment? exp) (eval-assignment exp env))
  		((definition? exp) (eval-definition exp env))
  		((if? exp) (eval-if exp env))
  		((lambda? exp)
  		 (make-procedure (lambda-parameters exp)
  		 				 (lambda-body exp)
  		 				 env))
  		((begin? exp) (eval-sequence (begin-actions exp) env))
  		((cond? exp) (eval (cond->if exp) env))
  		((application? exp)
  		 (apply (eval (operator exp) env)
  		 		(list-of-values (operands exp) env)))
  		(else 
  		  (error "Unknown expression type -- EVAL" exp))))


; apply
(define (apply procedure arguments)
  (cond ((primative-procedure? procedure)
  		 (apply-primative-procedure procedure arguments))
  		((compound-procedure? procedure)
  		 (eval-sequence
  		   (procedure-body procedure)
  		   (extend-environment
  		   	 (procedure-parameters procedure)
  		   	 arguments
  		   	 (procedure-environment procedure))))
  		(else
  		  (error "Unknown procedure type -- APPLY" procedure))))


; list-of-values
; when eval processes a procedure appliciton, it uses list-of-values
; to produce a list of arguments to which the procedure is to be applied.

(define (list-of-values exps env)
  (if (no-operands? exps)
  	  '()
  	  (cons (eval (first-operand exps) env)
  	  		(list-of-values (rest-operands exps) env))))


; eval-if
; tests the predicate part of an if expression in the given env. 
; if the result is true, eval-if evaluates the consequent, 
; otherwise it evaluates the alternative. 
(define (eval-if exp env)
  (if (true? (eval (if-predicate exp) env))
  	  (eval (if-consequent exp) env)
  	  (eval (if-alternative exp) env)))


; eval-sequence
; used by apply to evaluate the sequene of expressions in a procedure
; body, and by eval to evaluate the sequence in a begin expression.
(define (eval-sequence exps env)
  (cond ((last-exp? exps) (eval (first-exp exps) env))
  		(else (eval (first-exp exps) env)
  			  (eval-sequence (rest-exps exps) env))))


; eval-assignment
; it calls eval to find the value to be assigned and 
; transmits the variable and the resulting value to set-variable-value!
; to be installed in the designated environment.

(define (eval-assignment exp env)
  (set-variable-value! (assignment-variable exp)
  					   (eval (assignment-value exp) env)
  					   env)
  'ok)

; eval-definition
(define (eval-definition exp env)
  (define-variable! (definition-variable exp)
  					(eval (definition-value exp) env)
  					env)
  'ok)

; Exercises
; Ex 4.1

(define (list-of-values-LR exps env)
  (if (no-operands? exps)
  	  '()
  	  (let* ((first (eval (first-operand exps) env))
  	  		(rest (list-of-values-LR (rest-operands exps) env)))
  	  	(cons first rest))))

(define (list-of-values-RL exps env)
  (if (no-operands? exps)
  	  '()
  	  (let* ((rest (list-of-values-RL (rest-operands exps) env))
  	  		 (first (eval (first-operand exps) env)))
  	  	(cons first rest))))

; i think these 2 below are wrong... 
(define (list-of-values-LR exps env)
  (if (no-operands? exps)
  	  '()
  	  (let ((first (eval (first-operand exps) env)))
  	  	(cons first
  	  		  (list-of-values (rest-operands exps) env)))))

(define (list-of-values-RL exps env)
  (if (no-operands? exps)
  	  '()
  	  (let ((rest (list-of-values-RL (rest-operands exps) env)))
  	  	(cons (eval (first-operand exps) env)
  	  		  rest))))

;---------------------------------------------------------
; 4.1.2 Representing Expressions
;

; the only self-evaluating items are numbers and strings:
(define (self-evaluating? exp)
  (cond ((number? exp) #t)
  		((string? exp) #t)
  		(else #f)))

; variables are represented by symbols
(define (variable? exp) (symbol? exp))

; quotations have the form (quote <text of quotation>)
(define (quoted? exp)
  (tagged-list? exp 'quote))

(define (text-of-quotation exp) (cadr exp))

; tagged-list? identfies lists beginning w/ a designated symbol:
(define (tagged-list? exp tag)
  (if (pair? exp)
  	  (eq? (car exp) tag)
  	  #f))


; assignments have the form (set! <var> <value>)
(define (assignment? exp)
  (tagged-list? exp 'set!))

(define (assignment-variable exp) (cadr exp))
(define (assignment-value exp) (caddr exp))

; definitions have the form:
; (define <var> <value>
; or the form, 
; (define (<var> <parameter1> ... <parametern>)
;  <body>)
(define (definition? exp)
  (tagged-list? exp 'define))

(define (definition-variable exp)
  (if (symbol? (cadr exp))
  	  (cadr exp)
  	  (caadr exp)))

(define (definition-value exp)
  (if (symbol? (cadr exp))
  	  (caddr exp)
  	  (make-lambda (cdadr exp)   ; formal parameters
  	  			   (cddr exp)))) ; body


; lambda expressions are lists that begin w the symbol lambda:
(define (lambda? exp) (tagged-list? exp 'lambda))
(define (lambda-parameters exp) (cadr exp))
(define (lambda-body exp) (cddr exp))

; we also provide a constructor for lambda expressions, which 
; is used by definition-value:
(define (make-lambda parameters body)
  (cons 'lambda (cons parameters body)))

; conditionals begin w/ if and have a predicate, a consequent, and 
; an (optional) altervative. If the expression has no alt. part, 
; we provide false as the altervantive. 
(define (if? exp) (tagged-list? exp 'if))
(define (if-predicate exp) (cadr exp))
(define (if-consequent exp) (caddr exp))
(define (if-alternative exp)
  (if (not (null? (cdddr exp)))
  	  (cadddr exp)
  	  'false))

;we also provide a constructor for if expressions, to be used by cond->if 
;to transform cond expressions into if expressions:
(define (make-if predicate consequent alternative)
  (list 'if predicate consequent alternative))


; begin packages a sequence of expressions into a single expressions. 
; We include syntax operations onbegin expressions to extract the 
; actual sequence from the begin expression, as well as selectors that
; return the first expression and the rest of the exprssions in the sequence.

(define (begin? exp) (tagged-list? exp 'begin))
(define (begin-actions exp) (cdr exp))
(define (last-exp? seq) (null? (cdr seq)))
(define (first-exp? seq) (car seq))
(define (rest-exps seq) (cdr seq))

; we also include a constructor sequence-> exp (for use by cond->if)
; that transforms a sequence a single expression, using begin if needed:
(define (sequence->exp seq)
  (cond ((null? seq) seq)
  		((last-exp? seq) (first-exp seq))
  		(else (make-begin seq))))

(define (make-begin seq)
  (cons 'begin seq))


; a procedure application is any compound expression that is not one
; of the above expressiontypes. The car of the expression is the 
; operator, and the cdr is the list of operands:
(define (application? exp) (pair? exp))
(define (operator exp) (car exp))
(define (operands exp) (cdr exp))
(define (no-operands? ops) (null? ops))
(define (first-opearand ops) (car ops))
(define (rest-opearands ops) (cdr ops))


; Derived expressions

; we include syntax procedures that extract the parts of a cond expression, 
; and a procedure cond->if that transforms cond expressions into if expressions. 
; A case analysis begins with cond and has a list of predicate-action clauses.
; A clause is an else clause if its predicate is the symbol else:

(define (cond? exp) (tagged-list? exp 'cond))
(define (cond-clauses exp) (cdr exp))
(define (cond-else-clause? clause)
  (eq? (cond-predicate clause) 'else))
(define (cond-predicate clause) (car clause))
(define (cond-actions clause) (cdr clause))
(define (cond->if exp)
  (expand-clauses (cond-clauses exp)))
(define (expand-clauses clauses)
  (if (null? clauses)
  	  'false
  	  (let ((first (car clauses))
  	  		(rest (cdr clauses)))
  	  	(if (cond-else-clause? first)
  	  	    (if (null? rest)
  	  	        (sequence->exp (cond-actions first))
  	  	        (error "ELSE clause is not last -- COND->IF" clauses))
  	  	    (make-if (cond-predicate first)
  	  	    		 (sequence-exp (cond-actions first))
  	  	    		 (expand-clauses rest))))))


; Exercises

; 4.3
; eval
(define (eval exp env)
  (cond ((self-evaluating? exp) exp)
  		((variable? exp) (lookup-variable-value exp env))
  		((quoted? exp) (text-of-quotation exp))
  		((assignment? exp) (eval-assignment exp env))
  		((definition? exp) (eval-definition exp env))
  		((if? exp) (eval-if exp env))
  		((lambda? exp)
  		 (make-procedure (lambda-parameters exp)
  		 				 (lambda-body exp)
  		 				 env))
  		((begin? exp) (eval-sequence (begin-actions exp) env))
  		((cond? exp) (eval (cond->if exp) env))
  		((application? exp)
  		 (apply (eval (operator exp) env)
  		 		(list-of-values (operands exp) env)))
  		(else 
  		  (error "Unknown expression type -- EVAL" exp))))



; 4.4

(define (and? exp)
  (tagged-list? exp 'and))
(define (eval-and exp env)
  (define (eval-and-operands operands)
  	(cond ((null? operands) #t)
  		  ((true? (eval (car operands) env))
  		   (eval-and-operands (cdr operands)))
  		  (else #f)))
  (eval-and-operands (cdr exp)))

(define (or? exp)
  (tagged-list? exp 'or))
(define (eval-or exp env)
  (define (eval-or-operands operands)
  	(cond ((null? operands) #f)
  		  ((true? (eval (car operands) env)) #t)
  		  (else (eval-or-operands (cdr operands)))))
  (eval-or-operands (cdr exp)))

; 4.5

(define (cond? exp) (tagged-list? exp 'cond))
(define (cond-clauses exp) (cdr exp))
(define (cond-else-clause? clause)
  (eq? (cond-predicate clause) 'else))
(define (cond-predicate clause) (car clause))
(define (cond-actions clause) (cdr clause))
(define (cond->if exp)
  (expand-clauses (cond-clauses exp)))

(define (expand-clauses clauses)
  (if (null? clauses)
  	  'false
  	  (let ((first (car clauses))
  	  		(rest (cdr clauses)))
  	  	(if (cond-else-clause? first)
  	  	    (if (null? rest)
  	  	        (sequence->exp (cond-actions first))
  	  	        (error "ELSE clause is not last -- COND->IF" clauses))
  	  	    (make-if (cond-predicate first)
  	  	    		 (sequence->exp2 (cond-predicate first)
  	  	    		 				(cond-actions first))
  	  	    		 (expand-clauses rest))))))

(define (sequence->exp2 cond-part1 cond-part2)
  (if (eq? (car cond-part2) '=>)
  	  (list (cadr cond-part2) cond-part1)
  	  (sequence->exp cond-part2)))

(define (sequence->exp seq)
  (cond ((null? seq) seq)
  		((last-exp? seq) (first-exp seq))
  		(else (make-begin seq))))

(define (make-begin seq)
  (cons 'begin seq))

#|
4.6

let expressions are derived expressions because
(let ((<var1> <exp1>) ... (<varn> <expn>))
  <body>)
is equivalent to
((lambda (<var1> ... <varn>)
   <body>)
 <exp1>
 .
 .
 .
 <expn>)

|#

(define (let? exp) (tagged-list? exp 'let))
(define (let-assignment exp) (cadr exp))
(define (let-body exp) (cddr exp))
(define (let-exp assignment)
  (if (null? assignment)
  	  assignment
  	  (cons (cadar assignment) (let-exp (cdr assignment)))))
(define (let-var assignment)
  (if (null? assignment)
  	  assignment
  	  (cons (caar assignment) (let-var (cdr assignment)))))

(define (let->combination exp)
  (transform-let (let-assignment exp) (let-body exp)))
(define (transfrom-let assignment body)
  (cons (make-lambda (let-var assignment) body)
  		(let-exp assignment)))


(define (eval exp env)
  (cond ((self-evaluating? exp) exp)
  		((variable? exp) (lookup-variable-value exp env))
  		((quoted? exp) (text-of-quotation exp))
  		((assignment? exp) (eval-assignment exp env))
  		((definition? exp) (eval-definition exp env))
  		((if? exp) (eval-if exp env))
  		((lambda? exp)
  		 (make-procedure (lambda-parameters exp)
  		 				 (lambda-body exp)
  		 				 env))
  		((begin? exp) (eval-sequence (begin-actions exp) env))
  		((cond? exp) (eval (cond->if exp) env))
  		((application? exp)
  		 (apply (eval (operator exp) env)
  		 		(list-of-values (operands exp) env)))
  		((let? exp) (eval (let->combination exp) env))
  		(else 
  		  (error "Unknown expression type -- EVAL" exp))))

#|
; 4.7

We know a let can be written asa lambda exp which creates an env to
bind parameters to values. So a nested let statement creates another
lambda expression bound within the scope of the first:

(let ((a a-init))
  (let ((b b-init))
  	<body>))

<=>

((lambda (a)
   ((lambda (b)
   	  <body>)
   	b-init)
   a-init))

This is what the book is describing for the let* expression:

(let* ((a a-init)
		(b b-init))
  <body>)
<=>
(let ((a a-init))
  (let ((b b-init))
  	<body>))

The list of (name value) bindings in the let expression is directly 
after the let* symbol.
|#

(define (eval exp env)
  ;...
   		((let*? exp) (eval (let*-nested-lets exp) env))
  ;...
)

(define (let*? exp) (tagged-list? exp 'let*))
(define (let*-assignment exp) (cadr exp))
(define (let*-body) (cddr exp))

(define (let*->nested-lets exp)
  (transform-let* (let*-assignment exp) (let*-body exp)))
(define (transform-let* assignment body)
  (if (null? (cdr assignment))
  	  (cons 'let (cons assignment body))
  	  (list 'let (list (car assignment))
  	  		(transform-let* (cdr assignment) body))))


#|
; 4.8

"named let" is a variant of let that has the form:
(let <var> <bindings> <body>)

The <bindings> and <body> are just as in ordinary let, except 
that <var> is bound within <body> to a proc. whose body is <body>
and whose parameters are the variables in the <bindings>. Thus,
one can repeatedly execute the <body> by invoking the procedure 
named <var>. For example, the iterative fib procedure can be 
written using named let as follows:
|#

(define (fib n)
  (let fib-iter ((a 1) (b 0) (count n))
  	(if (= count 0)
  	    b
  	    (fib-iter (+ a b) a (- count 1)))))

(define (named-let? exp)
  (if (variable? (cadr exp))
  	  #t
  	  #f))
(define (named-let-var exp) (cadr exp))
(define (named-let-bindings exp) (caddr exp))
(define (named-let-body exp) (cdddr exp))

(define (let->combination exp)
  (if (named-let? exp)
  	  (transform-named-let (named-let-var exp)
  	  					   (named-let-bindings exp)
  	  					   (named-let-body exp))
  	  (transform-let (let-assignment exp) (let-body exp))))

(define (transform-named-let var bindings body)
  (sequence->exp
  	(list 'define
  		  (cons var bindings)
  		  body)))

(define (transfrom-let assignment body)
  (cons (make-lambda (let-var assignment) body)
  		(let-exp assignment)))


; ----------------------------------------------------------
; 4.1.3 Evalutor Data Structures 
;
; Testing of predicates

; for conditionals,we accept anything to be true that is not 
; the explicit false object. 

(define (true? x)
  (not (eq? x #f)))

(define (false? x)
  (eq? x #f))

; Representing procedures

; To handle primatives, we assume that we have available:

; (apply-primitive-procedure <proc> <args>)
; applies the given primitive procedure to the argument values
; in the list <args> and returns the result of the application.

; (primitive-procedure? <proc>)
; tests whether <proc> is a primative procedure.

(define (make-procedure parameters body env)
  (list 'procedure parameters body env))

(define (compound-procedure? p)
  (tagged-list? p 'procedure))

(define (procedure-parameters p) (cadr p))
(define (procedure-body p) (caddr p))
(define (procedure-environment p) (cadddr p))

; Operations on Environments
;
; we use the following operations for manipulating environments:

; (lookup-variable-value <var> <env>)
; returns the value that is bound to the symbol <var> in the
; environment <env>, or signals an error if unbound

; (extend-environment <vars> <values> <base-env>)
; returns a new environment, consisting of anew frame in which the 
; symbols in the list <vars> are bound to the corresponding 
; elements in the list <values>. where the encolsing environemt is
; the env. <base-env>.

; (define-variable! <var> <value> <env>)
; adds to the first frame in the environment <env> a new binding 
; that associates the variable <var> with the value <value>

; (set-variable-value! <var> <value> <env>)
; changes the binding of the variable <var> in the environment <env>
; so that the variable is not bound to the value <value>, signals
; error if vairable is unbound. 

; To implement these operations, we represent an environment asa list
; of frames. The encolsing env. of an env is the cdr of the list. 

(define (enclosing-environment env) (cdr env))
(define (first-frame env) (car env))
(define the-empty-environment '())

(define (make-frame variables values)
  (cons variables values))
(define (frame-variables frame) (car frame))
(define (frame-values frame) (cdr frame))
(define (add-binding-to-the-frame! var val frame)
  (set-car! frame (cons var (car frame)))
  (set-cdr! frame (cons val (cdr frame))))


;; To extend an environment by a new frame that associates 
;; variables with values, we make a frame consisting of the 
;; list of variables and the list of values, and we adjoin this
;; to the environment. We signal an error if the number of 
;; variables does not match the number of values. 

(define (extend-environment vars vals base-env)
  (if (= (length vars) (length vals))
  	  (cons (make-frame vars vals)base-env)
  	  (if (< (length vars) (length vals))
  	  	  (error "Too many arguments supplied" var vals)
  	  	  (error "Too few arguments supplied" var vals))))


;; To lookup a variable in an environment, we scan the list
;; of variables in the first frame. If we find the desired
;; variable, we return the corresponding element in the list
;; of values. If we do not find the variable in the current 
;; frame, we search the enclosing environment, and so on. 
;; If we reach the empty environment, we signal an 
;; "unbound variable" error.

(define (lookup-variable-value var env)
  (define (env-loop env)
  	(define (scan vars vals)
  	  (cond ((null? vars) (env-loop (enclosing-environment env)))
  	  		((eq? var (car vars)) (car vals))
  	  		(else (scan (cdr vars) (cdr vals)))))
  	(if (eq? env the-empty-environment)
  	    (error "Unbound variable" var)
  	    (let ((frame (first-frame env)))
  	      (scan (frame-variables frame)
  	      		(frame-values frame)))))
  (env-loop env))


;; To set a variable to a new value in a specified environment, 
;; we scan for the variable, just as in lookup-variable-value,
;; and change the corresponding value when we find it. 

(define (set-variable-value! var val env)
  (define (env-loop env)
  	(define (scan vars vals)
  	  (cond ((null? vars) (env-loop (enclosing-environment env)))
  	  		((eq? var (car vars)) (set-car! vals val))
  	  		(else (scan (cdr vars) (cdr vals)))))
  	(if (eq? env the-empty-environment)
  	    (error "Unbound variable -- SET!" var)
  	    (let ((frame (first-frame env)))
  	      (scan (frame-variables frame)
  	      		(frame-values frame)))))
  (env-loop env))


;; To define a variable, we search the first frame for a binding
;; to the variable, and change the binding if it exists (just as 
;; in set-variable-value!). If no such binding exists, we adjoin 
;; one to the first frame. 

(define (define-variable! var val env)
  (let ((frame (first-frame env)))
  	(define (scan vars vals)
  	  (cond ((null? vars) (add-binding-to-frame! var val frame))
  	  		((eq? var (car vars)) (set-car! vals val))
  	  		(else (scan (cdr vars) (cdr vals)))))
  	(scan (frame-variables frame)
  		  (frame-values frame))))


#|
-----------------------------------------------------
Exercises

4.11

Instead of representing a frame as a pair of lists, we can 
represent a frame as a list of bindings, where each 
binding is a name-value pair. Rewrite the environment
operations to use this alternative representation. 

Since a frame is now a list of name-value pairs, assoc can
find variables defined in a frame so frame-variables 
and frame-values are not needed. 

(define (make-frame vars vals) (map cons vars vals))
(define (add-binding-to-frame! var val frame)
  (define (add-binding! binding frame)
  	(if (null? (cdr frame))
  	    (set-cdr! frame binding)
  	    (add-binding! binding (cdr frame))))
  (add-binding! (list (cons var val)) frame))

(define (lookup-variable-value var env)
  (define (env-loop env)
  	(define (scan frame)
  	  (let ((binding (assoc var frame)))
  	  	(if binding
  	  	    (cdr binding)
  	  	    (env-loop (enclosing-environment env)))))
  	(if (eq? env the-empty-environment)
  	    (error "Unbound variable" var)
  	    (scan (first-frame env))))
  (env-loop env))

(define (set-variable-value! var val env)
  (define (env-loop env)
  	(define (scan frame)
  	  (let ((binding (assoc var frame)))
  	  	(if binding
  	  	    (set-cdr! binding val)
  	  	    (env-loop (enclosing-environment env)))))
  	(if (eq? env the-empty-environment)
  	    (error "Unbound variable -- SET!" var)
  	    (scan (first-frame env))))
  (env-loop env))

(define (define-variable! var val env)
  (let* ((frame (first-frame env))
  		 (binding (assoc var frame)))
  	(if binding
  	    (set-cdr! binding val)
  	    (add-binding-to-frame! var val frame))))

-------

4.12

