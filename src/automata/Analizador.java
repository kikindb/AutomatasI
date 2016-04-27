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
    
    public String analizarCadena(String cadena){
        String patron = "(while|true|array|begin|boolean|by|byte|case|char|const|div|do|else|elseif|end|exit|false|for|function|if|integer|loop|mod|module|not|of|procedure|readln|record|real|repeat|return|string|then|to|until|var|with|writeln)|([a-zA-Z]+)|(\\s+)|(>|<|==|>=|<=|!)|([\\.=\\+\\-/*%]|([\\(\\)\\{\\}\\[\\];,]))|(\\d*\\.?\\d+)|(//[^\\r\\n]*)|(/[*].*?[*]/)|('\\\\.'|'[^\\\\]')|(\\\".*?\\\")";
        String texto = cadena.toLowerCase();
        String concat = "";

        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(texto);
        while(m.find()){
            String token1 = m.group(1);
            if(token1!=null){
                concat+="\nPalabra Reservada: "+token1;
            }
            String token2 = m.group(2);
            if(token2!=null){
                concat+="\nVariables: "+token2;
            }
            String token3 = m.group(3);
            if(token3!=null){
                //concat+="\nEspacio: "+token3;
            }
            String token4 = m.group(4);
            if(token4!=null){
                concat+="\nComparador: "+token4;
            }
            String token5 = m.group(5);
            if(token5!=null){
                concat+="\nOperador: "+token5;
            }
            String token6 = m.group(6);
            if(token6!=null){
                concat+="\nDelimitador: "+token6;
            }
            String token7 = m.group(7);
            if(token7!=null){
                concat+="\nNumero: "+token7;
            }
            String token8 = m.group(8);
            if(token8!=null){
                concat+="\nComentario1: "+token8;
            }
            String token9 = m.group(9);
            if(token9!=null){
                concat+="\nComentario2: "+token9;
            }
            String token10 = m.group(10);
            if(token10!=null){
                concat+="\nCaracter: "+token10;
            }
            String token11 = m.group(11);
            if(token11!=null){
                concat+="\nCadena: "+token11;
            }
        }
        return concat;
    }
}
