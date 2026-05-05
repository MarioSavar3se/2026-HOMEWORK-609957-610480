import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.StanzaBuia;
import it.uniroma3.attrezzi.Attrezzo;

class StanzaBuiaTest {

	private StanzaBuia stanza;
	private Attrezzo lanterna;

	@BeforeEach
	void setUp() {
		
		this.stanza = new StanzaBuia("Cantina", "lanterna");
		this.lanterna = new Attrezzo("lanterna", 1);
	}

	@Test
	void testGetDescrizioneAlBuio() {
		
		String descrizione = this.stanza.getDescrizione();
		assertEquals("E' buio pesto qui...", descrizione);
	}

	@Test
	void testGetDescrizioneConLuce() {
		
		this.stanza.addAttrezzo(this.lanterna);
		
		String descrizione = this.stanza.getDescrizione();
		
		assertNotEquals("E' buio pesto qui...", descrizione);
	
	}

}
