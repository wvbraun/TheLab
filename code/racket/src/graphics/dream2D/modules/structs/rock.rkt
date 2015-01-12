#lang racket
(provide (struct-out rock))

; A pos is a Posn 
; A vel is a Posn
; A shape is an Image
(define-struct rock (pos vel shape))
