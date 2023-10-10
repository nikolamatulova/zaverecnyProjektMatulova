/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojisteni;

/**
 *
 * @author Nary
 */
public class Pojistenec {

    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telCislo;
    
    /*
    Konstruktor noveho pojisteneho
    */
    Pojistenec() {
    }

    /**
     * @return jmeno pojisteneho
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * @param jmeno jmeno pojisteneho
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
        }
   
    /**
     * @return prijmeni pojisteneho
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * @param prijmeni prijmeni pojisteneho
     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * @return vek pojisteneho
     */
    public int getVek() {
        return this.vek;  
    }

    /**
     * @param vek vek pojisteneho
     */
    public void setVek(int vek) {
        this.vek = vek;
    }

    /**
     * @return the telefonni cislo pojisteneho
     */
    public String getTelCislo() {
        return this.telCislo;
    }

    /**
     * @param telCislo telefonni cislo pojisteneho
     */
    public void setTelCislo(String telCislo) {
        this.telCislo = telCislo;
    }    
    
    /*
    Override vypsani vsech udaju pojisteneho, oddelenych tabulatorem
    */
    @Override
    public String toString() {
        return jmeno + "\t" + prijmeni + "\t" + telCislo + "\t" + vek;
    }
    
    
}
