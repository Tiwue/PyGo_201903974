/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Estructuras.Arbol;
import Estructuras.Instrucciones.Instruccion;
import Estructuras.listaErrores;
import analizadores.Sintactico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


/**
 *
 * @author steve
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel3 = new java.awt.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea_Python = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        textArea_Go = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jScrollPane6 = new javax.swing.JScrollPane();
        textArea_Entrada = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        botonCargar = new javax.swing.JButton();
        botonAnalizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        Consola = new javax.swing.JTextArea();
        botonReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        textArea_Python.setBackground(new java.awt.Color(204, 204, 204));
        textArea_Python.setColumns(20);
        textArea_Python.setForeground(new java.awt.Color(51, 51, 51));
        textArea_Python.setRows(5);
        jScrollPane1.setViewportView(textArea_Python);

        textArea_Go.setBackground(new java.awt.Color(204, 204, 204));
        textArea_Go.setColumns(20);
        textArea_Go.setForeground(new java.awt.Color(51, 51, 51));
        textArea_Go.setRows(5);
        jScrollPane7.setViewportView(textArea_Go);

        jLabel2.setText("Salida Python:");

        jLabel3.setText("Salida Golang");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel1.setForeground(new java.awt.Color(255, 255, 255));

        textArea_Entrada.setBackground(new java.awt.Color(204, 204, 204));
        textArea_Entrada.setColumns(20);
        textArea_Entrada.setForeground(new java.awt.Color(51, 51, 51));
        textArea_Entrada.setRows(5);
        jScrollPane6.setViewportView(textArea_Entrada);

        jLabel1.setText("Entrada:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        botonCargar.setText("Cargar Archivo");
        botonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarActionPerformed(evt);
            }
        });

        botonAnalizar.setText("Traducir");
        botonAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalizarActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        Consola.setBackground(new java.awt.Color(0, 0, 0));
        Consola.setColumns(20);
        Consola.setForeground(new java.awt.Color(204, 255, 204));
        Consola.setRows(5);
        jScrollPane5.setViewportView(Consola);

        botonReportes.setText("Reportes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                .addComponent(botonAnalizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(botonAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarActionPerformed
        Principal referencia = this;  
        try {
              // TODO add your handling code here:
              JFileChooser fileChooser = new JFileChooser();
               fileChooser.showOpenDialog(referencia);
                String pat=fileChooser.getSelectedFile().getPath();
              File doc = new File(pat);
              
            try (BufferedReader obj = new BufferedReader(new FileReader(doc))) {
                String strng,texto="";
                while ((strng = obj.readLine()) != null)
                    texto = texto + strng+"\n";
                textArea_Entrada.setText(texto);
                String nombre= doc.getName();
                actual= new Utils.Archivo(pat,nombre);
                obj.close();
            }
              
              
          } catch (IOException ex) {
              Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_botonCargarActionPerformed

    private void botonAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnalizarActionPerformed
      interpretar(textArea_Entrada.getText());
    }//GEN-LAST:event_botonAnalizarActionPerformed
    
     private void interpretar(String texto) {
        try {
            
            errores = new listaErrores();
            
            analizadores.Sintactico sintactico = new analizadores.Sintactico(
            new analizadores.Lexico(new BufferedReader(new StringReader(texto))));
            //analizando
            sintactico.parse();
            this.arbol= sintactico.getArbol();
            instrucciones=sintactico.getAST();
            imprimir("Analisis hecho");
            if (errores.isEmpty()){
                
            }else{
                imprimir("Se encontraton Errores en la entrada\n Generando Reporte de  Errores...");
                generarReporteErrores();
            }
        } catch (Exception ex) {
            System.out.println("No se pudo realizar el analisis");
        } 
    }
     
     
    public void imprimir(String texto){
    String cadena=Consola.getText();
    cadena = cadena + "\n"+texto;
    Consola.setText(cadena);
    } 
    
    public String traducirIntrucciones(LinkedList<Instruccion> instrucciones) {
        if(instrucciones==null){
            return("No es posible ejecutar las instrucciones porque\r\n"
                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
        }
        //Se ejecuta cada instruccion en el ast, es decir, cada instruccion de 
        //la lista principal de instrucciones.
        
        String traduccion = "";
        
        for(Instruccion ins:instrucciones){
            //Si existe un error léxico o sintáctico en cierta instrucción esta
            //será inválida y se cargará como null, por lo tanto no deberá ejecutarse
            //es por esto que se hace esta validación.
            if(ins!=null)
                traduccion += ins.traducir();
        }
        
        return traduccion;
    }
    
    public void generarReporteErrores(){
            String cadena="""
                          <!DOCTYPE html>
                          <html lang="en">
                          <head>
                            <title>Reporte Errores</title>
                            <meta charset="utf-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1">
                            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                          </head>
                          <body>
                          
                          <div class="container" align="center">
                            <h2>Reporte de Errores</h2>
                            <p></p>
                            <table class="table">
                              <thead>
                                <tr>
                                  <th>#</th>
                                  <th>Tipo de Error</th>
                                  <th>Descripcion</th>
                                  <th>Linea</th>
                                  <th>Columna</th>
                                </tr>
                              </thead>
                              <tbody>""";
            for(int i=0;i<errores.size();i++){
                        cadena= cadena + "\n<tr>";
                        int numero=i+1;
                        cadena = cadena + "\n<td>"+ numero +"</td>";
                        cadena = cadena + "\n<td>"+errores.get(i).getTipo()+"</td>";
                        cadena = cadena + "\n<td>"+errores.get(i).getDescripcion()+"</td>";
                        cadena = cadena + "\n<td>"+errores.get(i).getFila()+"</td>";
                        cadena = cadena + "\n<td>"+errores.get(i).getColumna()+"</td>";
                        cadena = cadena + "\n</tr>";
                    }
            cadena = cadena + "</tbody>\n" + "  </table>\n" + "</div>\n" + "\n" + "</body>\n" + "</html>";
            FileWriter archivo = null;
            PrintWriter print = null;
                try {
                    archivo = new FileWriter("./Reportes\\\\ERRORES_201903974\\\\ERRORES.html");
                    print = new PrintWriter(archivo);
                    print.println(cadena);
                } catch (IOException e) {
                }finally{
                    if(archivo!=null){
                        try {
                            archivo.close();
                            imprimir("Reporte de errores generado");
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                    }
                }
    }
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Consola;
    private javax.swing.JButton botonAnalizar;
    private javax.swing.JButton botonCargar;
    private javax.swing.JButton botonReportes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private java.awt.Panel panel1;
    private java.awt.Panel panel3;
    private javax.swing.JTextArea textArea_Entrada;
    private javax.swing.JTextArea textArea_Go;
    private javax.swing.JTextArea textArea_Python;
    // End of variables declaration//GEN-END:variables
    public Utils.Archivo actual;
    public static listaErrores errores;
    public Arbol arbol;
    public LinkedList<Instruccion> instrucciones;
}