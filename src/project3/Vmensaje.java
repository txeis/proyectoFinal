/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Alumno
 */
public class Vmensaje extends JFrame implements ActionListener, WindowListener{
    JLabel mnsj;
    JPanel c; 
    JButton cerrar;
    
    Vmensaje(String mensaje) {
        c=(JPanel)this.getContentPane();     
        this.setTitle("ALERTA");
        this.setSize(500, 100);
        this.setLocation(600,100);
        c.setLayout(new GridLayout(1, 1, 20,20));
        this.setVisible(true);
        mnsj=new JLabel(mensaje);
        cerrar=new JButton("CERRAR");
        c.add(mnsj);
        c.add(cerrar);
        cerrar.addActionListener(this);
        this.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.setVisible(false);
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
