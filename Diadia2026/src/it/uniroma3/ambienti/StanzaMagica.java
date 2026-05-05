package it.uniroma3.ambienti;

import it.uniroma3.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {

	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	private static final int SOGLIA_MAGICA_DEFAULT = 3;

	public StanzaMagica(String nome, int sogliaMagica) {
		super(nome);
		this.sogliaMagica = sogliaMagica;
		this.contatoreAttrezziPosati = 0;
	}
	public StanzaMagica(String nome) {
		this(nome,SOGLIA_MAGICA_DEFAULT); // Richiama il primo costruttore cosi che una stanza di default venga creata 

	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito.reverse();
		int pesoX2 = attrezzo.getPeso()*2;
		return new Attrezzo(nomeInvertito.toString(),pesoX2);
	}

	@Override 
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if(this.contatoreAttrezziPosati>this.sogliaMagica) {
			attrezzo = this.modificaAttrezzo(attrezzo);
		}
		return super.addAttrezzo(attrezzo);
	}

}
