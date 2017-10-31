
import gt.edu.url.examen2.problema2.Lista;
import gt.edu.url.examen2.problema4.LinkedPositionalList;
import gt.edu.url.examen2.problema4.Position;
import gt.edu.url.examen2.problema4.PositionalList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Lista<Integer> lista=new Lista<>();
		lista.add(0, 4);
		lista.add(0, 3);
		lista.add(0, 2);
		lista.add(2, 1);
		lista.add(1, 5);
		lista.add(1, 6);
		lista.add(3, 7);
		lista.add(0, 8);
		System.out.println(lista.remove(0));
		lista.Mostrar();*/
		/*****************************************Termina serie i***********************************************************************************/
		PositionalList<String> listap=new LinkedPositionalList<>();
		Position<String> P01,P02,P03;
		P01=listap.addFirst("a");
		P02=listap.addAfter(P01, "b");
		P03=listap.addAfter(P02, "c");
		System.out.println(listap.positionAtIndex(0).getElement());
		/******************************************Tercera Serie**************************************************************************/
		
		
	}

}
