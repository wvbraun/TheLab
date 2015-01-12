#lang racket
(provide (struct-out world))

; Since we only need two rocks, we can have our world 
; represented by two rocks: a and b.

(define-struct world (a b))
