package it.uniroma3.diadia.comandi;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando{
	
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		if(this.nomeAttrezzo == null) {
			System.out.println("Che cosa vuoi posare?");
			return;
		}
		if(a!=null) {
			partita.getStanzaCorrente().addAttrezzo(a);
//			System.out.println("Hai posato "+a+"!");
			System.out.println("Hai posato "+a+"!");
		}else {
//			System.out.println(" non e' nella tua borsa!");
			System.out.println(" non e' nella tua borsa!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro ;		
	}
	
}
