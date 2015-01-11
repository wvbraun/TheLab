(define (accumulate op initial sequence)
  (if (null? sequence)
  	  initial 
  	  (op (car sequence)
  	  	  (accumulate op initial (cdr sequence)))))

(define (enumerate-interval low high)
  (if (> low high)
  	  '()
  	  (cons low (enumerate-interval (+ low 1) high))))

(define (flatmap proc seq)
  (accumulate append '() (map proc seq)))

(define (prime-sum-pair pair)
  (prime? (+ (car pair) (cadr pair))))

(define (make-pair-sum pair)
  (list (car pair) (cadr pair) (+ (car pair) (cadr pair))))

(define (prime? p)
  (define (non-divisible-by n d)
  	(if (= d 1) 
  	    #t
  		(if (= (remainder n d) 0)
          	#f
          	(non-divisible-by n (- d 1)))))
  (if (= p 1)
      #t
      (non-divisible-by p (- p 1))))

(define (unique-pairs n)
  (flatmap 
  	(lambda (i)
  	  (map (lambda (j) (list i j))
  	  	   (enumerate-interval 1 (- i 1))))
  	(enumerate-interval 1 n)))

(define (prime-sum-pairs n)
  (map make-pair-sum
  	   (filter prime-sum-pair (unique-pairs n))))


; 2.41

(define (ordered-pairs n)
  (flatmap (lambda (i)
  	(flatmap (lambda (j)
  		(map (lambda (k) (list i j k))
  			 (enumerate-interval 1 (- j 1))))
  		(enumerate-interval 1 (- i 1))))
   (enumerate-interval 1 n)))

(define (triple-sum triple)
  (append triple (list (accumulate + 0 triple))))

(define (triple-sum-pairs1 n s)
  (define (triple-sum? triple)
  	(= s (accumulate + 0 triple)))
  (map triple-sum 
  	   (filter triple-sum? (ordered-pairs n))))


(define (triple-sum-pairs n s)
  (let ((ls (filter (lambda (ls)
  					  (= s (accumulate + 0 ls)))
  					(ordered-pairs n))))
  	(if (null? (cdr ls))
  	    (car ls)
  	    ls)))


; 2.42
(define (list-ref items n)
  (if (= n 0)
  	  (car items)
  	  (list-ref (cdr items) (- n 1))))

(define (queens board-size)
  (define (queen-cols k)
  	(if (= k 0)
  	    (list empty-board)
  	    (filter 
  	      (lambda (positions) (safe? k positions))
  	      (flatmap
  	      	(lambda (rest-of-queens)
  	      	  (map (lambda (new-row)
  	      	  		 (adjoin-position new-row k rest-of-queens))
  	      	  	   (enumerate-interval 1 board-size)))
  	      	(queen-cols (- k 1))))))
  (queen-cols board-size))

(define (make-position row col)
  (list row col))

(define (position-col position)
  (cadr position))
(define (position-row position)
  (car position))

(define empty-board '())

(define (adjoin-position row col position)
  (append position (list (make-position row col))))

(define (safe? col position)
  (let ((kth-queen (list-ref position (- col 1)))
  		(other-queens (filter (lambda (queen)
  								(not (= col (position-col queen)))) position)))
  	(define (attacks? queen1 queen2)
  	  (or (= (position-row queen1) (position-row queen2))
  	  	  (= (abs (- (position-row queen1) (position-row queen2)))
  	  	  	 (abs (- (position-col queen1) (position-col queen2))))))
  	(define (iter queen board)
  	  (or (null? board)
  	  	  (and (not (attacks? queen (car board)))
  	  	  	   (iter queen (cdr board)))))
  	(iter kth-queen other-queens)))


