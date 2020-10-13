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
    private String comissao;
    private ArrayList<Venda> vendas;
    
    public void realizarVenda(Venda v) {
        vendas.add(v);
    }
    
    public void calcularComissao() {
        
    }

    public Vendedor(String nome, String cpf, String salario, String comissao) {
        super(nome, cpf, salario);
        this.comissao = comissao;
        this.vendas = new ArrayList<Venda>();
    }

    public String getComissao() {
        return comissao;
    }

    public void setComissao(String comissao) {
        this.comissao = comissao;
    }
    
}
