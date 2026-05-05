package it.uniroma3.diadia.comandi;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.diadia.Partita;

public class ComandoVai implements Comando{
	private String direzione;

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.direzione==null) {
			//			System.out.println("Dove vuoi andare ?");
			System.out.println("Dove vuoi andare?");
			return;
		}

		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			//			System.out.println("Direzione inesistente");
			System.out.println("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		int cfu = partita.getCfu();
		partita.setCfu(cfu-1);
		//		System.out.println(partita.getStanzaCorrente().getDescrizione());
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}


	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;

	}

}
