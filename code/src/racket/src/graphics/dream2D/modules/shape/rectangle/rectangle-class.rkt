#lang racket
(require racket/class
         2htdp/image 
         "../shape-class.rkt")

(provide rectangle-class%)

(define rectangle-class%
  (class shape-class%
    (super-new)
    (init-field width)
    (init-field height)
    (inherit-field mode)
    (inherit-field color)
    (define/override (draw)
      (rectangle width height mode color))))
