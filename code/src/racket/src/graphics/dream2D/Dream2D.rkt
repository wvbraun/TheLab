#lang racket
(require 2htdp/image 
         2htdp/universe
         "modules/rocks/one.rkt"
         "modules/rocks/two.rkt"
         "modules/structs/posn.rkt"
         "modules/structs/rock.rkt"
         "modules/structs/world.rkt"
         "modules/defaults/defaults.rkt"
         "modules/backgrounds/light-peach.rkt")

;---------------------------------------------------------------------------------------------
; RESET

;; reset :: [Shape] -> [Posn]
;; This method is called whenever a rock has reached the end of the
;; screen. It return the rock to a starting position.

(define (reset s)
  (let ((r (get-field radius s)))
  	(make-posn (+ WIDTH r (/ r 2)) (- LINE_Y r))))

;---------------------------------------------------------------------------------------------
; RADIUS

;; radius :: [Image] -> [Integer]
;; This method returns the radius of a rock.

(define (radius img)
  (ceiling (/ (image-height img) 2)))


;---------------------------------------------------------------------------------------------
; RENDER
;
; render :: [World] -> [Image]
; This mehod draws the world.

(define (render w)
  (let* ((a    (world-a w))
         (b    (world-b w))
         (aPos (rock-pos a))
         (bPos (rock-pos b)))
    (place-image 
      (send one draw)
      (posn-x aPos)
      (posn-y aPos)
      (place-image 
      	(send two draw)
        (posn-x bPos)
        (posn-y bPos)
        (place-image
          (line WIDTH 0 "black")
          (/ WIDTH 2)
          LINE_Y
          (send background draw))))))

;---------------------------------------------------------------------------------------------
; MOVE-ROCK
;
; move-rock :: [Rock] -> [Posn]
; This method determines the rocks new position.

(define (move-rock r)
  (let* ((s    (rock-shape   r))
         (op   (get-field op s))
         (pos  (rock-pos     r))
         (vel  (rock-vel     r))
         (xPos (posn-x     pos))
         (yPos (posn-y     pos))
         (xVel (posn-x     vel)))
    (if (< xPos (- (image-height (send s draw))))
        (reset s)
        (make-posn (+  xPos xVel)
                   (op (posn-y pos) -1)))))

;---------------------------------------------------------------------------------------------
; TICK-HANDLER
;
; tick-handler :: [World] -> [World]
; This method moves the ball.

(define (tick-handler w)
  (let* ((a (world-a w))
         (b (world-b w)))
    (begin
      (send one grow)
      (send two grow)
      (make-world 
       (make-rock (move-rock a)
                  (rock-vel a)
                  one)
       (make-rock (move-rock b)
                  (rock-vel b)
                  two)))))

;---------------------------------------------------------------------------------------------
; INITIAL WORLD

(define INITIAL
  (make-world  
  	(make-rock (make-posn (- WIDTH 130) A_START_Y)
               (make-posn -1 0)
               one)
    (make-rock (make-posn WIDTH B_START_Y)
               (make-posn -1 0)
               two)))

;---------------------------------------------------------------------------------------------
; BIG-BANG

(big-bang INITIAL
          (to-draw render)
          (on-tick tick-handler (/ SPEED)))
