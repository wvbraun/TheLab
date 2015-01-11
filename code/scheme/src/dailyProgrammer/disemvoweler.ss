;a, e, i, o, and u are considered vowels for this. 

(define (vowel? x)
  (cond ((eq? x 'a) #t)
  		((eq? x 'e) #t)
  		((eq? x 'i) #t)
  		((eq? x 'o) #t)
  		((eq? x 'u) #t)
  		(else #f)))

(define (disemvoweler str)
  (let* ((ls (string->list str))
  		 (no-vowels (filter (lambda (x) (not (vowel? x))) ls))
  		 (vowels (filter vowel? ls)))
  	ls))

(disemvoweler "all those who believe in psychokinesis raise my hand")

