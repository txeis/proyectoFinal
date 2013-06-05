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
public class VMenu extends JFrame implements ActionListener, WindowListener{
    
    JPanel c;
        
        JButton alta;
        JButton baja;
        JButton modificacion;
        JButton consulta;
        JButton nomina;
        
        BaseDatos con;
        int estado=0;//0 para oficinas, 1 para laborales
        
    VMenu(String cadena, BaseDatos con, int estado){
        this.con=con; 
        this.estado=estado;
        
        c=(JPanel)this.getContentPane();  
        this.setTitle(cadena);
        this.setSize(300,400);
        this.setLocation(600,200);
        this.setVisible(true);
        if(estado==0){
            c.setBackground(Color.GREEN);
        }
        if(estado==1){
            c.setBackground(Color.CYAN);
        }
        c.setLayout(new GridLayout(5,1,10,10));
        
        alta=new JButton("ALTA");
        baja=new JButton("BAJA");
        modificacion=new JButton("MODIFICACIÓN");
        consulta=new JButton("CONSULTA");
        nomina=new JButton("NÓMINA");
        
        c.add(alta);
        c.add(baja);
        c.add(modificacion);
        c.add(consulta);
        c.add(nomina);
       
        alta.addActionListener(this);
        baja.addActionListener(this);
        modificacion.addActionListener(this);
        consulta.addActionListener(this);
        nomina.addActionListener(this);
        
        this.addWindowListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object control=e.getSource();
        
        if(control.equals(alta)){
            if(estado==0){
                VAlta vAlta=new VAlta("ALTA OFICINAS", con, estado);
            }
            if(estado==1){
                VAlta vAlta=new VAlta("ALTA LABORAL", con, estado);
            }
        }
        if(control.equals(baja)){
            if(estado==0){
                VBaja vBaja=new VBaja("BAJA OFICINAS", con, estado);
            }
            if(estado==1){
                VBaja vBaja=new VBaja("BAJA LABORAL", con, estado);
            }
        }
        if(control.equals(modificacion)){
            if(estado==0){
                Vmodif vModif=new Vmodif("MODIFICACIÓN OFICINAS", con, estado);
            }
            if(estado==1){
                Vmodif vModif=new Vmodif("MODIFICACIÓN LABORAL", con, estado);
            }
        }
        if(control.equals(consulta)){
            if(estado==0){
                Vconsulta vConsulta=new Vconsulta("CONSULTA OFICINAS", con, estado);
            }
            if(estado==1){
                Vconsulta vConsulta=new Vconsulta("CONSULTA LABORAL", con, estado);
            }
        }
        if(control.equals(nomina)){
            if(estado==0){
                VbuscarNomina vBuscarNomina=new VbuscarNomina("NOMINA OFICINAS", con, estado);
            }
            if(estado==1){
                VbuscarNomina vBuscarNomina=new VbuscarNomina("NOMINA LABORAL", con, estado);
            }
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
