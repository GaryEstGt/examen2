package gt.edu.url.examen2.problema4;

import gt.edu.url.examen2.problema4.PositionalList;
import gt.edu.url.examen2.problema4.Position;

public class LinkedPositionalList<E> implements PositionalList<E> {
	private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev;// Anterior
		private Node<E> next;// Siguiente
		private int indice=1000;
		

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		public E getElement() throws IllegalStateException {
			if (next == null) // Nodo no valido
				throw new IllegalStateException("Posicion invalida");
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
	
	private Node<E> header = null;// Referencia
	private Node<E> trailer = null;
	private int size = 0;
	int cont=0;

        private Position<E> p1,p2,p3;

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
	public int size() {return size;}

	public boolean isEmpty() {return size == 0;}

	public Position<E> first( ) {
		return position(header.getNext());
	}

	public Position<E> last( ) {
		return position(trailer.getPrev());
	}
	
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}
	
	
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
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}
	
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}
	
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{ 
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}
	
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
