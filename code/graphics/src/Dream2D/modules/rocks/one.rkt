#lang racket
(require 2htdp/image
		 "../shape/circle/growable-circle-class.rkt")
(provide one)

(define one
  (new growable-circle-class%
       [mode "solid"]
       [color (color 5 21 21)]
       [radius 120]
       [max 120]
       [min 5] 
       [op -]))


