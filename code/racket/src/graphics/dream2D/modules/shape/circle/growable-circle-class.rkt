#lang racket
(require racket/class
         2htdp/image 
         "circle-class.rkt"
         "../../interfaces/growable-interface.rkt")

(provide growable-circle-class%)

(define growable-circle-class%
  (class* circle-class%
    (growable-interface<%>)
    (super-new)
    (init-field op)
    (init-field max)
    (init-field min)
    (inherit-field mode)
    (inherit-field color)
    (inherit-field radius)
    (define/public (grow)
      (cond ((= radius max)
             (begin
               (set-field! radius this (sub1 radius))
               (set-field! op     this -)
               (new this% [op op] [max max] [min min] [mode mode] [color color] [radius radius])
               (send this draw)))
            ((= radius min)
             (begin
               (set-field! radius this (add1 radius))
               (set-field! op     this +)
               (new this% [op op] [max max] [min min] [mode mode] [color color] [radius radius])
               (send this draw)))
            (else
             (begin
               (set-field! radius this (op radius 1))
               (new this% [op op] [max max] [min min] [mode mode] [color color] [radius radius])
               (send this draw)))))))
