package automata;

/**
 *
 * @author kikindb
 */
public class Automata {
    
    private String palabra;
    private String mensaje="Todo Correcto";
    private int longitud=0;
    private int matrizEstados[][];
    
    public Automata(){}
    
    public Automata(String palabra){
        this.palabra=palabra;
        this.longitud=this.palabra.length();
    }
    
    public String analisis(){
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
        //marca error y termina el programa si no encuentra caracteres validos
        if(i>52){
            this.mensaje="Error, debes de inciar con una letra";
            //System.exit(0);
        }

        //Busca palabras reservadas dentro del texto ingresado
        for(i=0;i<Cadenas.reservadas.length;i++){
            if(palabra.equalsIgnoreCase(Cadenas.reservadas[i])){
                this.mensaje="Palabra reservada "+Cadenas.reservadas[i];
            }
        }

        //Inicia la comparacion del ultimo caracter con los - o _
        if(palabra.endsWith("-") || palabra.endsWith("_")){
            this.mensaje="Error, la palabra no puede terminar con - o _";
            //System.exit(0);
        }
        
        //realiza la comparacion con los signos
        for(i=0;i<cadena;i++){
            if(palabra.charAt(i)=='-'&& palabra.charAt(i)=='-' || palabra.charAt(i)=='_' && palabra.charAt(i)=='_'){
                this.mensaje="Error, no se permiten mas de 2 guiones seguidos";
                //System.exit(0);
            }
            System.out.println(palabra.charAt(i));
        }
        
        return this.mensaje;
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
    
}
