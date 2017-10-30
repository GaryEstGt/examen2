package gt.edu.url.examen2.problema2;


import java.util.Iterator;

public class Lista<E> implements List<E>{

	private int size=0;
	private Object[] lista =new Object[1];

	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public E get(int i) {
		// TODO Auto-generated method stub
		E guardar=null;
		for(int x=0;x<lista.length;x++) {
			if(lista[x]==lista[i]) {
				guardar=(E) lista[i];
			}
		}
			return guardar;
	}

	@Override
	public E set(int i, E e) {
		if(i>lista.length) {
			return null;
		}
		else {
			lista[i]=e;
		}
		
		return e;
	}

	@Override
	public void add(int i, E e) {
		if(isEmpty()==true) {
			if(i>1) {
				lista=new Object[i+1];
			
			}
			else {
				lista[i]=e;
			}
	
		}
		else {
			if(i>lista.length-1) {
				Object[] temp=new Object[i+1];
				for(int x=0;x<lista.length;x++) {
					temp[x]=lista[x];
				}
				lista=temp;
				lista[i]=e;
			
			}
			else {
				
					reaposicionar(i);
					lista[i]=e;
					
				
			}
		}
		size++;

	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		E guardar=null;
		if(i>lista.length) {
			throw new IndexOutOfBoundsException("Posicion Invalida");
		}
		else {
			for(int x=0;x<lista.length;x++) {
				if(lista[x]==lista[i]) {
					guardar=(E) lista[i];
					lista[i]=null;
				}
			}
		}
		return guardar;
	}
	
	public void reaposicionar(int i) {
		int tam=lista.length;
		Object[] temp=new Object[tam+1];
		for(int x=0;x<lista.length;x++) {
			temp[x]=lista[x];
		}
		lista=temp;
		Object save;
		for(int x=lista.length-1;x>i;x--) {
			
			lista[x]=lista[x-1];
		}
		
	}
	public void Mostrar() {
		for(int x=0;x<lista.length;x++) {
			System.out.println("lista "+lista[x]);
		}
	}

}
