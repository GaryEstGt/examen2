Examen 2
=========

Serie 1
--------

Para el problema 1 se implemento un arreglo con limite uno que iría creciendo conforme el usuario ingresara numero.

* Entradas: indice y dato
* Salidas: el arreglo con la secuencia indicada en el enunciado
* Proceso: se crearon dos metodos uno que ingresa los datos(add) y otro que reasigana las posiciones(reaposicionar)
En el metodo add se verifica si es necesario reasignar posiciones y de serlo pasa al metodo correspondiente.
* Restricciones: ninguna

Serie 2
--------

Para el problema 2 se agrego un metodo que cambia los nodos en las posiciones indicadas

Entradas: posiciones de los nodos a cambiar.
Salidas: Nodos cambiados.
Proceso: se creó un moto llamado swap que al recibir las posiciones buscaba los nodos almacenado en en estos
por medio de la funcion validate() posteriormente cambiaba las referencia de los nodos y los reasignaba a las posiciones
Restriccion: la posicion debe existir dentro de la lista.

Serie 3
--------

Para el problema 3 se implemento un metodo que devueleve la posicion del nodo dependiendo del indice

Entradas: indice del nodo.
Salida: posicion del nodo.
Proceso: primero se agrego un atributo a la clase nodo llamado indice, y al momento de ingresar un nuevo nodo se le agregaba
un indice, posteriormente en la funcion posicionAtIndex() se creo un while con condicion de que nodo!=null y nodo iba cambiando de referencia dentro del while nodo=nodo.getNext(), de esta manera se recorrio la lista comparando nodo por nodo el que coincida con
el indice para luego determinal la posicion por medio de la funcion posicion() y retornarla

Serie 4
--------

Para el cuarto problema se creo una pila dinamica

Entradas: Datos de la pila
Salidas: Guardarlos en la pila sin un limte y con los acuerdos de esta (LIFO)
Proceso: basado en la interfaz dada se creo una clase DynamicStack basada tambien en la lista enlzada, con una clase nodo y con funciones que recorren los nodos, estas funciones eran las propias de la pila (top(),pop(),push()).

