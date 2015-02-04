#lang racket
(require 2htdp/image 
		 "../shape/circle/growable-circle-class.rkt")
(provide two)

(define two
  (new growable-circle-class%
       [mode "solid"]
       [color (color 5 21 21)]
       [radius 5]
       [max 120]
       [min 5]
       [op +]))


