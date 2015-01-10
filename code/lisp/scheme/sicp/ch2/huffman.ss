(define (make-leaf symbol weight)
  (list 'leaf symbol weight))

(define (leaf? object)
  (eq? 'leaf (car object)))

(define (symbol-leaf leaf) (cadr leaf))
(define (weight-leaf leaf) (caddr leaf))


(define (make-code-tree left right)
  (list left
  		right
  		(append (symbols left) (symbols right))
  		(+ (weight left) (weight right))))


(define (left-branch tree) (car tree))
(define (right-branch tree) (caddr tree))

(define (symbols tree)
  (if (leaf? tree)
  	  (list (symbol-leaf tree))
  	  (caddr tree))) ; we want 3rd item from
					 ; (left-branch, right-branch, set or more symbols, weight)

(define (weight tree)
  (if (leaf? tree)
  	  (weight-leaf tree)
  	  (cadddr tree)))


(define (decode bits tree)
  (define (decode-1 bits current-branch)
  	(if (null? bits)
  	    bits
  	    (let ((next-branch (choose-branch (car bits) current-branch)))
  	      (if (leaf? next-branch)
  	      	  (cons (symbol-leaf next-branch)
  	      	  		(decode-1 (cdr bits) tree))
  	      	  (decode-1 (cdr bits) next-branch)))))
  (decode-1 bits tree))

(define (choose-branch bit branch)
  (cond ((= bit 0) (left-branch branch))
  		((= bit 1) (right-branch branch))
  		(else (error "bad bit -- CHOOSE BRANCH" bit))))


(define (adjoin-set leaf set)
  (cond ((null? set) (list leaf))
  		((< (weight leaf) (weight (car set))) (cons leaf set))
  		(else (cons (car set)
  					(adjoin-set leaf (cdr set))))))

(define (make-leaf-set pairs)
  (if (null? pairs)
  	  pairs
  	  (let ((pair (car pairs)))
  	  	(adjoin-set (make-leaf (car pair) (cadr pair))
  	  				(make-leaf-set (cdr pairs))))))


;------------------------------------------------------
;Exercises

; 2.67
; define an encoding tree and a sample message
; use decode to give result

(define sample-tree
  (make-code-tree (make-leaf 'a 4)
  				  (make-code-tree 
  				  	(make-leaf 'b 2)
  				  	(make-code-tree 
  				  	  (make-leaf 'd 1)
  				  	  (make-leaf 'c 1)))))

(define sample-message '(0 1 1 0 0 1 0 1 0 1 1 1 0))


; 2.68
; encode-symbol returns the list of bits that encode
; a given symbol according to a given tree. 	

(define (encode message tree)
  (if (null? message)
  	  message
  	  (append (encode-symbol (car message) tree)
  	  		  (encode (cdr message) tree))))

(define (encode-symbol symbol tree)
  (cond ((leaf? tree) '())
  		((memq symbol (symbols (left-branch tree)))
  		 (cons 0 (encode-symbol symbol (left-branch tree))))
  		((memq symbol (symbol (right-branch tree)))
  		 (cons 1 (encode-symbol symbol (right-branch tree))))
  		(else (error "bad symbol -- ENCODE-SYMBOL" symbol))))

(encode '(a d a b b c a) sample-tree)


; 2.69

(define (generate-huffman-tree pairs)
  (successive-merge (make-leaf-set pairs)))


(define (successive-merge pairs)
  (cond ((null? pairs) pairs)
  		((null? (cdr pairs)) (car pairs))
  		(else (adjoin-set (make-code-leaf (car pairs) (cadr pairs))
  						  (successive-merge (cddr set))))))
