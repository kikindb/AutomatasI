
package automata;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class Main {
    
  
    public static void main(String[] args) {
        String aux;
        Automata automata = new Automata();
        automata.setPalabra(JOptionPane.showInputDialog(null,"Ingrese Una Palabra"));
        System.out.println("La Palabra a analizar es: "+automata.getPalabra()+" con una longitud de: "+automata.getLongitud());
        aux = automata.analisis();
        JOptionPane.showMessageDialog(null,aux);
        
        Analizador analizador = new Analizador();
        if(aux.contentEquals("Todo Correcto"))
            analizador.analizarCadena(automata.getPalabra());
        
    }
    
}
