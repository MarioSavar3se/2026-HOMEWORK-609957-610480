
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;


class StanzaTest {
	private Stanza stanza;
	@BeforeEach
	void setup() {
		//Evito codice duplicato
		this.stanza = new Stanza("TestStanza");
	}

	@Test
	void testAddAttrezzo() {
//		Creo un nuovo attrezzo Chiave
		Attrezzo attrezzo = new Attrezzo("Chiave",1);
		
		assertTrue(this.stanza.addAttrezzo(attrezzo),"L'aggiunta dell'attrezzo dovrebbe avere successo. -> return true.");
		assertTrue(this.stanza.hasAttrezzo("Chiave"),"La stanza dovrebbe contenere l'attrezzo chiave. -> return true.");
		assertEquals(attrezzo,stanza.getAttrezzo("Chiave"), "La stanzadovrebbe contenere una chiave. .getAttrezzo restituisce Chiave.");
		
	}
	
	@Test
	void testRemoveAttrezzo() {
		
		Attrezzo attrezzo = new Attrezzo("Martello",1);
		
		stanza.addAttrezzo(attrezzo);
		
		assertTrue(this.stanza.removeAttrezzo("Martello"),"Il martello dovrebbe venire rimosso dalla stanza dovrebbe restituire true.");
		assertFalse(this.stanza.hasAttrezzo("Martello"),"La stanza non ha il martello.");
	}
	
	@Test
	void testStanzaAdiacente() {
		
		Stanza stanza2= new Stanza("TestStanzaVicina");
		
		this.stanza.impostaStanzaAdiacente("Sinistra", stanza2);
		
		assertEquals(stanza2,this.stanza.getStanzaAdiacente("Sinistra"),"La stanza a sinistra dovrebbe essere la stanza TestStanzaVicina");
	}

}
