package testsController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import loja.Controller;

class testController {

//	@BeforeAll
//	public static void startController() {
//		Controller controller = new Controller();
//	}

	@Test
	void testAddClient() {

		Controller controller = new Controller();

		// Mistakes when adding a client
		assertThrows(IllegalArgumentException.class,
				() -> controller.adicionaCliente("123", "Victor", "victor@uolc.com", "lcc3"));
		assertThrows(IllegalArgumentException.class,
				() -> controller.adicionaCliente("12345678910", "", "victor@uol.com", "lcc3"));

		assertThrows(IllegalArgumentException.class,
				() -> controller.adicionaCliente("12345678910", "Victor", "", "lcc3"));

		assertThrows(IllegalArgumentException.class,
				() -> controller.adicionaCliente("12345678910", "Victor", "victor@uol.com", ""));

		// Adding a client correctly, the return is the String clientCpf
		assertEquals("12345678910", controller.adicionaCliente("12345678910", "Victor", "victor@uol.com", "lcc3"));
	}

	@Test
	void testRecoverClient() {
		Controller controller = new Controller();

		// invalid cpf to recover client, must have length = 11.
		assertThrows(IllegalArgumentException.class, () -> controller.exibeCliente("123"));
		// cpfNumber cant be empty ou null
		assertThrows(IllegalArgumentException.class, () -> controller.exibeCliente(" "));

		//adding client e recovering him. 
		controller.adicionaCliente("12345678910", "victor", "victor@uol.com", "lcc3");
		assertEquals("victor - lcc3 - victor@uol.com", controller.exibeCliente("12345678910"));
		
		//trying do recover a non registred client
		assertThrows(NullPointerException.class, () -> controller.exibeCliente("12345678911"));

	}

}
