/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author idoia
 */
public class VbuscarNomina extends JFrame implements ActionListener, WindowListener{
    JPanel c;
     int estado;
     BaseDatos con;
     
     JLabel Ldni;
     JTextField Tdni;
     JLabel Lmes;
     JTextField Tmes;
     JButton calcular;
     JButton borrar;
     String cadena;
     Empleado empleado=null;
     
     public VbuscarNomina(String cadena, BaseDatos con,int estado){
        this.cadena=cadena;
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
        c.setLayout(new GridLayout(3,2,10,10));
        
        Ldni=new JLabel("DNI");
        Tdni=new JTextField();
        Lmes=new JLabel("MES (1-12)");
        Tmes=new JTextField();
        calcular=new JButton("CALCULAR NÓMINA");
        borrar=new JButton("BORRAR");
        
        c.add(Ldni);
        c.add(Tdni);
        c.add(Lmes);
        c.add(Tmes);
        c.add(calcular);
        c.add(borrar);
        
        calcular.addActionListener(this);
        borrar.addActionListener(this);
        this.addWindowListener(this);
     }
     /**
      * Comprueba que el mes introducido es correcto
      * es correcto si es un num entre 1 y 12
      * @return 
      */
     public boolean comprobarMes(){
         try{
            int mes=Integer.parseInt(Tmes.getText());
            if(mes<=0||mes>12){
                Vmensaje msj=new Vmensaje("el mes ha de ser un número entre 1 y 12");
                Tmes.setText("");
                return false;
            }
            else{
                return true;
            }
         }
         catch(NumberFormatException e){
             Vmensaje msj=new Vmensaje("el mes ha de ser un número entre 1 y 12");
             Tmes.setText("");
             return false;
         }
     }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object control=e.getSource();
        if(control.equals(borrar)){
            Tdni.setText("");
            Tmes.setText("");
        }
        if(control.equals(calcular)){
            String dni=Tdni.getText();
            if(Empleado.dniCorrecto(dni)){
                empleado=con.buscarEmpleado(dni, estado);
                if(empleado!=null){
                    if(con.existe(empleado)){
                        comprobarMes();
                        Vnomina nomina=new Vnomina(cadena,con,estado, empleado,Integer.parseInt(Tmes.getText()));
                        this.dispose();
                    }
                }
                else{
                    Tdni.setText("");
                }
                
            }
            else{
                Vmensaje msj=new Vmensaje("el dni no es correcto");
                Tdni.setText("");
            }
            
            
            
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        this.dispose();
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
