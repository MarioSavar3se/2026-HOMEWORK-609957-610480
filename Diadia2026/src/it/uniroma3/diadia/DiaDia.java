package it.uniroma3.diadia;


//import java.util.Scanner;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private IOConsole io;
	private Partita partita;


	public DiaDia(IOConsole io) {
		this.io = io;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
//		Scanner scannerDiLinee;
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
//		System.out.println(MESSAGGIO_BENVENUTO);
//		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
		}
		else if (comandoDaEseguire.getNome().equals("aiuto")) {
			this.aiuto();
		}
		else if (comandoDaEseguire.getNome().equals("prendi")){

			this.prendi(comandoDaEseguire.getParametro());
		}
		else if (comandoDaEseguire.getNome().equals("posa")){
			this.posa(comandoDaEseguire.getParametro());

		}else {	
//			System.out.println("Comando sconosciuto");
			this.io.mostraMessaggio("Comando sconosciuto");
		}
			if (this.partita.vinta()) {
//				System.out.println("Hai vinto!");
				this.io.mostraMessaggio("Hai Vinto!");
				return true;
			} else
				return false;
		} 
	

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
//			System.out.print(elencoComandi[i]+" ");
			this.io.mostraMessaggio(elencoComandi[i]+" ");
//		System.out.println();
		this.io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
//			System.out.println("Dove vuoi andare ?");
			this.io.mostraMessaggio("Dove vuoi andare?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
//			System.out.println("Direzione inesistente");
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu-1);
		}
//		System.out.println(partita.getStanzaCorrente().getDescrizione());
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Prendi un oggetto da una stanza
	 */
	private void prendi(String nomeAttrezzo) {
		Attrezzo a = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		this.partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
		if(a!=null) {
			if(this.partita.getGiocatore().getBorsa().addAttrezzo(a)) {
//				System.out.println("Hai preso:" + a.getNome());
				this.io.mostraMessaggio("Hai preso:" + a.getNome() );
			}else {
				this.partita.getStanzaCorrente().addAttrezzo(a);
//				System.out.println("La borsa è troppo piena per questo attrezzo!");
				this.io.mostraMessaggio("La borsa è tropo piena per questo attrezzo!");
			}
		}else {
//			System.out.println("L'oggetto non e' nella stanza");
			this.io.mostraMessaggio("L'oggetto non è nella stanza");
		}

	}
	/**
	 *  Posa un oggetto dalla borsa
	 */
	private void posa(String nomeAttrezzo) {
		Attrezzo a = this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		if(a!=null) {
			this.partita.getStanzaCorrente().addAttrezzo(a);
//			System.out.println("Hai posato "+a+"!");
			this.io.mostraMessaggio("Hai posato "+a+"!");
		}else {
//			System.out.println(" non e' nella tua borsa!");
			this.io.mostraMessaggio(" non e' nella tua borsa!");
		}
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
//		System.out.println("Grazie di aver giocato!");  // si desidera smettere
		this.io.mostraMessaggio("Grazie di aver giocato!");
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
		
	}
}