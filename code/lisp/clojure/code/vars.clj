; the following code demonstrates usage of def, defn, let, binding, and println


(def ^:dynamic v 1) ; v is a global binding

(defn f1 []
  (println "f1: v:" v))

(defn f2 []
  (println "f2: before let v:" v) 
  (let [v 2] ; creates local binding v that shadows global one 
    (println "f2: in let, v:" v) ; local binding only within this let statment 
    (f1))  
  (println "f2: after let v:" v)) ; outside of this let, v refers to global binding. 

(defn f3 []
  (println "f3: before binding v:" v)
  (binding [v 3] ; same global binding, with new temp value
    (println "f3: within binding function v: " v) ; global binding, new name 
    (f1)) ; calling f1 with new value to v
  (println "f3: after binding v:" v)) ; outside of binding v, refers to global value. 

(defn f4 []
  (def v 4)) ; changes value of v in the global scope 

(println "(= v 1) => " (= v 1))
(println "calling f2: ")
(f2)
(println)
(println "calling f3: ")
(f3)
(println)
(println "calling f4: ")
(f4)
(println "after calling f4, v =" v)




