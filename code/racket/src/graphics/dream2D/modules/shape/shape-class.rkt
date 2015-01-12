#lang racket
(require racket/class "../interfaces/drawable-interface.rkt")
(provide shape-class%)


(define shape-class%
  (class* object%
    (drawable-interface<%>)
    (super-new)
    (init-field mode)
    (init-field color)
    (abstract draw)))
