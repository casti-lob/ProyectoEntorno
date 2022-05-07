package elementos;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Pruebas {

	public static void main(String[] args) {
		Coordenada c = new Coordenada();
		System.out.println(c);
		Element e = new Element(ElementType.ROCA);
		String[] lista = new String[10];
		
		System.out.println(lista.length);
		System.out.println(e.getType());
		
	}

}
