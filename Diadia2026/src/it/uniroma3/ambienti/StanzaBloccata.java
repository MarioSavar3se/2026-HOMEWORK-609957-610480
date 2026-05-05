package it.uniroma3.ambienti;

public class StanzaBloccata extends Stanza{

	String nomeDirBloccata;
	String nomeAttrezzoPerSbloccare;
	
	public StanzaBloccata(String nome, String nomeDirBloccata, String nomeAttrezzoPerSbloccare) {
		super(nome);
		this.nomeDirBloccata = nomeDirBloccata;
		this.nomeAttrezzoPerSbloccare = nomeAttrezzoPerSbloccare;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(dir.equals(this.nomeDirBloccata) && !super.hasAttrezzo(this.nomeAttrezzoPerSbloccare)) {
			return this;
		}else {
			return super.getStanzaAdiacente(dir);
		}
	}
	
	@Override
	public String getDescrizione() {
		
		String blocco = "La stanza sembra essere bloccata nella direzione " + this.nomeDirBloccata + " Provo a forzarla a mano... No, non va... servirebbe un " + this.nomeAttrezzoPerSbloccare;
		
		return blocco + super.toString();
	}
}
