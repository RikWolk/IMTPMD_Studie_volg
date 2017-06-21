package com.example.vindoozero.studievolg.Periodes;

/**
 * Created by Kasper on 19-6-2017.
 */

public class classPeriodes {
    private int ec;
    private int jaar;
    private int periode;
    private String vak;

    public classPeriodes() {

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

    public String getVak() {
        return vak;
    }

    public void setVak(String vak) {
        this.vak = vak;
    }

    @Override
    public String toString() {
        return vak;
    }
}
