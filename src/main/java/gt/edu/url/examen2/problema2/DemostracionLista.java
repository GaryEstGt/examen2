package gt.edu.url.examen2.problema2;

public class DemostracionLista implements DemoList {

	@Override
	public List<Integer> crearDemoLista() {
		List<Integer> lista=new Lista<>();
		
		lista.add(0, 4);
		lista.add(0, 3);
		lista.add(0, 2);
		lista.add(2, 1);
		lista.add(1, 5);
		lista.add(1, 6);
		lista.add(3, 7);
		lista.add(0, 8);
		return lista;
		
	}

}
