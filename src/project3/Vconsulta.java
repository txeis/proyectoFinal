/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Alumno
 */
public class Vconsulta extends JFrame implements ActionListener, WindowListener{

     JPanel c;
     int estado;
     BaseDatos con;
     
     JLabel Lape;
     JTextField Tape;
     JButton buscarApe;
     JButton borrar;
     
    public Vconsulta(String cadena, BaseDatos con, int estado){
        this.estado=estado;
        this.con=con;
        c=(JPanel)this.getContentPane();  
        this.setTitle(cadena);
        this.setSize(400,400);
        this.setLocation(900,400);
        this.setVisible(true);
        if(estado==0){
            c.setBackground(Color.GREEN);
        }
        if(estado==1){
            c.setBackground(Color.CYAN);
        }
        c.setLayout(new GridLayout(2,2,10,10));
        
        Lape=new JLabel("Apellidos");
        Tape=new JTextField();
        buscarApe=new JButton("BUSCAR");
        borrar=new JButton("BORRAR");
        
        
       c.add(Lape);
       c.add(Tape);
       c.add(buscarApe);
       c.add(borrar);
        
        buscarApe.addActionListener(this);
        borrar.addActionListener(this);
        this.addWindowListener(this);
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object control=e.getSource();
        
        if(control.equals(borrar)){
            Tape.setText("");
        }
        if(control.equals(buscarApe)){
            String ape=Tape.getText();
            con.buscarApellido(ape, estado);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
