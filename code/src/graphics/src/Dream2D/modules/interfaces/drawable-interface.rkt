#lang racket
(require racket/class)
(provide drawable-interface<%>)

(define drawable-interface<%>
  (interface () draw))
