#lang racket
(require racket/class)
(provide moveable-interface<%>)

(define moveable-interface<%>
  (interface () move))
