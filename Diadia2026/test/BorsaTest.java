import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.giocatore.Borsa;

class BorsaTest {
		private Borsa borsa;
		private Attrezzo attrezzo;
	@BeforeEach
	void setUp() {
		this.borsa = new Borsa();
		this.attrezzo = new Attrezzo("Martello", 1);
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(this.attrezzo));
			}
	@Test 
	void testRemoveAttrezzo() {
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(this.attrezzo,this.borsa.removeAttrezzo("Martello"));
	}

}
