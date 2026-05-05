import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class ComandoPrendiTest {
	
	Partita p;
	Attrezzo a;
	Comando c;

	@BeforeEach
	void setUp() {
		
		this.p = new Partita();
		this.a = new Attrezzo("martello",2);
		this.c = new ComandoPrendi();
		this.p.getStanzaCorrente().addAttrezzo(a);
		
	}

	@Test
	void testPrendiSuccesso() {
		this.c.setParametro("martello");
		
		this.c.esegui(p);
		
		assertTrue(this.p.getGiocatore().getBorsa().hasAttrezzo("martello"));
		assertFalse(this.p.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	@Test
	void testPrendiAttrezzoNonEsistente() {
		this.c.setParametro("Trapano");
		
		this.c.esegui(p);
		assertTrue(this.p.getStanzaCorrente().hasAttrezzo("martello"));
		assertFalse(this.p.getGiocatore().getBorsa().hasAttrezzo("Trapano"));
		assertTrue(this.p.getGiocatore().getBorsa().isEmpty());
	}
	
	@Test 
	void testPrendiNull() {
		this.c.setParametro(null);
		
		this.c.esegui(p);
		
		assertTrue(this.p.getGiocatore().getBorsa().isEmpty());
	}
	
	@Test
	void testPrendiBorsaPiena() {
		Attrezzo pesante = new Attrezzo("mattone", 10);
		this.p.getGiocatore().getBorsa().addAttrezzo(pesante);
		
		this.c.setParametro("martello");
		this.c.esegui(p);
		
		assertTrue(this.p.getGiocatore().getBorsa().hasAttrezzo("mattone"));
		assertFalse(this.p.getGiocatore().getBorsa().hasAttrezzo("martello"));
	}
	

}
