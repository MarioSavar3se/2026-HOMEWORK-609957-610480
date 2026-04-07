import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Labirinto;
import it.uniroma3.ambienti.Stanza;

class LabirintoTest {
	private Labirinto labirinto;
	private Stanza atrio;
	@BeforeEach
	void setUp(){
		this.labirinto = new Labirinto();
		this.atrio = this.labirinto.getStanzaCorrente();
	}

	@Test
	void testCreazioneStanze() {
		/*Test stanza iniziale*/
		assertEquals("Atrio",this.labirinto.getStanzaCorrente().getNome());
		/*Test stanza vincente*/
		assertEquals("Biblioteca",this.labirinto.getStanzaVincente().getNome());
	}
	@Test
	void testAttrezziIniziali() {

		assertTrue(this.atrio.hasAttrezzo("osso"));
	}
	@Test
	void testStanzeAdiacenti() {
		assertEquals("Biblioteca",this.atrio.getStanzaAdiacente("nord").getNome());
		assertEquals("Aula N11",this.atrio.getStanzaAdiacente("est").getNome());
		assertEquals("Aula N10",this.atrio.getStanzaAdiacente("sud").getNome());
		assertEquals("Laboratorio Campus",this.atrio.getStanzaAdiacente("ovest").getNome());
	}

}
