

; 2.62

(define (union-set set1 set2)
  (cond ((null? set1) set2)
  		((null? set2) set1)
  		(else 
  		  (let ((x1 (car set1)) (x2 (car set2)))
  		  	(cond ((= x1 x2)
  		  		   (cons x1 (union-set (cdr set1) (cdr set2))))
  		  		  ((> x1 x2)
  		  		   (cons x2 (union-set set1 (cdr set2))))
  		  		  ((< x1 x2)
  		  		   (cons x1 (union-set (cdr set1) set2))))))))


(union-set (list 1 3 5 7) (list 1 2 3 6))
(union-set (list 1 5 6 9) (list 1 2 3 4 5 6 7 8 9))
(union-set (list 1 5 6 9) (list 9 10 11))
(union-set (list 1 2 3) '())
(union-set '() (list 1 2 3))

; 2.63

(define (tree->list1 tree)
  (if (null? tree)
  	  '()
  	  (append (tree->list1 (left-branch tree))
  	  		  (cons (entry tree)
  	  		  		(tree->list1 (right-branch tree))))))

(define (tree->list2 tree)
  (define (copy-to-list tree result-list)
  	(if (null? tree)
  	    result-list
  	    (copy-to-list (left-branch tree)
  	    			  (cons (entry tree)
  	    			  		(copy-to-list (right-branch tree)
  	    			  					  result-list)))))
  (copy-to-list tree '()))

(define (entry tree) (car tree))
(define (left-branch tree) (cadr tree))
(define (right-branch tree) (caddr tree))


(define tree1 '(7 (3 (1 () ()) (5 () ())) (9 () (11 () ()))))


(define (list->tree elements)
  (car (partial-tree elements (length elements))))

(define (partial-tree elts n)
  (if (= n 0)
  	(cons '() elts)
  	(let ((left-size (quotient (- n 1) 2)))
  	  (let ((left-result (partial-tree elts left-size)))
  	  	(let ((left-tree (car left-result))
  	  		  (non-left-elts (cdr left-result))
  	  		  (right-size (- n (+ left-size 1))))
  	  	  (let ((this-entry (car non-left-elts))
  	  	  		(right-result (partial-tree (cdr non-left-elts)
  	  	  									right-size)))
  	  	  	(let ((right-tree (car right-result))
  	  	  		  (remaining-elts (cdr right-result)))
  	  	  	  (cons (make-tree this-entry left-tree right-tree)
  	  	  	  		remaining-elts))))))))

(define (make-tree entry left right)
  (list entry left right))


; 2.65


(define (union-set tree1 tree2)
  (define (union-list set1 set2)
  	(cond ((null? set1) set2)
  		  ((null? set2) set1)
  		  (else 
  		  	(let ((x1 (car set1)) (x2 (car set2)))
  		  	  (cond ((= x1 x2)
  		  	  		 (cons x1 (union-list (cdr set1) (cdr set2))))
  		  	  		((> x1 x2)
  		  		     (cons x2 (union-list set1 (cdr set2))))
  		  		    ((< x1 x2)
  		  		     (cons x1 (union-list (cdr set1) set2))))))))
  (list->tree (union-list (tree->list2 tree1)
  						  (tree->list2 tree2))))


(define (intersection-set tree1 tree2)
  (define (intersection-list set1 set2)
  	(if (or (null? set1) (null? set2))
  	    '()
  	    (let ((x1 (car set1)) (x2 (car set2)))
  	      (cond ((= x1 x2)
  	      		 (cons x1 (intersection-list (cdr set1) (cdr set2))))
  	      		((< x1 x2) (intersection-list (cdr set1) set2))
  	      		((> x1 x2) (intersection-list set1 (cdr set2)))))))
  (list->tree (intersection-list (tree->list2 tree1)
  								 (tree->list2 tree2))))


(define evens (list->tree (list 0 2 4 6 8 10)))
(define odds (list->tree (list 1 3 5 7 9)))
(define primes (list->tree (list 2 3 5 7 11 13 17 19)))



; 2.66

; for unordered list
(define (lookup-u given-key set-of-records)
  (cond ((null? set-of-records) #f)
  		((equal? given-key (key (car set-of-records)))
  		 (car set-of-records))
  		(else (lookup-u given-key (cdr set-of-records)))))

; for binary tree

(define (lookup given-key set-of-records)
    (cond ((null? set-of-records) #f)
    	  ((= given-key (key (car set-of-records)))
    	   (car set-of-records))
    	  ((< given-key (key (car set-of-records)))
    	   (lookup given-key (left-branch set-of-records)))
    	  ((> given-key (key (car set-of-records)))
    	   (lookup given-key (right-branch set-of-records)))))

(define (key record) (car record))
(define (data record) (cdr record))
(define (make-record key data) (cons key data))

(define database
    (list (make-record 1 'Bill)
    	  (make-record 2 'Joe)
    	  (make-record 3 'Frank)
    	  (make-record 4 'John)))

(define tree-db (list->tree database))

(lookup 3 tree-db)
