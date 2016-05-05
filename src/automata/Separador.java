/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.StringTokenizer;

/**
 *
 * @author kikindb
 */
public class Separador {
    public Separador(){}
    private String aux[];
    public String[] separarPalabraPorEspacios(String cadena){
        int pos =0 ;
        StringTokenizer st = new StringTokenizer(cadena," ",false);
        aux = new String[st.countTokens()];
        while(st.hasMoreTokens()){
            try{
            aux[pos]=st.nextToken();

            }catch(Exception e){}
            pos++;
        }
        return aux;
    }
    
    public void imprimirArreglo(){
        for (int i = 0; i < aux.length; i++) {
            System.out.println("Palabra #"+i+": "+aux[i]);
        }
    }
}
