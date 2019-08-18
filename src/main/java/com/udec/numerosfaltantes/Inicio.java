/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.numerosfaltantes;

import com.udec.Logica.Logica;

/**
 * Clase inicio que contiene la funcion main que corre el programa.
 * @author Juan Ricardo Rodriguez Campos
 */
public class Inicio {
    
    /**
     * metodo estatico que instancia el objeto logica e inicia el programa.
     */
    public static void inicio(){
        Logica l = new Logica();
        l.menu();
    }
    
    public static void main(String[] args) {
        inicio();
    }
    
}

