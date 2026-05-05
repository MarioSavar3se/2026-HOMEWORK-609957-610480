package it.uniroma3.ambienti;

public class StanzaBuia extends Stanza {
	
	private String attrezzoIlluminante;

	public StanzaBuia(String nome, String N) {
		super(nome);
		this.attrezzoIlluminante = N;
	}
	
	@Override 
	public String getDescrizione() {
		String blocco = "E' buio pesto qui...";
		String bloccoSol = " Questo può aiutarmi..";
		if(super.hasAttrezzo(attrezzoIlluminante)) {
			return bloccoSol + super.getDescrizione();
		}
		return blocco;
	}

}
