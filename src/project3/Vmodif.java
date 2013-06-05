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
public class Vmodif extends JFrame implements ActionListener, WindowListener{
     JPanel c;
    JLabel Ldni;
    JTextField Tdni;
    JLabel Lnombre;
    JTextField Tnombre;
    JLabel Lapellidos;
    JTextField Tapellidos;
    JLabel LnHijos;
    JTextField TnHijos;
    JLabel Lcategoria;
    JTextField Tcategoria;
    JLabel Lpuesto;
    JTextField Tpuesto;
    JButton buscar;
    JButton borrar;
    JButton cerrar;
    JButton guardar;
    
    String dni;
    
    JLabel Lh1;
    JTextField Th1;
    JLabel Lh2;
    JTextField Th2;
    JLabel Lh3;
    JTextField Th3;
    JLabel Lh4;
    JTextField Th4;
    JLabel Lh5;
    JTextField Th5;
    JLabel Lh6;
    JTextField Th6;
    JLabel Lh7;
    JTextField Th7;
    JLabel Lh8;
    JTextField Th8;
    JLabel Lh9;
    JTextField Th9;
    JLabel Lh10;
    JTextField Th10;
    JLabel Lh11;
    JTextField Th11;
    JLabel Lh12;
    JTextField Th12;
    Empleado empleado;

    private int estado=0; //controla si es oficina(0) o laboral(1)
    
    BaseDatos con;
    
    public Vmodif(String cadena, BaseDatos con, int estado){
        this.estado=estado;
        this.con=con;
        c=(JPanel)this.getContentPane();
        
        this.setTitle(cadena);
        this.setSize(400,600);
        this.setLocation(800,400);
        this.setVisible(true);
        if(estado==0){
            c.setBackground(Color.GREEN);
        }
        if(estado==1){
            c.setBackground(Color.CYAN);
        }
        Ldni=new JLabel("DNI: ");
        Tdni=new JTextField();
        buscar=new JButton("BUSCAR");
        borrar=new JButton("BORRAR");
        guardar=new JButton("GUARDAR CAMBIOS");
        cerrar=new JButton("CERRAR");
        
        c.add(Ldni);
        c.add(Tdni);
        c.add(buscar);
        c.add(borrar);
        if(estado==0){
            c.setLayout(new GridLayout(8,2,10,10));
            addComunes();
            addPuesto();
        }
        if(estado==1){
            c.setLayout(new GridLayout(19,2,10,10));
            addComunes();
            addHoras();
        }
        c.add(guardar);
        c.add(cerrar);
        
        buscar.addActionListener(this);
        borrar.addActionListener(this);
        cerrar.addActionListener(this);
        guardar.addActionListener(this);
        this.addWindowListener(this);
    }
    public void addComunes(){
        
        
        
        Lnombre=new JLabel("Nombre: ");
        Tnombre=new JTextField();
        Lapellidos=new JLabel("Apellidos: ");
        Tapellidos=new JTextField();
        LnHijos=new JLabel("Nº de hijos: ");
        TnHijos=new JTextField();
        Lcategoria=new JLabel("Categoría: ");
        Tcategoria=new JTextField();
        
        
        c.add(Lnombre);
        c.add(Tnombre);
        c.add(Lapellidos);
        c.add(Tapellidos);
        c.add(LnHijos);
        c.add(TnHijos);
        c.add(Lcategoria);
        c.add(Tcategoria);
    }
    public void addPuesto(){
        Lpuesto=new JLabel("Puesto: ");
        Tpuesto=new JTextField();
        c.add(Lpuesto);
        c.add(Tpuesto);
        
    }
    public void addHoras(){
        Lh1=new JLabel("h enero");
        Th1=new JTextField();
        Lh2=new JLabel("h febrero");
        Th2=new JTextField();
        Lh3=new JLabel("h marzo");
        Th3=new JTextField();
        Lh4=new JLabel("h abril");
        Th4=new JTextField();
        Lh5=new JLabel("h mayo");
        Th5=new JTextField();
        Lh6=new JLabel("h junio");
        Th6=new JTextField();
        Lh7=new JLabel("h julio");
        Th7=new JTextField();
        Lh8=new JLabel("h agosto");
        Th8=new JTextField();
        Lh9=new JLabel("h septiembre");
        Th9=new JTextField();
        Lh10=new JLabel("h octubre");
        Th10=new JTextField();
        Lh11=new JLabel("h noviembre");
        Th11=new JTextField();
        Lh12=new JLabel("h diciembre");
        Th12=new JTextField();
        
        c.add(Lh1);
        c.add(Th1);
        c.add(Lh2);
        c.add(Th2);
        c.add(Lh3);
        c.add(Th3);
        c.add(Lh4);
        c.add(Th4);
        c.add(Lh5);
        c.add(Th5);
        c.add(Lh6);
        c.add(Th6);
        c.add(Lh7);
        c.add(Th7);
        c.add(Lh8);
        c.add(Th8);
        c.add(Lh9);
        c.add(Th9);
        c.add(Lh10);
        c.add(Th10);
        c.add(Lh11);
        c.add(Th11);
        c.add(Lh12);
        c.add(Th12);
    }
    
