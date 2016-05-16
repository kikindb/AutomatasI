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
    
    public void buscarErrores(String cadena){
        String expRegIdentificador ="([^0-9]+[\\w-]+[^-_])";//[^0-9]+[a-zA-Z]+[^-_]
        String expRegComentario1 = "[/][*].*?[*][/]";
        Pattern p = Pattern.compile(expRegIdentificador);
        Matcher m = p.matcher(cadena);
        
        Pattern p2 = Pattern.compile(expRegComentario1);
        Matcher m2 = p.matcher(cadena);
        
        if(m.matches()){
            System.out.println("Es un Identificador Bien Formado");
        }else{
            if(m2.matches()){
                System.out.println("Es un comentario bien formado");
            }else{
                System.out.println("Identificador Mal Formado");
            }
        }
    }
    
    public String analizarCadena(String cadena){
        buscarErrores(cadena);
        
        String patron = 
                "(\\bwhile\\b|\\btrue\\b|\\barray\\b|\\bbegin\\b|\\bboolean\\b|\\bby\\b|\\bbyte\\b|\\bcase\\b|\\bchar\\b|\\bconst\\b|\\bdiv\\b|\\bdo\\b|\\belse\\b|\\belseif\\b|\\bend\\b|\\bexit\\b|\\bfalse\\b|\\bfor\\b|\\bfunction\\b|\\bif\\b|\\binteger\\b|\\bloop\\b|\\bmod\\b|\\bmodule\\b|\\bof\\b|\\bprocedure\\b|\\breadln\\b|\\brecord\\b|\\breal\\b|\\brepeat\\b|\\breturn\\b|\\bstring\\b|\\bthen\\b|\\bto\\b|\\buntil\\b|\\bvar\\b|\\bwith\\b|\\bwriteln\\b)"
                + "|(\\s+)" //Espacios 2
                + "|(>|<|==|>=|<=|!)" //Comparador 3
                + "|([\\.=\\+\\-*%]" //Operador //[\\.=\\+\\-/*%] 4
                + "|([\\(\\)\\\\\\[\\];,]))" //Delimitador 5
                + "|(\\b\\d*\\.?\\d+\\b)" //Numeros 6
                + "|([{].*?[}])" //Comentario Tipo1 7
                + "|([/][*].*?[*][/])" //Comentario Tipo2 8/[*].*?[*]/
                + "|(or|and|not)" //logicos 9
                + "|([\"].*?[\"])" //Letreros 10
                + "|([^0-9]+[a-zA-Z]+[^-_])"; //Identificador 11

        String texto = cadena.toLowerCase();
        String concat = "";//"\n\n\t------------------\n\tToken\tLexema\n\t------------------";

        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(texto);
        String token=null;
        while(m.find()){
            String token1 = m.group(1);
            if(token1!=null){
                concat+="\n\tP.Reservada\t"+token1;
            }
            String token2 = m.group(2);
            if(token2!=null){
                //concat+="\nEspacio: "+token3;
            }
            String token3 = m.group(3);
            if(token3!=null){
                concat+="\n\tComparador\t"+token3;
            }
            String token4 = m.group(4);
            if(token4!=null){
                concat+="\n\tOperador\t"+token4;
            }
            String token5 = m.group(5);
            if(token5!=null){
                concat+="\n\tDelimitador\t"+token5;
            }
            String token6 = m.group(6);
            if(token6!=null){
                concat+="\n\tNumero\t"+token6;
            }
            String token7 = m.group(7);
            if(token7!=null){
                concat+="\n\tComentario1\t"+token7;
            }
            String token8 = m.group(8);
            if(token8!=null){
                concat+="\n\tComentario2\t"+token8;
            }
            String token9 = m.group(9);
            if(token9!=null){
                concat+="\n\tLógicos\t"+token9;
            }
            String token10 = m.group(10);
            if(token10!=null){
                concat+="\n\tLetreros\t"+token10;
            }
            String token11 = m.group(11);
            if(token11!=null){
                concat+="\n\tIdentificador\t"+token11;
            }
        }
        return concat;
    }
}
