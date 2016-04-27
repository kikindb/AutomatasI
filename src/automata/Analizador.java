/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kikindb
 */
public class Analizador {
    public Analizador(){}
    
    public void analizarCadena(String cadena){
        String patron = "(while)|([a-zA-Z]+)|(\\s+)|(>|<|==|>=|<=|!)|([\\.=\\+\\-/*%]|([\\(\\)\\{\\}\\[\\];,]))|(\\d*\\.?\\d+)|(//[^\\r\\n]*)|(/[*].*?[*]/)|('\\\\.'|'[^\\\\]')|(\\\".*?\\\")";
        String texto = cadena;
        
        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(texto);
        while(m.find()){
            String token1 = m.group(1);
            if(token1!=null){
                System.out.println("Palabra Reservada: "+token1);
            }
            String token2 = m.group(2);
            if(token2!=null){
                System.out.println("Variables: "+token2);
            }
            String token3 = m.group(3);
            if(token3!=null){
                System.out.println("Espacio: "+token3);
            }
            String token4 = m.group(4);
            if(token4!=null){
                System.out.println("Comparador: "+token4);
            }
            String token5 = m.group(5);
            if(token5!=null){
                System.out.println("Operador: "+token5);
            }
            String token6 = m.group(6);
            if(token6!=null){
                System.out.println("Delimitador: "+token6);
            }
            String token7 = m.group(7);
            if(token7!=null){
                System.out.println("Numero: "+token7);
            }
            String token8 = m.group(8);
            if(token8!=null){
                System.out.println("Comentario1: "+token8);
            }
            String token9 = m.group(9);
            if(token9!=null){
                System.out.println("Comentario2: "+token9);
            }
            String token10 = m.group(10);
            if(token10!=null){
                System.out.println("Caracter: "+token10);
            }
            String token11 = m.group(11);
            if(token11!=null){
                System.out.println("Cadena: "+token11);
            }
        }
    }
}
