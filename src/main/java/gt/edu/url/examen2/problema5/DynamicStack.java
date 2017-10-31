package gt.edu.url.examen2.problema5;

import gt.edu.url.examen2.problema4.Position;

/**
 * Clase stack(pila)
 * @author garya
 *
 * @param <E>
 */
public class DynamicStack<E> implements Stack<E> {
	/**
	 * Nodos de la pila
	 * @author garya
	 *
	 * @param <E>
	 */
	private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev;// Anterior
		private Node<E> next;// Siguiente
		private int indice=1000;
		
/**
 * Constrcutor
 * @param e
 */
		public Node(E e) {
			element = e;
		}
		/**
		 * Obtiene el elemento
		 */
		public E getElement() throws IllegalStateException {
			return element;
		}
		/**
		 * Ingresa el elemento
		 * @param e
		 */
		public void setElement(E e) {
			element = e;
		}
		/**
		 * Obtiene nodo previo
		 * @return
		 */
		public Node<E> getPrev() {
			return prev;
		}
		/**
		 * ingresa nodo previo
		 * @param prev
		 */
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
		/**
		 * Obtiene nodo siguiente
		 * @return
		 */
		public Node<E> getNext() {
			return next;
		}
		/**
		 * Ingresa nodo siguiente
		 * @param next
		 */
		public void setNext(Node<E> next) {
			this.next = next;
		}
		

	}
	Node<E> cima;
    public DynamicStack<E> siguiente;
    public int posicion;
    public int size;
    public void setPosicion(int pos)
    {
        this.posicion = pos;
    }
    public int getPosicion()
    {
        return posicion;
    }
    /**
     * Constructor
     */
    public 	DynamicStack()
    {
        cima = null;
        siguiente = null;
    }
/**
 * Devuelve si la pila esta vacia
 */
    public boolean isEmpty()
    {
        return (cima == null);
    }
/**
 * Ingresa un dato en la pila
 */
    public void push(E dato)
    {
        Node<E> nuevo = new Node<E>(dato);
        if (!isEmpty())
        {
            nuevo.setPrev(cima);
            cima.setNext(nuevo);
        }
        cima = nuevo;
        size++;
    }//push insertar

/**
 * Muestra la cima de la pila
 */
    public E top()
    {
        E resultado = null;
        if (!isEmpty())
            resultado = cima.getElement();
        return resultado;
    }
/**
 * Saca la cima de la pila
 */
    public E pop()
    {
        E d;
        if (cima.getPrev() == null)
        {
            d = cima.getElement();
            cima = null;
        }
        else
        {
            d = cima.getElement();
            cima = cima.getPrev();
            cima.getNext().setPrev(null);
            cima.setNext(null);
        }
        size--;
        return d;
        
    }//pop eliminar
/**
 * Elimina la pila
 */
    public void eliminarPila()
    {
        E aux;
        while (!isEmpty())
            aux = pop();
    }
	@Override
	/**
	 * Devuelve el tamaño de la pila
	 */
	public int size() {
		return size;
	}


}
