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
public class Vendedor extends Funcionario {
    private float comissao;
    private ArrayList<Venda> vendas;
    
    public void realizarVenda(Venda v, Cliente c) {
        
    }
    
    public void calcularComissao() {
        
    }

    public Vendedor(String nome, String cpf, double salario, float comissao) {
        super(nome, cpf, salario);
        this.comissao = comissao;
        this.vendas = new ArrayList();
    }
    
    
}
