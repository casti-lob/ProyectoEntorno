package elementos;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Pruebas {

	public static void main(String[] args) {
		
		Element e = new Element(ElementType.ROCA);
		
		System.out.println(e.getType());
		
	}

}
