/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversaomoedas;

import java.util.Date;

/**
 *
 * @author mkt
 */
public class Moeda {
    
    private int id;
    private Date data;
    private double u_moeda;
    private double r_moeda;
    private String moeda;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getU_moeda() {
        return u_moeda;
    }

    public void setU_moeda(double u_moeda) {
        this.u_moeda = u_moeda;
    }

    public double getR_moeda() {
        return r_moeda;
    }

    public void setR_moeda(double r_moeda) {
        this.r_moeda = r_moeda;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }
    
//    Para instancias
    public Moeda() {
    }
    
    

    //Constructor para insercao
    public Moeda(Date data, double u_moeda, double r_moeda, String moeda) {
        this.data = data;
        this.u_moeda = u_moeda;
        this.r_moeda = r_moeda;
        this.moeda = moeda;
    }
    
    
    
}
