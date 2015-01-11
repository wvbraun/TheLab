(require pkg)
(install "github://github.com/iu-c211/c211-libs/master")
(require "infinity.ss")

(define img
  (read-image "/home/bp/edu/c211/assignments/tiny-turkey.png"))


#|
To account for images that are on the border, i made a cropped-image-ref
which is simply a safer version of image-ref. If the specified pixel
is out of bounds, it returns 'oo
|#

(define (cropped-image-ref img r c)
  (cond ((or (<= (image-rows img) r) (<= (image-cols img) c)) (infinity))
    ((or (< c 0) (< r 0)) (infinity))
    (else (image-ref img r c))))


(define (brightness c)
  (if (infinity? c)
     0
     (+ (color-ref c 0)
       (color-ref c 1)
       (color-ref c 2))))


(define (energy img r c)
  (define (energyCalc a b c d f g h i)
   (define (xEnergy a d g c f i)
     (- (+ a (* 2 d) g) c (* 2 f) i))
   (define (yEnergy a b c g h i)
     (- (+ a (* 2 b) c) g (* 2 h) i))
   (sqrt (+ (expt (xEnergy a d g c f i) 2)
      (expt (yEnergy a b c g h i) 2))))
  (let
   ((a (brightness (cropped-image-ref img (- r 1) (- c 1))))
    (b (brightness (cropped-image-ref img (- r 1) c)))
    (c (brightness (cropped-image-ref img (- r 1) (+ c 1))))
    (d (brightness (cropped-image-ref img r (- c 1))))
    (f (brightness (cropped-image-ref img r (+ c 1))))
    (g (brightness (cropped-image-ref img (+ r 1) (- c 1))))
    (h (brightness (cropped-image-ref img (+ r 1) c)))
    (i (brightness (cropped-image-ref img (+ r 1) (+ c 1)))))
   (energyCalc a b c d f g h i)))
