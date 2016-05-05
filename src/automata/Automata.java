package automata;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kikindb
 */
public class Automata {
    
    private String palabra;
    private String mensaje="Todo Correcto";
    private int longitud=0;
    private int matrizEstados[][];
    private String cME ="";
    int llavea=0;
    int llavec=0;
    int resta;
    
    public Automata(){}
    
    public Automata(String palabra){
        this.palabra=palabra;
        this.longitud=this.palabra.length();
    }
    public Boolean analizador(){
        boolean matriz[];
        boolean isOk = true;
        String aux[];
        int pos =0 ;
        Pattern pat = Pattern.compile(".*[^\\_]$"); //.*[^-_]$
        Pattern pat2 = Pattern.compile("^[^a-zA-Z].*");
        Pattern pat3 = Pattern.compile(".*[^\\-]$");
        Pattern pat4 = Pattern.compile("\\d*\\.?\\d+");

        Matcher mat,mat2,mat3,mat4;
        StringTokenizer st = new StringTokenizer(this.palabra," (){}<>=+*/.;",true);
        aux= new String[st.countTokens()];
        matriz = new boolean[st.countTokens()];
        while(st.hasMoreTokens()){
            try{
            aux[pos]=st.nextToken();

            }catch(Exception e){}
            pos++;
        }
        
        for (int i=0;i<aux.length;i++) {
            isOk=true;
            if(!aux[i].contentEquals(" ")){
                System.out.print(i+": "+aux[i]);
                this.cME +=i+": "+aux[i];
                mat = pat.matcher(aux[i]);
                mat2 = pat2.matcher(aux[i]);
                mat3 = pat3.matcher(aux[i]);
                mat4 = pat4.matcher(aux[i]);
                if(mat2.matches()){
                    System.out.print(" No Inicia con una letra");
                    this.cME +=" No inicia con una letra";
                    if(mat4.matches()&&i!=0){
                        System.out.print(" Pero es Correcto debido a que es un numero");
                        this.cME +=" Pero es Correcto debido a que es un numero";
                        isOk = true;
                    }else{
                        if(aux[i].length()==1&&i!=0){
                            System.out.print(" Pero es Correcto debido a que es un operador");
                            this.cME +=" Pero es Correcto debido a que es un operador";
                            isOk = true;
                        }else{
                            isOk = false;
                        } 
                    }

                }else{
                    System.out.print(" Si Inicia con una letra");
                    this.cME +=" Si Inicia con una letra";
                    if (mat.matches()) {
                        System.out.print(" No termina en Guion Bajo");
                        this.cME +=" No termina en Guion Bajo";
                        if(mat3.matches()){
                            System.out.print(" No Termina en Guion");
                            this.cME +=" No Termina en Guion";
                            isOk = true;
                        }else{
                            System.out.print(" Si Termina en Guion");
                            this.cME +=" Si Termina en Guion";
                            isOk = false;
                        }
                    } else {
                        System.out.print(" Si Termina en Guion Bajo");
                        this.cME +=" Si Termina en Guion Bajo";
                        isOk = false;
                    }
                }
                if(isOk){
                    System.out.print(" Por Lo Tanto Es Válida.");
                    this.cME +=" Por Lo Tanto Es Válida.";
                    matriz[i]=true;
                }else{
                    System.out.println(" Por Lo Tanto Es Inválida.");
                    this.cME +=" Por Lo Tanto Es Inválida.";
                    matriz[i]=false;
                }
                System.out.println("");
                this.cME +="\n";
                
            }else{
                matriz[i]=true;
            }
        }
            boolean ret=true;
            System.out.println("Matriz Booleana:");
            for (int i = 0; i < matriz.length; i++) {
                System.out.println(matriz[i]);
                if(matriz[i]!=true){
                    ret = false;
                }
           
            }
             return ret;
    }
    
