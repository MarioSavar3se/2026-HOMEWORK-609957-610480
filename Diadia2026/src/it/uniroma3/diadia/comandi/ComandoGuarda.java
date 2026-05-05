package it.uniroma3.diadia.comandi;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.diadia.Partita;
import it.uniroma3.giocatore.Giocatore;

public class ComandoGuarda implements Comando{

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Giocatore giocatore = partita.getGiocatore();
		System.out.println("Ti trovi in ");
		System.out.println(stanzaCorrente.getDescrizione());
		System.out.println("----Stato Partita----");
		System.out.println("Stato CFU attuale: ");
		System.out.println(giocatore.getCfu());
		System.out.println("Borsa: ");
		System.out.println(giocatore.getBorsa());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}

}
