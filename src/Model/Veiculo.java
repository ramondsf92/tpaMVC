/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author ramon
 */
public abstract class Veiculo implements Identificavel {
    private String montadora;
    private String modelo;
    private String motor;
    private String cor;
    private String ano;
    private String placa;

    public Veiculo(String montadora, String modelo, String motor, String cor, String ano, String placa) {
        this.montadora = montadora;
        this.modelo = modelo;
        this.motor = motor;
        this.cor = cor;
        this.ano = ano;
        this.placa = placa;
    }
    
    public String getID() {
        return this.placa;
    }

    public void regularizarDoc() {
        
    }
    
    public void liberar(ArrayList<Veiculo> veiculos) {
        for(Veiculo v : veiculos) {
            if(v.getID().equals(this.placa)) {
                veiculos.remove(v);
            }
        }
    }
    
    public void calcularConsumo() {
        
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String toString() {
        return this.montadora + this.modelo + this.ano + " - " + this.placa;
    }
}
