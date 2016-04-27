
package automata;
import javax.swing.JOptionPane;
public class Main {
    
  
    public static void main(String[] args) {
        Automata automata = new Automata();
        automata.setPalabra(JOptionPane.showInputDialog(null,"Ingrese Una Palabra"));
        System.out.println("La Palabra a analizar es: "+automata.getPalabra()+" con una longitud de: "+automata.getLongitud());
        JOptionPane.showMessageDialog(null,automata.analisis());
    }
    
}
