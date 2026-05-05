import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.ambienti.StanzaBloccata;
import it.uniroma3.attrezzi.Attrezzo;

class StanzaBloccataTest {
	private StanzaBloccata stanza;
	private Attrezzo piccone;
	private Stanza stanzaAdiacente;

	@BeforeEach
	void setUp() {
		
		this.stanza = new StanzaBloccata("Cantina", "nord", "piccone");
		this.piccone = new Attrezzo("piccone", 1);
		this.stanzaAdiacente = new Stanza("n11");
		this.stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
	}


	@Test
	void testSbloccaStanza() {
		this.stanza.addAttrezzo(piccone);
		
		assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente("nord"));
	}
	@Test
	void testSbloccaStanzaSenzaAttrezzo() {
		
		Stanza stanzaOttenuta = stanza.getStanzaAdiacente("nord");
		
		assertNotEquals(stanzaAdiacente, stanzaOttenuta);
		
	}

}
