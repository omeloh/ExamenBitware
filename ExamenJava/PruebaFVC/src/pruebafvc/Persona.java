/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebafvc;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author oscarmelo
 */
public class Persona {
    
    private String nombre;
    private int edad;
    private String NSS="";
    private char sexo = 'H';
    private int peso; //valor ingresado en kilogramos
    private float altura; //valor ingreso en centimetros

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", NSS=" + NSS + ", sexo=" + sexo + ", peso=" + peso + ", altura=" + altura + '}';
    }

    public Persona(String nombre, int edad, String NSS, char sexo, int peso, float altura){
        this.nombre = nombre;
        this.edad = edad;
        this.NSS = NSS;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    
    public int calcularIMC(){
        int valorRetorno=2;
        float imc = this.peso/(this.altura*this.altura);
        if(this.sexo=='H'){
            if(imc<20){
                valorRetorno=-1;
            }else if(imc>19 && imc<26){
                valorRetorno=0;
            }else if(imc>25){
                valorRetorno=1;
            }
        }else{
            if(imc<19){
                valorRetorno=-1;
            }else if(imc>18 && imc<25){
                valorRetorno=0;
            }else if(imc>24){
                valorRetorno=1;
            }
        }
        return valorRetorno;
    }
    
    public boolean esMayorEdad(){
        if(this.edad>18){
            return true;
        }else{
            return false;
        }   
    }
    
    public boolean comprobarSexo(){
        if(this.sexo=='H' || this.sexo=='M'){
            return true;
        }else{
            return false;
        }
    }
    
    public String getNSS() {
    String datos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    String cadena = "";
    for (int x = 0; x < 8; x++) {
        int indiceAleatorio = numeroAleatorioEnRango(0, datos.length() - 1);
        char caracterAleatorio = datos.charAt(indiceAleatorio);
        cadena += caracterAleatorio;
    }
    return cadena;
    }
    
     public int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
    
    
}
