;***////Implement an calculator (64 bit Binary Multiplication) application using concurrent lisp****////

(write-line "Calculator")

(write-line "addition program")
(write-line "two numbers:")
(defvar a)
(defvar b)
(defvar c)
(setq a (read))
(setq b (read))

(write-line "substraction program")
(write-line "two numbers:")
(defvar d)
(defvar e)
(defvar f)
(setq d (read))
(setq e (read))

(write-line "multiplication program")
(write-line "two numbers:")
(defvar g)
(defvar h)
(defvar i)
(setq g (read))
(setq h (read))
(write-line "processing")
(write-line "**********************")


(write-line "division program")
(write-line "two numbers:")
(defvar j)
(defvar k)
(defvar l)
(setq j (read))
(setq k (read))
(write-line "processing")
(write-line "**********************")

(write-line "SQURE OF NUMBER:")
(write-line "ENTER NUMBER:")
(defvar m)
(defvar n)
(setq m (read))
(write-line "processing")
(write-line "**********************")

(write-line "SQUARE ROOT OF NUMBER:")
(write-line "ENTER NUMBER:")
(defvar o)
(defvar p)
(setq o (read))
(write-line "processing")
(write-line "**********************")


(write-line "SIN FUN:")
(write-line "ENTER NUMBER:")
(defvar q)
(defvar r)
(setq q (read))
(write-line "processing")
(write-line "**********************")


(write-line "COS FUN")
(write-line "ENTER NUMBER:")
(defvar s)
(defvar z)
(setq s (read))
(write-line "processing")
(write-line "**********************")

(write-line "EXPONTIAL FUN")
(write-line "ENTER NUMBER:")
(defvar u)
(defvar v)
(setq u (read))
(write-line "processing")
(write-line "**********************")

(write-line "LOG FUN:")
(write-line "ENTER NUMBER:")
(defvar w)
(defvar x)
(setq w (read))
(write-line "processing")
(write-line "**********************")



(sb-thread:make-thread (lambda() (progn (sleep 1) (setq c (+ a b))
(write-line "")
(write-line "addition of two no")
(write c))))
(write-line "**********************")

(sb-thread:make-thread (lambda() (progn (sleep 1) (setq f (- d e))
(write-line "")
(write-line "substraction of two no")
(write f))))

(sb-thread:make-thread (lambda() (progn (sleep 1) (setq i (* g h))
(write-line "")
(write-line "multiplication of two no")
(write i))))
(write-line "**********************")

(sb-thread:make-thread (lambda() (progn (sleep 1) (setq l (/ j k))
(write-line "")
(write-line "DIVISION of two no")
(write l))))
(write-line "**********************")

(sb-thread:make-thread (lambda() (progn (sleep 1) (setq n(* m m))
(write-line "")
(write-line "square=")
(write n))))
(write-line "**********************")

(sb-thread:make-thread (lambda() (progn (sleep 1) (setq p(sqrt o))
(write-line "")
(write-line "SQURE ROOT=")
(write p))))
(write-line "**********************")

(sb-thread:make-thread (lambda() (progn (sleep 1) (setq r(sin q))
(write-line "")
(write-line "SIGN FUNCTION=")
(write r))))
(write-line "**********************")

(sb-thread:make-thread (lambda () (progn (sleep 1) (setq z(cos s))
(write-line "")
(write-line "COS FUNCTION=")
(write z))))
(write-line "**********************")

(sb-thread:make-thread (lambda () (progn (sleep 1) (setq v(exp u))
(write-line "")
(write-line "EXPONTIAL FUNCTION")
(write v))))
(write-line "**********************")


(sb-thread:make-thread (lambda () (progn (sleep 1) (setq x(log w))
(write-line "")
(write-line "LOG FUNCTION =")
(write x)
(write-line "**********************")

(write-line "finished"))))

               ;OUTPUT
*/Calculator
addition program
two numbers:
5 5
substraction program
two numbers:
10 5
multiplication program
two numbers:
2 2
processing
**********************
division program
two numbers:
10 5
processing
**********************
SQURE OF NUMBER:
ENTER NUMBER:
4
processing
**********************
SQUARE ROOT OF NUMBER:
ENTER NUMBER:
4
processing
**********************
SIN FUN:
ENTER NUMBER:
90
processing
**********************
COS FUN
ENTER NUMBER:
45
processing
**********************
EXPONTIAL FUN
ENTER NUMBER:
9
processing
**********************
LOG FUN:
ENTER NUMBER:
10
processing
**********************
**********************
**********************
**********************
**********************
**********************
**********************
**********************
**********************
addition of two no
10
substraction of two no
5
multiplication of two no
4
DIVISION of two no
2
square=
16
SQURE ROOT=
2.0
SIGN FUNCTION=
0.89399666
COS FUNCTION=
0.52532196
EXPONTIAL FUNCTION
8103.084
LOG FUNCTION =
2.3025851**********************
finished /*





