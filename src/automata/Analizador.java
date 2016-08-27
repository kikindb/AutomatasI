/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kikindb
 */
public class Analizador {
    ArrayList<String> palabrasClaveL = new ArrayList<String>();
    ArrayList<String> comparadores = new ArrayList<String>();
    ArrayList<String> operadores = new ArrayList<String>();
    ArrayList<String> delimitadores = new ArrayList<String>();
    ArrayList<Double> numeros = new ArrayList<Double>();
    ArrayList<String> comentarios1 = new ArrayList<String>();
    ArrayList<String> comentarios2 = new ArrayList<String>();
    ArrayList<String> logicos = new ArrayList<String>();
    ArrayList<String> letreros = new ArrayList<String>();
    ArrayList<String> identificadores = new ArrayList<String>();
    
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
                + "|([>|<|==|>=|<=|!|:=])" //Comparador 3
                + "|((?!\\/\\*)[+*\\-/])" //Operador //[\\.=\\+\\-/*%] 4([\\.=\\+\\-*%]
                + "|([\\\\\\(\\)\\[\\]\\;])" //Delimitador 5([\\(\\)\\\\\\[\\];,]))
                + "|(\\d*\\.?\\d)" //Numeros 6
                + "|([{].*?[}])" //Comentario Tipo1 7
                + "|([/][*].*?[*][/])" //Comentario Tipo2 8/[*].*?[*]/
                + "|(\\bor|\\band|\\bnot)" //logicos 9
                + "|([\"].*?[\"])" //Letreros 10
                + "|([^0-9]+[a-zA-Z][0-9]*[^-_*+)])"; //Identificador 11([^0-9]+[a-zA-Z]+[^-_)])

        String texto = cadena.toLowerCase();
        String concat = "";//"\n\n\t------------------\n\tToken\tLexema\n\t------------------";

        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(texto);
        String token=null;
        while(m.find()){
            String token1 = m.group(1);
            if(token1!=null){
                concat+="\n\tP.Reservada\t"+token1;
                this.palabrasClaveL.add(token1);
            }
            String token2 = m.group(2);
            if(token2!=null){
                //concat+="\nEspacio: "+token3;
            }
            String token3 = m.group(3);
            if(token3!=null){
                concat+="\n\tComparador\t"+token3;
                this.comparadores.add(token3);
            }
            String token4 = m.group(4);
            if(token4!=null){
                concat+="\n\tOperador\t"+token4;
                this.operadores.add(token4);
            }
            String token5 = m.group(5);
            if(token5!=null){
                concat+="\n\tDelimitador\t"+token5;
                this.delimitadores.add(token5);
            }
            String token6 = m.group(6);
            if(token6!=null){
                concat+="\n\tNumero\t"+token6;
                this.numeros.add(Double.parseDouble(token6));
            }
            String token7 = m.group(7);
            if(token7!=null){
                concat+="\n\tComentario1\t"+token7;
                this.comentarios1.add(token7);
            }
            String token8 = m.group(8);
            if(token8!=null){
                concat+="\n\tComentario2\t"+token8;
                this.comentarios2.add(token8);
            }
            String token9 = m.group(9);
            if(token9!=null){
                concat+="\n\tLógicos\t"+token9;
                this.logicos.add(token9);
            }
            String token10 = m.group(10);
            if(token10!=null){
                concat+="\n\tLetreros\t"+token10;
                this.letreros.add(token10);
            }
            String token11 = m.group(11);
            if(token11!=null){
                concat+="\n\tIdentificador\t"+token11;
                this.identificadores.add(token11);
            }
        }
        return concat;
    }
    public String cadenaOrdenada(){
        String aux;
        NumberFormat nf = new DecimalFormat("##.###");
        ArrayList<String> auxNumber = new ArrayList<String>();
        for (double numero : this.numeros) {
            auxNumber.add(nf.format(numero));
        }
        this.identificadores.sort(null);
        this.palabrasClaveL.sort(null);
        this.logicos.sort(null);
        Collections.sort(this.numeros,Collections.reverseOrder());
        aux = this.identificadores.toString()+this.logicos.toString()+auxNumber.toString()+this.palabrasClaveL.toString()+this.operadores.toString()+this.letreros.toString()+this.comentarios2.toString();
        return aux;
    }
}
