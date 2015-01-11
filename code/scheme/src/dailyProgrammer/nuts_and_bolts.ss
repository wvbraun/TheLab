; easy

(define (nuts-bolts ls1 ls2)
  (cond ((null? ls1) ls1)
  		((equal? (cadar ls1) (cadar ls2))
  		 (nuts-bolts (cdr ls1) (cdr ls2)))
  		(else (cons 
  				(list (caar ls1) (- (cadar ls2) (cadar ls1)))
  				(nuts-bolts (cdr ls1) (cdr ls2))))))

(nuts-bolts '((carriage-bolt 45) (eye-bolt 50) (washer 120) (rivet 10))
			'((carriage-bolt 45) (eye-bolt 45) (washer 140) (rivet 10)))
