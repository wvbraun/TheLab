#lang racket
(require racket/class
         2htdp/image
         "../shape-class.rkt")

(provide circle-class%)

(define circle-class%
  (class shape-class%
    (super-new)
    (init-field radius)
    (inherit-field mode)
    (inherit-field color)
    (define/override (draw)
      (circle radius mode color))))