    /**
     * @return the emp
     */
    public int getEmp() {
        return estado;
    }
    
    public  void limpiarPantalla(){
        Tdni.setText("");
        Tnombre.setText("");
        Tapellidos.setText("");
        TnHijos.setText("");
        Tcategoria.setText("");
        if(estado==0){
            Tpuesto.setText("");
        }
        if(estado==1){
            Th1.setText("");
            Th2.setText("");
            Th3.setText("");
            Th4.setText("");
            Th5.setText("");
            Th6.setText("");
            Th7.setText("");
            Th8.setText("");
            Th9.setText("");
            Th10.setText("");
            Th11.setText("");
            Th12.setText("");
        }
    }
    public void comprobarCamposNum(){
            try{
                Integer.parseInt(TnHijos.getText());
            }
            catch(NumberFormatException e){
                Vmensaje msj=new Vmensaje("el Nº de hijos ha de ser un número");
                TnHijos.setText("");
            }
        if(estado==1){
            try{
                Integer.parseInt(Th1.getText());
                Integer.parseInt(Th2.getText());
                Integer.parseInt(Th3.getText());
                Integer.parseInt(Th4.getText());
                Integer.parseInt(Th5.getText());
                Integer.parseInt(Th6.getText());
                Integer.parseInt(Th7.getText());
                Integer.parseInt(Th8.getText());
                Integer.parseInt(Th9.getText());
                Integer.parseInt(Th10.getText());
                Integer.parseInt(Th11.getText());
                Integer.parseInt(Th12.getText());
            }
            catch(NumberFormatException e){
                Vmensaje msj=new Vmensaje("ERROR: hay letras en los campos de horas");
            }
        }
    }
    public void camposCorrectos(Empleado emp){
        Vmensaje msj;
        if(emp instanceof Oficinas){
            Oficinas of=(Oficinas)emp;
            
            switch(of.ofiCorrecto(emp)){
                case 1:
                    msj=new Vmensaje("El dni es incorrecto.");
                    Tdni.setText("");
                    break;
                case 2:
                    msj=new Vmensaje("El nombre es incorrecto.");
                    Tnombre.setText("");
                    break;
                case 3:
                    msj=new Vmensaje("Los apellidos son incorrectos.");
                    Tapellidos.setText("");
                    break;
                case 4:
                    msj=new Vmensaje("El Nº de hijos es incorrecto.");
                    TnHijos.setText("");
                    break;
                case 5:
                    msj=new Vmensaje("La categoria es incorrecta.\n OPCIONES: A, B o C");
                    Tcategoria.setText("");
                    break;
                case 6:
                    msj=new Vmensaje("El puesto es incorrecto.");
                    Tpuesto.setText("");
                    break;
                default:
                    if(con.modifEmp(of)){
                        msj=new Vmensaje("La modificación se ha realizado correctamente");
                       this.dispose(); 
                    }
                    else{
                        limpiarPantalla();
                    }
            }
            
        }
        if(emp instanceof Laboral){
            Laboral lab=(Laboral)emp;
            
            switch(lab.labCorrecto(emp)){
                case 1:
                    msj=new Vmensaje("El dni es incorrecto.");
                    Tdni.setText("");
                    break;
                case 2:
                    msj=new Vmensaje("El nombre es incorrecto.");
                    Tnombre.setText("");
                    break;
                case 3:
                    msj=new Vmensaje("Los apellidos son incorrectos.");
                    Tapellidos.setText("");
                    break;
                case 4:
                    msj=new Vmensaje("El Nº de hijos es incorrecto.");
                    TnHijos.setText("");
                    break;
                case 5:
                    msj=new Vmensaje("La categoria es incorrecta.\n OPCIONES: D, E o F");
                    Tcategoria.setText("");
                    break;
                case 6:
                    msj=new Vmensaje("Horas de enero incorrectas.");
                    Th1.setText("");
                    break;
                case 7:
                    msj=new Vmensaje("Horas de febrero incorrectas.");
                    Th2.setText("");
                    break;
                case 8:
                    msj=new Vmensaje("Horas de marzo incorrectas.");
                    Th3.setText("");
                    break;
                case 9:
                    msj=new Vmensaje("Horas de abril incorrectas.");
                    Th4.setText("");
                    break;
                case 10:
                    msj=new Vmensaje("Horas de mayo incorrectas.");
                    Th5.setText("");
                    break;
                case 11:
                    msj=new Vmensaje("Horas de junio incorrectas.");
                    Th6.setText("");
                    break;
                case 12:
                    msj=new Vmensaje("Horas de julio incorrectas.");
                    Th7.setText("");
                    break;
                case 13:
                    msj=new Vmensaje("Horas de agosto incorrectas.");
                    Th8.setText("");
                    break;
                case 14:
                    msj=new Vmensaje("Horas de septiembre incorrectas.");
                    Th9.setText("");
                    break;
                case 15:
                    msj=new Vmensaje("Horas de octubre incorrectas.");
                    Th10.setText("");
                    break;
                case 16:
                    msj=new Vmensaje("Horas de noviembre incorrectas.");
                    Th11.setText("");
                    break;
                case 17:
                    msj=new Vmensaje("Horas de diciembre incorrectas.");
                    Th12.setText("");
                    break;
                default:
                    if(con.modifEmp(lab)){
                        msj=new Vmensaje("La modificación se ha realizado correctamente");
                        this.dispose(); 
                    }
                    else{
                        limpiarPantalla();
                    }
            }
            
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object control=e.getSource();
            if(control.equals(guardar)){
                if(!(dni.equals(Tdni.getText()))){
                    Vmensaje msj=new Vmensaje("El dni no puede cambiarse.");
                    dni=empleado.getDni();
                    Tdni.setText(dni);
                }
                else{
                    comprobarCamposNum();    
                    if(estado==0){
                        Oficinas oficina=new Oficinas(Tdni.getText(),Tnombre.getText().toUpperCase(),
                                Tapellidos.getText().toUpperCase(),Integer.parseInt(TnHijos.getText()),
                                Tcategoria.getText().toUpperCase(),Tpuesto.getText());
                        camposCorrectos(oficina);


                    }
                    if(estado==1){
                        comprobarCamposNum();
                        int [] horas={Integer.parseInt(Th1.getText()),Integer.parseInt(Th2.getText()),
                        Integer.parseInt(Th3.getText()),Integer.parseInt(Th4.getText()),
                        Integer.parseInt(Th5.getText()),Integer.parseInt(Th6.getText()),
                        Integer.parseInt(Th7.getText()),Integer.parseInt(Th8.getText()),
                        Integer.parseInt(Th9.getText()),Integer.parseInt(Th10.getText()),
                        Integer.parseInt(Th11.getText()),Integer.parseInt(Th12.getText())};

                        Laboral laboral=new Laboral(Tdni.getText(),Tnombre.getText().toUpperCase(),
                                Tapellidos.getText().toUpperCase(),Integer.parseInt(TnHijos.getText()),
                                Tcategoria.getText().toUpperCase(),horas);
                        camposCorrectos(laboral);
                    }
                }
        }
        if(control.equals(borrar)){
            limpiarPantalla();
        }
        if(control.equals(cerrar)){
            this.dispose();
        }
        if(control.equals(buscar)){
            dni=Tdni.getText();
            if(Empleado.dniCorrecto(dni)){
                empleado=con.buscarEmpleado(dni, estado);
                
                if(empleado!=null){
                    Tnombre.setText(empleado.getNom());
                    Tapellidos.setText(empleado.getApe());
                    TnHijos.setText(Integer.toString(empleado.getnHij()));
                    Tcategoria.setText(empleado.getCategoria());
                    if(estado==0){
                        Oficinas oficinas=(Oficinas) empleado;
                        Tpuesto.setText(oficinas.getPuesto());
                    }
                    if(estado==1){
                        Laboral laboral=(Laboral) empleado;
                        int[]horas=laboral.getHoras();
                        int h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12;
                        h1=horas[0];
                        h2=horas[1];
                        h3=horas[2];
                        h4=horas[3];
                        h5=horas[4];
                        h6=horas[5];
                        h7=horas[6];
                        h8=horas[7];
                        h9=horas[8];
                        h10=horas[9];
                        h11=horas[10];
                        h12=horas[11];
                        Th1.setText(Integer.toString(h1));
                        Th2.setText(Integer.toString(h2));
                        Th3.setText(Integer.toString(h3));
                        Th4.setText(Integer.toString(h4));
                        Th5.setText(Integer.toString(h5));
                        Th6.setText(Integer.toString(h6));
                        Th7.setText(Integer.toString(h7));
                        Th8.setText(Integer.toString(h8));
                        Th9.setText(Integer.toString(h9));
                        Th10.setText(Integer.toString(h10));
                        Th11.setText(Integer.toString(h11));
                        Th12.setText(Integer.toString(h12));
                    }
                }
                else{
                    Tdni.setText("");
                }
            }
            else{
                Vmensaje msj=new Vmensaje("el dni no es correcto.");
                Tdni.setText("");
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
