package testsController;

import static org.junit.jupiter.api.Assertions.*;
import loja.*;
import org.junit.jupiter.api.Test;

class testController {

	@Test
	void testAddClient() {
		Controller controller = new Controller();
		
		//Mistakes when adding a client
		assertThrows(IllegalArgumentException.class,
				() -> controller.adicionaCliente("123", "Victor", "victor@uolc.com", "lcc3"));
		assertThrows(IllegalArgumentException.class,
				() -> controller.adicionaCliente("12345678910", "", "victor@uol.com", "lcc3"));
		
		assertThrows(IllegalArgumentException.class,
				() -> controller.adicionaCliente("12345678910", "Victor", "", "lcc3"));
		
		assertThrows(IllegalArgumentException.class,
				() -> controller.adicionaCliente("12345678910", "Victor", "victor@uol.com", ""));
	
		//Adding a client correctly, the return is the String clientCpf
		assertEquals("12345678910", controller.adicionaCliente("12345678910", "Victor", "victor@uol.com", "lcc3"));
	}

}
