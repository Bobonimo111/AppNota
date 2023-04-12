package com.william.notasdinheiro;

import java.io.Serializable;

public class NotaCheckagem implements Serializable {
    private String codigo;
    private String outros;
    private String data;
    private double dinheiro;
    private double premio;
    private double moeda;
    private double pix;
    private double despesa;



    public  NotaCheckagem(String codigo,String data){
        this.setCodigo(codigo);
        this.data = data;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public double getMoeda() {
        return moeda;
    }

    public void setMoeda(double moeda) {
        this.moeda = moeda;
    }

    public double getPix() {
        return pix;
    }

    public void setPix(double pix) {
        this.pix = pix;
    }

    public double getDespesa() {
        return despesa;
    }

    public void setDespesa(double despesa) {
        this.despesa = despesa;
    }
}
