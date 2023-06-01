// Copyright (C) 2023
// All rights reserved

package Clases;

public class CiudadPopular {
    public String nombre;
    public int valor;

    /**
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return  valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @param nombre
     * @param valor
     */
    public CiudadPopular(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return "(" + nombre + " , " + valor + ')';
    }


}
