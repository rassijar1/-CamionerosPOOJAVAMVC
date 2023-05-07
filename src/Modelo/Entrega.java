/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Pc Smart
 */
public class Entrega {
    private String placaalf;
    private int placanum;
    private String nombrepro;
    private int ccpro;
    private int capcarga;
    private String zona;
    private String cliente;
    private int cccliente;
    private String servicio;
    private double costoser;
    private String pico;

    public String getPico() {
        return pico;
    }

    public void setPico(String pico) {
        this.pico = pico;
    }

    public Entrega(String placaalf, int placanum, String nombrepro, int ccpro, int capcarga, String zona, String cliente, int cccliente, String servicio, double costoser, String pico) {
        this.placaalf = placaalf;
        this.placanum = placanum;
        this.nombrepro = nombrepro;
        this.ccpro = ccpro;
        this.capcarga = capcarga;
        this.zona = zona;
        this.cliente = cliente;
        this.cccliente = cccliente;
        this.servicio = servicio;
        this.costoser = costoser;
        this.pico = pico;
    }

   
   public Entrega() {
        this.placaalf = "";
        this.placanum =0;
        this.nombrepro = "";
        this.ccpro = 0;
        this.capcarga =0;
        this.zona = "";
        this.cliente = "";
        this.cccliente = 0;
        this.servicio = "";
        this.costoser =0;
        this.pico="";
    }

    public String getPlacaalf() {
        return placaalf;
    }

    public void setPlacaalf(String placaalf) {
        this.placaalf = placaalf;
    }

    public int getPlacanum() {
        return placanum;
    }

    public void setPlacanum(int placanum) {
        this.placanum = placanum;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public int getCcpro() {
        return ccpro;
    }

    public void setCcpro(int ccpro) {
        this.ccpro = ccpro;
    }

    public int getCapcarga() {
        return capcarga;
    }

    public void setCapcarga(int capcarga) {
        this.capcarga = capcarga;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getCccliente() {
        return cccliente;
    }

    public void setCccliente(int cccliente) {
        this.cccliente = cccliente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public double getCostoser() {
        return costoser;
    }

    public void setCostoser(double costoser) {
        this.costoser = costoser;
    }
    
    
    
    
}
