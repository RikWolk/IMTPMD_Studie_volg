package com.example.vindoozero.studievolg.Periodes;

/**
 * Created by Kasper on 19-6-2017.
 */

public class classPeriodes {
    private int ec;
    private int jaar;
    private int periode;
    private boolean keuzevak;
    private boolean gehaald;
    private int cijfer;
    private String naam;

    public classPeriodes() {

    }

    public int getCijfer() {
        return cijfer;
    }

    public void setCijfer(int cijfer) {
        this.cijfer = cijfer;
    }

    public boolean isGehaald() {
        return gehaald;
    }

    public void setGehaald(boolean gehaald) {
        this.gehaald = gehaald;
    }

    public boolean isKeuzevak() {
        return keuzevak;
    }

    public void setKeuzevak(boolean keuzevak) {
        this.keuzevak = keuzevak;
    }

    public int getEc() {
        return ec;
    }

    public void setEc(int ec) {
        this.ec = ec;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return naam;
    }

}
