#lang racket
(require 2htdp/image
		 "../defaults/defaults.rkt"
		 "../shape/rectangle/rectangle-class.rkt")
(provide background)

(define background
  (new rectangle-class%
       [mode "solid"]
       [color (color 246 218 193 30)]
       [width WIDTH]
       [height HEIGHT]))


