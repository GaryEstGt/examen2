package gt.edu.url.examen2.problema4;

import gt.edu.url.examen2.problema4.PositionalList;
import gt.edu.url.examen2.problema4.Position;

public class LinkedPositionalList<E> implements PositionalList<E> {
	/**
	 * Clase nodo
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
		 * Constructor
		 * @param e
		 * @param p
		 * @param n
		 */
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		/**
		 * Obtiene el elemento
		 */
		public E getElement() throws IllegalStateException {
			if (next == null) // Nodo no valido
				throw new IllegalStateException("Posicion invalida");
			return element;
		}

		/**
		 * Se ingresa el elemento en el nodo
		 * @param e
		 */
		public void setElement(E e) {
			element = e;
		}
		/**
		 * Retorna nodo previo
		 * @return nodo previo
		 */
		public Node<E> getPrev() {
			return prev;
		}
		/**
		 * Se establece nodo previo
		 * @param prev
		 */
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
		/**
		 * Retorna nodo siguiente
		 * @return nodo siguiente
		 */
		public Node<E> getNext() {
			return next;
		}
		/**
		 * Se ingresa nodo siguiente
		 * @param next
		 */
		public void setNext(Node<E> next) {
			this.next = next;
		}
		/**
		 * Ingresa indice
		 * @param i
		 */
		public void setIndice(int i) {
			indice=i;
		}
		/**
		 * Obtiene indice
		 * @return
		 */
		public int getIndice() {
			return indice;
		}

	}
	
	private Node<E> header = null;// Referencia
	private Node<E> trailer = null;
	private int size = 0;
	int cont=0;

        private Position<E> p1,p2,p3;
/**
 * Consructor
 */
	public LinkedPositionalList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	// Metodos internos
	/**
	 * Valida si una posicion contiene un nodo y el nodo existe
	 */
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("P invalido");
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getNext() == null)
			throw new IllegalArgumentException("p ya no se encuentra en la lista");
		return node;
	}
	
	/**
	 * "Empaca" un nodo como posicion a menos que sea header o trailer
	 */
	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer)
			return null; // do not expose user to the sentinels
		return node;
	}

	// ---

    @Override
    /**
     * Obtiene tamaño
     */
	public int size() {return size;}
    /**
     * Obtiene si esta vacia
     */
	public boolean isEmpty() {return size == 0;}
	/**
	 * retorna el primer dato
	 */
	public Position<E> first( ) {
		return position(header.getNext());
	}
	/**
	 * Retorna el ultimo
	 */
	public Position<E> last( ) {
		return position(trailer.getPrev());
	}
	/**
	 * Retorna el dato antes de la posicion indicada
	 */
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}
	/**
	 * Retorna el dato despues de la posicion indicada
	 */
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}
	
	/**
	 * Ingresa un dato entre los nodos indicados
	 * @param e
	 * @param pred
	 * @param succ
	 * @return
	 */
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
            Node<E> newest = new Node<>(e, pred, succ);  
        	  newest.setIndice(cont);
        	  cont++;
                succ.setPrev(newest);
		size++;
  	     
		return newest;
	}
	
	public Position<E> getP1(){
            if (p1==null) {
                System.out.println("No hay posicion p1");
                return null;               
            }
            else{
                System.out.println("elemento "+p1);
                return p1;
            }
        }
        public Position<E> getP2(){
            if (p2==null) {
                System.out.println("No hay posicion p2");
                return null;
            }
            else{
                System.out.println("elemento "+p2.getElement());
                return p2;
            }
        }
          public Position<E> getP3(){
            if (p3==null) {
                System.out.println("No hay posicion p3");
                return null;
            }
            else{
                System.out.println("elemento "+p3.getElement());
                return p3;
            }
        }
      	/**
      	 * Ingrese un dato despues del head
      	 */
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}
	/**
	 * Ingrese un dato antes del trailer
	 */
	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}
	/**
	 * ingresa un dato antes de la posicion indicada
	 */
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}
	/**
	 * Ingresa un dato despues de la posicion indicada
	 */
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{ 
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}
	/**
	 * ingresa un valor en la posicion indicada
	 */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}
	/**
	 * elimina un dato en la posicion indicada
	 */
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}
	 
	@Override
	/**
	 * Devuelve la posicion del nodo segun el indice ingresado
	 */
	public Position<E> positionAtIndex(int i) {
		Node<E> temp=trailer;
		Node<E> retorno=null;
		while(temp!=null) {
			if(temp.getIndice()==i) {
				retorno=temp;
				temp=null;
			}
			else {
				temp=temp.getPrev();
			}
			
			
		}
	if(retorno==null) {
		new IndexOutOfBoundsException();
	}
		return position(retorno);
	}


	
}
