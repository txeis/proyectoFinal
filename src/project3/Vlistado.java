/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author idoia
 */
public class Vlistado extends JFrame implements ActionListener, WindowListener{
    
    JPanel c;
    JTable table;
    DefaultTableModel modelo;
    
    Vlistado(){
        
        c=(JPanel)this.getContentPane();
        modelo=new DefaultTableModel();
        
        
        table= new JTable(modelo);
        table.setPreferredScrollableViewportSize (new Dimension (500,70));
        JScrollPane scrollPane=new JScrollPane (table);
        
        
        c.add (scrollPane,BorderLayout.CENTER);
        this.setTitle ("EMPLEADOS");
        this.setSize (600,400);
        this.setVisible(true);
        
        modelo.addColumn ("DNI");
        modelo.addColumn ("NOMBRE");
        modelo.addColumn ("APELLIDOS");
        modelo.addColumn ("TIPO");
    }
    public void muestraEmp(Empleado emp){
        
        modelo.addRow(emp.muestraEmp(emp));
    
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
    
}
