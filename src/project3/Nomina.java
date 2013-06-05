/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author Alumno
 */
public class Nomina {
    private float bruto=0, neto=0, irpf=0, irpfHijos=0, extra=0, brutoMirpf=0, dinCat=0;
    private int hMes=40;
    private String mesL, mesN;
    
    private BaseDatos con;
    private int estado;
    private Empleado emp;
    private int mes;
    
    public Nomina(BaseDatos con,int estado, Empleado emp, int mes){
        this.con=con;
        this.estado=estado;
        this.emp=emp;
        this.mes=mes;
    }
    public void calculoNomina(){
        System.out.println(emp.getNom());
        recogeDatos();
        calculoIRPF();
        pagasExtraordinarias();
        calculoNeto();
        muestraMes();
        System.out.println("bruto: "+bruto+" neto: "+neto+" irpf: "+irpf+
                "irpfHijos: "+irpfHijos+" extra: "+extra+" hMes: "+hMes+" dincat: "+dinCat);
    }
   
    public void recogeDatos(){
        
        String cat=emp.getCategoria();
        setDinCat(con.dineroCat(cat));
        if(estado==0){
            setBruto(dinCat); 
        }
        if(estado==1){
            tablaMes();
            sethMes(con.hMes(emp, mesL));
            setBruto(dinCat * hMes);
        }
    }
    
    public  void calculoIRPF(){
        if(getBruto()<600){
            setIrpf(bruto * 0.01);
        }
        else if(getBruto()>=600 && getBruto()<=1200){
            setIrpf(bruto * 0.15);
        }
        else{
            setIrpf(bruto * 0.25);
        }
        int numHijos=getEmp().getnHij();
        if(numHijos>0){
            setIrpf(irpf - (irpf * 0.04));
        }
        setIrpf(((int) (getIrpf() * 100)) / 100); //dejamos dos decimales
        setBrutoMirpf(bruto - irpf);
    }
    public void pagasExtraordinarias(){
        if(mes==6 || mes==12){
            setExtra(brutoMirpf);
        }
        if(mes==9){
            int numHijos=emp.getnHij();
            if(numHijos>0){
                setExtra(numHijos*100);
            }
        }       
    }
    public void calculoNeto(){
        setNeto(bruto + extra);
    }
     //ponemos nombre del mes en vez de numero
    public String muestraMes()
    {
        switch(mes)
        {
            case 1:
                setMesN("Enero");
                break;
            case 2:
                setMesN("Febrero");
                break;
            case 3:
                setMesN("Marzo");
                break;
            case 4:
                setMesN("Abril");
                break;
            case 5:
                setMesN("Mayo");
                break;
            case 6:
                setMesN("Junio");
                break;
            case 7:
                setMesN("Julio");
                break;
            case 8:
                setMesN("Agosto");
                break;
            case 9:
                setMesN("Septiembre");
                break;
            case 10:
                setMesN("Octubre");
                break;
            case 11:
                setMesN("Noviembre");
                break;
            case 12:
                setMesN("Diciembre");
                break;
        }
        return getMesN();
    }
    //para el nombre del campo de la tabla de la BBDD
    public String tablaMes()
    {
        switch(mes)
        {
            case 1:
                setMesL("hEnero");
                break;
            case 2:
                setMesL("hFebrero");
                break;
            case 3:
                setMesL("hMarzo");
                break;
            case 4:
                setMesL("hAbril");
                break;
            case 5:
                setMesL("hMayo");
                break;
            case 6:
                setMesL("hJunio");
                break;
            case 7:
                setMesL("hJulio");
                break;
            case 8:
                setMesL("hAgosto");
                break;
            case 9:
                setMesL("hSeptiembre");
                break;
            case 10:
                setMesL("hOctubre");
                break;
            case 11:
                setMesL("hNoviembre");
                break;
            case 12:
                setMesL("hDiciembre");
                break;
        }
        return getMesL();
    }

    /**
     * @return the bruto
     */
    public float getBruto() {
        return bruto;
    }

    /**
     * @param bruto the bruto to set
     */
    public void setBruto(float bruto) {
        this.bruto = bruto;
    }

    /**
     * @return the neto
     */
    public float getNeto() {
        return neto;
    }

    /**
     * @param neto the neto to set
     */
    public void setNeto(float neto) {
        this.neto = neto;
    }

    /**
     * @return the irpf
     */
    public float getIrpf() {
        return irpf;
    }

    /**
     * @param irpf the irpf to set
     */
    public void setIrpf(float irpf) {
        this.irpf = irpf;
    }

    /**
     * @return the irpfHijos
     */
    public float getIrpfHijos() {
        return irpfHijos;
    }

    /**
     * @param irpfHijos the irpfHijos to set
     */
    public void setIrpfHijos(float irpfHijos) {
        this.irpfHijos = irpfHijos;
    }

    /**
     * @return the extra
     */
    public float getExtra() {
        return extra;
    }

    /**
     * @param extra the extra to set
     */
    public void setExtra(float extra) {
        this.extra = extra;
    }

    /**
     * @return the hMes
     */
    public int gethMes() {
        return hMes;
    }

    /**
     * @param hMes the hMes to set
     */
    public void sethMes(int hMes) {
        this.hMes = hMes;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return getMesL();
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mesL) {
        this.setMesL(mesL);
    }

    /**
     * @return the brutoMirpf
     */
    public float getBrutoMirpf() {
        return brutoMirpf;
    }

    /**
     * @param brutoMirpf the brutoMirpf to set
     */
    public void setBrutoMirpf(float brutoMirpf) {
        this.brutoMirpf = brutoMirpf;
    }

    /**
     * @return the dinCat
     */
    public float getDinCat() {
        return dinCat;
    }

    /**
     * @param dinCat the dinCat to set
     */
    public void setDinCat(float dinCat) {
        this.dinCat = dinCat;
    }

    /**
     * @return the mesL
     */
    public String getMesL() {
        return mesL;
    }

    /**
     * @param mesL the mesL to set
     */
    public void setMesL(String mesL) {
        this.mesL = mesL;
    }

    /**
     * @return the mesN
     */
    public String getMesN() {
        return mesN;
    }

    /**
     * @param mesN the mesN to set
     */
    public void setMesN(String mesN) {
        this.mesN = mesN;
    }

    /**
     * @return the con
     */
    public BaseDatos getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(BaseDatos con) {
        this.con = con;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the emp
     */
    public Empleado getEmp() {
        return emp;
    }

    /**
     * @param emp the emp to set
     */
    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }
}
