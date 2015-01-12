#lang racket
(require 2htdp/image 2htdp/universe)


;---------------------------------------------------------------------------------------------
; CONSTANTS 
(define SPEED      50)
(define HEIGHT     703)
(define WIDTH      1366)
(define LINE_Y     (* HEIGHT .75))
(define A_START_Y  (- LINE_Y 120))
(define B_START_Y  (- LINE_Y 5))
(define GROUND     (line WIDTH 0 "black"))
(define ROCK_COLOR (color 5 21 21))
(define BACKGROUND (place-image GROUND
				(/ WIDTH 2)
                            LINE_Y
                            (rectangle WIDTH HEIGHT "solid" (color 246 218 193 30))))


;---------------------------------------------------------------------------------------------
; STRUCTS

(define-struct posn  (x   y))
(define-struct rock  (pos vel shape))
(define-struct world (a b))
(define-struct shape (img op))

;---------------------------------------------------------------------------------------------
; RADIUS

;; radius :: [Image] -> [Integer]
;; This method returns the radius of a rock.

(define (radius img)
  (ceiling (/ (image-height img) 2)))

;---------------------------------------------------------------------------------------------
; RESET

;; reset :: [Image] -> [Posn]
;; This method is called whenever a rock has reached the end of the
;; screen. It return the rock to a starting position.

(define (reset img)
  (let ((r (radius img)))
  	(make-posn (+ WIDTH r (/ r 2)) (- LINE_Y r))))


;---------------------------------------------------------------------------------------------
; RENDER

;; render :: [World] -> [Image]
;; This method draws the world.

(define (render w)
  (let* ((a    (world-a w))
         (b    (world-b w))
         (aPos (rock-pos a))
         (bPos (rock-pos b))) (place-image (shape-img (rock-shape a))
                 (posn-x aPos)
                 (posn-y (rock-pos a))
                 (place-image (shape-img (rock-shape b))
                              (posn-x (rock-pos b))
                              (posn-y (rock-pos b))
                              BACKGROUND))))

;---------------------------------------------------------------------------------------------
; MOVE-ROCK

;; moveRock :: [Rock] -> [Posn]
;; This method determines the rocks new position.

(define (move-rock r)
  (let* ((s    (rock-shape r))
  		 (op   (shape-op   s))
  		 (img  (shape-img  s))
  		 (pos  (rock-pos   r))
  		 (vel  (rock-vel   r))
         (xPos (posn-x     pos))
         (yPos (posn-y 	   pos))
         (xVel (posn-x     vel)))
    (if (< xPos (- (image-height (shape-img (rock-shape r)))))
    	(reset img)
        (make-posn (+  xPos xVel)
                   (op (posn-y pos) -1)))))

;---------------------------------------------------------------------------------------------
; GROW


;; grow :: [Shape] -> [Shape]
;; This method allows the rock to grow/shrink.

(define (grow s)
  (let ((op  (shape-op s))
        (img (shape-img s)))
  	(cond
         ((= (radius img) 120)
          (make-shape (circle 119 "solid" ROCK_COLOR) -))
         ((= (radius img) 5)
          (make-shape (circle 6 "solid" ROCK_COLOR) +))
         (else
          (shape (circle (op (radius img) 1) "solid" ROCK_COLOR) op)))))

;---------------------------------------------------------------------------------------------
; TICK-HANDLER

;; tickHandler :: [World] -> [World]
;; This method moves the ball

(define (tick-handler w)
  (let* ((a (world-a w))
         (b (world-b w))
         (aShape (grow (rock-shape a)))
         (bShape (grow (rock-shape b)))
         (aRock (make-rock (rock-pos a) (rock-vel a) aShape))
         (bRock (make-rock (rock-pos b) (rock-vel b) bShape)))
    (make-world 
      (make-rock (move-rock aRock)
                 (rock-vel a)
                 aShape)
      (make-rock (move-rock
      			   bRock)
                   (rock-vel b)
                   bShape))))

;---------------------------------------------------------------------------------------------
; INITIAL WORLD

(define INITIAL
  (make-world  
  	(make-rock (make-posn (- WIDTH 130) A_START_Y)
               (make-posn -1 0)
               (make-shape (circle 120 "solid" ROCK_COLOR) -))
    (make-rock (make-posn WIDTH B_START_Y)
               (make-posn -1 0)
               (make-shape (circle 5 "solid" ROCK_COLOR) +))))

;---------------------------------------------------------------------------------------------
; BIG-BANG

(big-bang INITIAL
          (to-draw render)
          (on-tick tick-handler (/ SPEED)))



