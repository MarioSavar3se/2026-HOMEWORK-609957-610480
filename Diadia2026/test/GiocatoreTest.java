/**
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.giocatore.Giocatore;

/**
 * 
 */
class GiocatoreTest {

	private Giocatore giocatore;
	
	@BeforeEach
	void setup() {
		this.giocatore=new Giocatore();
	}
	@Test
	void testCfuIniziali() {
		assertEquals(20,this.giocatore.getCfu());
	}


}
