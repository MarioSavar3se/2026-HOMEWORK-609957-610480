import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;

class ComandoPosaTest {

	Partita p;
	Comando c;
	Attrezzo a;
	
	@BeforeEach
	void setUp(){
		this.p = new Partita();
		this.c = new ComandoPosa();
		this.a = new Attrezzo("martello", 2);
	}

	@Test
	void testPosaSuccesso() {
		this.p.getGiocatore().getBorsa().addAttrezzo(a);
		
		this.c.setParametro("martello");
		this.c.esegui(p);
		
		assertFalse(this.p.getGiocatore().getBorsa().hasAttrezzo("martello"));
		assertTrue(this.p.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	@Test 
	void testPosaNull() {
		
		this.p.getGiocatore().getBorsa().addAttrezzo(a);
		
		this.c.setParametro(null);
		this.c.esegui(p);
		
		
		
		assertFalse(this.p.getStanzaCorrente().hasAttrezzo("martello"));
		
	}
	
	@Test
	void testPosaAttrezzoNonInBorsa() {
		
		this.c.setParametro("martello");
		this.c.esegui(p);
		
		assertFalse(this.p.getStanzaCorrente().hasAttrezzo("martello"));
		assertFalse(this.p.getGiocatore().getBorsa().hasAttrezzo("martello"));
		
	}

}
