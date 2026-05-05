package it.uniroma3.diadia.comandi;


import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.Partita;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
		if(this.nomeAttrezzo==null) {
			System.out.println("Cosa vuoi prendere?");
			return;
		}
		if(a==null) {
			System.out.println("L'attrezzo non è in stanza");
		}
		if(a!=null) {
			if(partita.getGiocatore().getBorsa().addAttrezzo(a)) {
				System.out.println("Hai preso:" + a.getNome() );
			}else {
				partita.getStanzaCorrente().addAttrezzo(a);
				System.out.println("La borsa è tropo piena per questo attrezzo!");
			}
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro; 
		
	}
	
}
