package it.uniroma3.diadia;


import java.util.Scanner;


public class IOConsole implements IO {
    private Scanner scanner;

    public IOConsole() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void mostraMessaggio(String msg) {
        System.out.println(msg);
    }

    @Override
    public String leggiRiga() {
        return this.scanner.nextLine();
    }
}