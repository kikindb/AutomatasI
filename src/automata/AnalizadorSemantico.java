/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kikindb
 */
public class AnalizadorSemantico {
    
    private byte[] codigoASCII;
    private char[] arrayCadena;
    private char[] arrayCadenaOrdenada;
    private char[] matrizValores;
    private String[] arrayMin, arrayMay, arrayNum, arrayKW, arrayOL, arrayCom;
    private byte[] jerarquia;
    private byte[] posMay;
    private byte[] posMin;
    private byte[] posNum;
    private byte numMin=0, numMay=0, numNum=0;
   
    public AnalizadorSemantico(){}
    
    public String analizar(String cadena){
        this.codigoASCII = new byte[cadena.length()];
        this.jerarquia = new byte[cadena.length()];
        this.matrizValores = new char[cadena.length()];
        this.arrayCadena = cadena.toCharArray();
        
        for(int i=0;i<cadena.length();i++){
            this.codigoASCII[i] = (byte)this.arrayCadena[i];
            
            if(this.codigoASCII[i]>=48 && this.codigoASCII[i]<=57){
                this.matrizValores[i] = 'n'; //Números
                this.jerarquia[i] = 3;
                this.numNum+=1;
            }else if((this.codigoASCII[i]>=65 && this.codigoASCII[i]<=90)||this.codigoASCII[i]==-47){
                this.matrizValores[i] = 'M'; //Mayúsculas
                this.jerarquia[i] = 2;
                this.numMay+=1;
            }if((this.codigoASCII[i]>=97 && this.codigoASCII[i]<=122)||this.codigoASCII[i]==-15){
                this.matrizValores[i] = 'm'; //Minúsculas
                this.jerarquia[i] = 1;
                this.numMin+=1;
            }
            
            System.out.println(i+".- "+this.arrayCadena[i]+" ASCII: "+this.codigoASCII[i]+" Tipo: "+this.matrizValores[i]);
        }
        this.arrayMay = new String[this.numMay];
        this.arrayMin = new String[this.numMin];
        this.arrayNum = new String[this.numNum];
        
        int j=0,k=0,l=0;
        for(int i=0;i<cadena.length();i++){
            this.codigoASCII[i] = (byte)this.arrayCadena[i];
            
            if(this.codigoASCII[i]>=48 && this.codigoASCII[i]<=57){
                this.arrayNum[j] = String.valueOf(this.arrayCadena[i]);
                j++;
            }else if((this.codigoASCII[i]>=65 && this.codigoASCII[i]<=90)||this.codigoASCII[i]==-47){
                this.arrayMay[k] = String.valueOf(this.arrayCadena[i]);
                k++;
            }if((this.codigoASCII[i]>=97 && this.codigoASCII[i]<=122)||this.codigoASCII[i]==-15){
                this.arrayMin[l] = String.valueOf(this.arrayCadena[i]);
                l++;
            }
        }
        
        
        System.out.println("# Minúsculas: "+this.numMin+"\t# Mayúsculas: "+this.numMay+"\t# Números: "+this.numNum);

        //System.out.println("\nArreglos ordenados");
        Arrays.sort(arrayMin);
        Arrays.sort(arrayMay);
        Arrays.sort(arrayNum,Collections.reverseOrder());
        /*
        for (String i : arrayMin) {
            System.out.println(i);
        }
        for (String i : arrayMay) {
            System.out.println(i);
        }
        for (String i : arrayNum) {
            System.out.println(i);
        }*/
        
        System.out.println("\nCadena Ordenada:");
        String aux = String.join("", arrayMin)+String.join("", arrayMay)+String.join("", arrayNum);
        System.out.println(aux);
        return aux;
    }
    
    
    
    
}
     
