/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojisteni;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nicol
 */
public class Evidence {

    private final Scanner scanner = new Scanner(System.in, "UTF-8");
    private final ArrayList<Pojistenec> seznamPojistenych = new ArrayList<>();

    /*
    Zajisteni behu programu
     */
    public void Program() {
        String volba = "";

        /* 
        pokud uzivatel nezvoli 5, zobrazi se menu, ze ktereho uzivatel vybere 
        dalsi akci
         */
        while (!volba.equals("5")) {
            zobrazMenu();

            System.out.println("Vyberte cislo:");
            volba = scanner.nextLine();

            switch (volba) {
                case "1" ->
                    vytvorPojistence();
                case "2" ->
                    vypisPojistence();
                case "3" ->
                    vyhledejPojisteneho();
                case "4" ->
                    vytiskniPocetPojistenych();
                case "5" ->
                    System.out.println("Zaviram evidenci. Preji pekny den.");
                default ->
                    System.out.println("Neplatne cislo, opakujte prosim volbu.");

            }
        }
    }

    /* 
    Zakladni menu evidence
     */
    void zobrazMenu() {
        System.out.println("------------- Evidence Pojistenych -------------");
        System.out.println("Vyberte si akci pomoci cisla:");
        System.out.println("1 - Pridat noveho pojisteneho");
        System.out.println("2 - Vypsat vsechny pojistene");
        System.out.println("3 - Vyhledat pojisteneho");
        System.out.println("4 - Vypsat pocet pojistenych v evidenci");
        System.out.println("5 - Konec");
    }

    /* Pridani noveho pojistence pomoci konstruktoru, podminek +
       pokracovani stisknutim klavesy Enter
     */
    void vytvorPojistence() {
        System.out.println("Pridani Pojisteneho");
        System.out.println("--------------------");
        Pojistenec pojistenec = new Pojistenec();
        System.out.println("Zadejte jmeno pojisteneho:");
        pojistenec.setJmeno(scanner.nextLine().trim());
        while (pojistenec.getJmeno().isEmpty()) {
            System.out.println("Nezadali jste jmeno. Zkuste to znovu.");
            System.out.println("Zadejte jmeno pojisteneho:");
            pojistenec.setJmeno(scanner.nextLine().trim());
        }

        System.out.println("Zadejte prijmeni pojisteneho:");
        pojistenec.setPrijmeni(scanner.nextLine().trim());
        while (pojistenec.getPrijmeni().isEmpty()) {
            System.out.println("Nezadali jste prijmeni. Zkuste to znovu.");
            System.out.println("Zadejte prijmeni pojisteneho:");
            pojistenec.setPrijmeni(scanner.nextLine());
        }

        System.out.println("Zadejte telefonni cislo ve tvaru #########:");
        pojistenec.setTelCislo(scanner.nextLine().trim());
        while (!pojistenec.getTelCislo().matches("[0-9]+") || pojistenec.getTelCislo().length() < 9) {
            System.out.println("Cislo obsahuje nepodporovane znaky nebo je prilis kratke. Zkuste to znovu");
            System.out.println("Zadejte telefonni cislo ve tvaru #########:");
            pojistenec.setTelCislo(scanner.nextLine().trim());
        }

        System.out.println("Zadejte vek pojisteneho:");
        try {
            pojistenec.setVek(Integer.parseInt(scanner.nextLine()));
        } catch
                (NumberFormatException e) {
            System.out.println("Zadali jste vek ve spatnem formatu, zkuste to znovu.");
            System.out.println("Zadejte vek pojisteneho:");
            pojistenec.setVek(Integer.parseInt(scanner.nextLine()));
        }  
        seznamPojistenych.add(pojistenec);
        System.out.println("Data byla ulozena");
        stiskniEnter();
    }

    /*
    Vypis vsech pojistencu v evidenci
     */
    void vypisPojistence() {
        System.out.println("Vypisuji vsechny pojistence v evidenci");
        System.out.println("--------------------------------------");
        if (!seznamPojistenych.isEmpty()) {
            System.out.println("Nalezeni tito pojisteni: ");
            for (Pojistenec seznamPojistenych1 : seznamPojistenych) {
                System.out.println(seznamPojistenych1);
            }
        } else {
            System.out.println("Nebyli nalezeni zadni pojisteni.");
        }
        stiskniEnter();
    }

    /*
    Hledani pojistence na zaklace zadani jmena a prijmeni
     */
    void vyhledejPojisteneho() {
        System.out.println("Hledam daneho pojistence v evidenci...");
        System.out.println("---------------------------------------");
        System.out.println("Zadejte jmeno pojisteneho:");
        String jmenoHledaneho = scanner.nextLine();
        System.out.println("Zadejte prijmeni pojisteneho: ");
        String prijmeniHledaneho = scanner.nextLine();
        for (Pojistenec hledanyPojisteny : seznamPojistenych) {
            if (hledanyPojisteny.getJmeno().equals(jmenoHledaneho) && hledanyPojisteny.getPrijmeni().equals(prijmeniHledaneho)) {
                System.out.println(hledanyPojisteny);
                break;
            }
        }
        stiskniEnter();
    }

    /*
    Zobrazeni aktualniho poctu pojistenych v evidenci
     */
    void vytiskniPocetPojistenych() {
        System.out.println("-----------------------------------------");
        System.out.println("Aktualni pocet pojistenych v evidenci: " + seznamPojistenych.size());
        System.out.println("-----------------------------------------");
        stiskniEnter();
    }

    /*
    uzivatel musi stisknout  ENTER, aby se znovu zobrazilo menu
     */
    void stiskniEnter() {
        System.out.println("Stisknete ENTER k pokracovani...");
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }

}
