package com.gerard.curso.citec.objetos;

import android.widget.TextView;

/**
 * Created by Gerard on 18-01-2018.
 */

public class DatoRandom {
    String dato1;
    String dato2;
    int numero1;
    int numero2;

    public DatoRandom(TextView dato1, TextView dato2, TextView numero1, TextView numero2) {
    }

    public DatoRandom(String dato1, String dato2, int numero1, int numero2) {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public String getDato1() {
        return dato1;
    }

    public void setDato1(String dato1) {
        this.dato1 = dato1;
    }

    public String getDato2() {
        return dato2;
    }

    public void setDato2(String dato2) {
        this.dato2 = dato2;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }
}
