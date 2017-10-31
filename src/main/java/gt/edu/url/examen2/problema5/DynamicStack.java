package gt.edu.url.examen2.problema5;

import gt.edu.url.examen2.problema4.Position;


public class DynamicStack<E> implements Stack<E> {
	private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev;// Anterior
		private Node<E> next;// Siguiente
		private int indice=1000;
		

		public Node(E e) {
			element = e;
		}

		public E getElement() throws IllegalStateException {
			return element;
		}
		
		public void setElement(E e) {
			element = e;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
		public void setIndice(int i) {
			indice=i;
		}
		public int getIndice() {
			return indice;
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
    public 	DynamicStack()
    {
        cima = null;
        siguiente = null;
    }

    public boolean isEmpty()
    {
        return (cima == null);
    }

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


    public E top()
    {
        E resultado = null;
        if (!isEmpty())
            resultado = cima.getElement();
        return resultado;
    }

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

    public void eliminarPila()
    {
        E aux;
        while (!isEmpty())
            aux = pop();
    }
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}


}