    public String analisis(){
        if(analizador()){
           
        String palabra = this.palabra;
        int cadena = palabra.length();
        int i=0,j=0;
        int estado=0;

        //matriz de estado
        this.matrizEstados = new int[9][9];
        
        //inicio comparacion con caracteres validos
        for(i=0;i<Cadenas.errorInicio.length;i++){
            if(palabra.charAt(0)==Cadenas.errorInicio[i]){
                //el ciclo se rompe si encuentra un caracter valido
                break;
            }
        }

        //Busca palabras reservadas dentro del texto ingresado
        for(i=0;i<Cadenas.reservadas.length;i++){
            if(palabra.equalsIgnoreCase(Cadenas.reservadas[i])){
                //this.mensaje="Palabra reservada "+Cadenas.reservadas[i];
            }
        }

        //Inicia la comparacion del ultimo caracter con los - o _
        if(palabra.endsWith("-") || palabra.endsWith("_")){
            this.mensaje="Error, la palabra no puede terminar con - o _";
            //System.exit(0);
        }
        
        //realiza la comparacion con los signos
        for(i=0;i<cadena;i++){
            try{
            if(palabra.charAt(i)=='-'&& palabra.charAt(i+1)=='-' || palabra.charAt(i)=='_' && palabra.charAt(i+1)=='_'){
                this.mensaje="Error, no se permiten mas de 2 guiones seguidos o terminar en - ó _";
                //System.exit(0);
            }
                System.out.println(palabra.charAt(i));
            }catch(StringIndexOutOfBoundsException ex){
                this.mensaje="Error, no se permiten mas de 2 guiones seguidos o terminar en - ó _";
            }catch(Exception ex){
                this.mensaje="Error, no se permiten mas de 2 guiones seguidos o terminar en - ó _";
            }
        }
        //Busca comentarios del tipo /* */
        if(palabra.contains("/*") | palabra.contains("*/")){
            //revisa la cadena para ver cuantas /* y cuantas */ existen     
            for(i=0;i<(cadena-1);i++){
                if(palabra.charAt(i)=='/'){
                    if(palabra.charAt((i+1))=='*'){
                        llavea++;
                    }
                }
                if(palabra.charAt(i)=='*'){
                    if(palabra.charAt((i+1))=='/'){
                        llavec++;
                    }
                }
            }
            //obtiene el numero de comentarios completos/incompletos
            resta=llavea-llavec;
            //indica cuantos cuantas llaves del tipo /* o */ faltaron para cerrar el comentario
            if(llavea>llavec){this.mensaje="pusiste "+ resta + " /* demas o no las cerraste";}
            if(llavec>llavea){this.mensaje="pusiste "+(-resta)+" */ demas o no las cerraste";}
        }

        //verifica que el programa posea almenos una de las llaves para compararlo
         if(palabra.contains("{")| palabra.contains("}")){
            //compara caracter por caracter si tiene los { o } para conocer la cantidad de estos         
             for(i=0;i<cadena;i++){
                if(palabra.charAt(i)=='{'){llavea++;}
                if(palabra.charAt(i)=='}'){llavec++;}
             }
            //indica la diferiencia de cantidad entre { y }
             resta=llavea-llavec;
            //indica cuantas { o cuantas } hicieron falta para cerrar el comentario
             if(llavea>llavec){this.mensaje="pusiste "+ resta + " { demas o no las cerraste";}
             if(llavec>llavea){this.mensaje="pusiste "+(-resta)+"  } demas o no las cerraste";}
         }
        return this.mensaje;
        }else{
            return "Error";
        }
       
    }
    
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        if(palabra.length()>0){
            this.palabra = palabra;
        }else{
            System.out.println("Ingrese Al Menos un Caracter");
            System.exit(0);
        }
    }
    
    public int getLongitud(){
        return (this.longitud = this.getPalabra().length());
    }

    public String getcME() {
        return cME;
    }
    
    
    
}
