import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.diadia.Partita;

class PartitaTest {
	private Partita partita;
	private Stanza stanzaVincente;
	@BeforeEach
	void setUp(){
		this.partita = new Partita();
		this.stanzaVincente = this.partita.getStanzaVincente();
	}

	@Test 
	void testGetStanzaCorrente() {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		/* la stanza iniziale non deve essere null */
		assertNotNull(stanzaCorrente); 
		/* la stanza iniziale della partita è atrio */
		assertEquals("Atrio",stanzaCorrente.getNome());
	}	
	@Test
	void testPartitaVinta() {
//		Stanza stanzaVincente = partita.getStanzaVincente();
        this.partita.setStanzaCorrente(stanzaVincente);
		/*la stanza vincente esiste*/
		assertNotNull(this.stanzaVincente);
		/*la biblioteca è la stanza vincente*/
		assertEquals("Biblioteca",this.stanzaVincente.getNome());
		/*la partita è finita se ci si trova nella stanza vincente*/
		assertTrue(this.partita.vinta());
	}
	@Test
	void testPartitaFinita() {
		this.partita.setCfu(0);
		/*la partita dovrebbe essere finita se si finiscono i cfu disponibili*/
		assertTrue(this.partita.isFinita());
		/*la partita è persa se i cfu sono finiti*/
		assertFalse(this.partita.vinta());
	}
}
