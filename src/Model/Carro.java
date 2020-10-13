/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ramon
 */
public class Carro extends Veiculo {
    private String combustivel;
    
    public Carro(String montadora, String modelo, String motor, String cor, String ano, String placa, String combustivel) {
        super(montadora, modelo, motor, cor, ano, placa);
        this.combustivel = combustivel;
    }
    
    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

}
