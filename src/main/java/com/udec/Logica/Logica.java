/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.Logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Esta clase continene las funciones que permiten el funcionamiento del programa
 * @since NumeroFaltante 1.0
 * @version 1.0
 * @author Juan Ricardo Rodriguez Campos
 */
public class Logica {
    /**
     * Variables globales de la clase
     */
    private int[] vector;
    private Scanner consola = new Scanner(System.in);
    
    /**
     * Esta clase se encarga de captiurar los numeros dados por el usuario,
     * con ellos se construye el vector original
     * @param op parametro opcion (1/0) para iniciar o cerrar el programa
     */
    public void capturaDeDatos(byte op){
        String valor,vectorNumeros="";       
        while(op==1){
            System.out.println(" Ingrese el valor : ");
            valor=consola.next();
            if(validacionNumeros(valor)){
                if(!numeroRepetido(vectorNumeros, valor)){
                    vectorNumeros=vectorNumeros+valor;
                    if(mensajeContinuar()==1){
                        vectorNumeros=vectorNumeros+",";
                    }else{
                        op=0;
                    }
                }else{
                    System.out.println("El numero ya fue ingresado ");
                }              
            }else{
                System.out.println("No es un Numero");
            }
        }
        System.out.println("Numeros Ingresados : ["+vectorNumeros+"]");
        retornoNumerosFaltantes(generadorDeVector(vectorNumeros));
    }
    
    /**
     * Funcion que recibe un String y lo convierte en un arreglo de tipo entero
     * @param vectorNumeros cadena de tipo String que contiene los numeros ingresados
     * @return retorna un arreglo de tipo entero
     */
    public int[] generadorDeVector(String vectorNumeros){
        //int vector[] = new int[];
        String[] cadenaNumeros = vectorNumeros.split(",");
        vector = new int[cadenaNumeros.length];
        for(int i=0;i<cadenaNumeros.length;i++){
                vector[i]= Integer.parseInt(cadenaNumeros[i]);    
        }
        return vector;
    }
    
    /**
     * Funcion que recorre un arreglo de tipo entero e imprime que numero(s) faltan
     * @param vector arreglo de tipo entero que contiene los numeros ingresados
     */
    public void retornoNumerosFaltantes(int[] vector){
        Arrays.sort(vector); 
        String mensaje="";
        int minimo = vector[0];
        for(minimo = vector[0];minimo<=vector[vector.length-1];minimo++){           
            byte estado=0;
            for(int i=0;i<vector.length;i++){
                if(vector[i]==minimo){
                    estado = 1;
                }              
            }
            if(estado==0){
                mensaje=mensaje+minimo+",";
            }
            
        }
        System.out.println("Numeros Faltantes :"+"["+mensaje+"]");
    }
    
    /**
     * Funcion que valida si el numero ingresado ya se encuentra en el arreglo 
     * @param vector arreglo con los ultimos numeros ingresados
     * @param numeroIngresado ultimo numero ingresado
     * @return retorna true o false dependiendo si el numero ya estaba o no en arreglo
     */
    public boolean numeroRepetido(String vector,String numeroIngresado){
        int numero = Integer.parseInt(numeroIngresado);
        if(vector.length()!=0){
            String[] cadenaNumeros = vector.split(",");
            for(int i=0;i<cadenaNumeros.length;i++){
                if(numero==Integer.parseInt(cadenaNumeros[i])){
                    return true;
                }
            }
        }       
        return false;
    }
    
    /**
     * Funcion sencilla para la validacion de la  entrada de datos. (es numero o no)
     * @param valor dato de entrada a validar
     * @return retorna true o false dependiendo de si es un numero o no.
     */
    public boolean validacionNumeros(String valor){
        try {
		Integer.parseInt(valor);
		return true;
	} catch (NumberFormatException ex){
		return false;
	}
    }
    
    /**
     * Esta funcion contiene el menu del programa
     * @return retorna un true o false dependiendo de la opcion que se ingrese.
     */
    public boolean menu(){
        System.out.println("---------------Inicio-----------------------------");
        System.out.println("---Este programa encuentra los numeros faltantes--");
        System.out.println("--Ingrese los valores del vector");
        System.out.println("------OPRIMA 1 PARA INICIAR -  0 PARA CERRAR-------");
        System.out.println("--------------------------------------------------");
        byte opcion = consola.nextByte();
        if(opcion==1){
            capturaDeDatos(opcion);
            return true;
        }
        if(opcion==0){
            System.out.println("----PROGRAMA FINALIZADO----");
            return false;
            
        }else{
            System.out.println("----PROGRAMA FINALIZADO----");
            return false;
        }   
    }
    
    /**
     * Esta funcion contiene el mensaje que pregunta al usuario si desea seguir
     * agregando numeros al arreglo
     * @return retorna un dato de tipo byte para ser validada en la funcion capturaDeDatos.
     */
    public byte mensajeContinuar(){
        //consola = new Scanner(System.in);
        System.out.println("Continuar?  (SI = 1 / NO = 0): ");
        String opcion = consola.next();        
        if(validacionNumeros(opcion)==true){
           return Byte.parseByte(opcion); 
        }else{
           System.out.println("No es una opcion valida");
           return 0;
        }
        
    }
}
