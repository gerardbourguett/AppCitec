package com.gerard.curso.citec.objetos;

/**
 * Created by laboratorio on 05-03-2018.
 */

public class Constructora {

    String rut;

    public Constructora() {
    }

    public Constructora(String rut) {
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    @Override
    public String toString() {
        return "Constructora{" +
                "rut='" + rut + '\'' +
                '}';
    }
}
