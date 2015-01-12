#lang racket
(provide SPEED HEIGHT WIDTH LINE_Y A_START_Y B_START_Y)

(define SPEED      50)
(define HEIGHT     703)
(define WIDTH      1366)
(define LINE_Y     (* HEIGHT .75))
(define A_START_Y  (- LINE_Y 120))
(define B_START_Y  (- LINE_Y 5))

