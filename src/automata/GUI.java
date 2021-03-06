/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.awt.Color;

/**
 *
 * @author kikindb
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        setTitle("Analizador Léxico y Semántico");
        this.textoConsola.setBackground(Color.black);
        this.textoConsola.setForeground(Color.green);
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoAnalizar = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoConsola = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoAnalizar.setColumns(20);
        textoAnalizar.setRows(5);
        jScrollPane1.setViewportView(textoAnalizar);

        jLabel1.setText("Ingrese El Texto A Analizar:");

        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        textoConsola.setColumns(20);
        textoConsola.setRows(5);
        jScrollPane2.setViewportView(textoConsola);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(btnAnalizar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnalizar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Realizado por Jesús Enrique Dick Bustamante, Alan I Moreno P y Jorge Herrera F.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        this.textoConsola.setText("");
        /*
        String aux;
        Automata automata = new Automata();
        automata.setPalabra(this.textoAnalizar.getText());
        
        aux = automata.analisis();
        this.textoConsola.setText("Cadena: "+automata.getPalabra()+"\nLongitud: "+automata.getLongitud()+" carácteres.\nEstado: "+aux);
        
        Analizador analizador = new Analizador();
        this.textoConsola.setText(this.textoConsola.getText()+analizador.analizarCadena(automata.getPalabra()));
            
        this.textoConsola.setText(this.textoConsola.getText()+"\n");

        this.textoConsola.setText(this.textoConsola.getText()+"\n"+automata.getcME());
        //automata.analizador();*/
        Separador s = new Separador();
        String cadena[] = s.separarPalabraPorEspacios(this.textoAnalizar.getText());
        s.imprimirArreglo();
        Analizador analizador = new Analizador();
        Automata automata = new Automata();
        automata.setPalabra(this.textoAnalizar.getText());
        String aux = automata.analisis();
        //this.textoConsola.setText(this.textoConsola.getText()+analizador.analizarCadena(automata.getPalabra()));
        this.textoConsola.setText("Cadena: "+automata.getPalabra()+"\nLongitud: "+automata.getLongitud()+" carácteres.");
        this.textoConsola.setText(this.textoConsola.getText()+"\n");
        //this.textoConsola.setText(this.textoConsola.getText()+"\n"+automata.getcME());
        
        this.textoConsola.setText(this.textoConsola.getText()+"\n\n\t------------------\n\tToken\tLexema\n\t------------------");
        for (int i = 0; i < cadena.length; i++) {
            this.textoConsola.setText(this.textoConsola.getText()+analizador.analizarCadena(cadena[i]));
        }
        this.textoConsola.setText(this.textoConsola.getText()+"\n\nAnalizador Semántico\n\nCadena Ordenada:\n"+analizador.cadenaOrdenada());
    }//GEN-LAST:event_btnAnalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textoAnalizar;
    private javax.swing.JTextArea textoConsola;
    // End of variables declaration//GEN-END:variables
}
