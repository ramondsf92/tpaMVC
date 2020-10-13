/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Carro;
import Model.Cliente;
import Model.Veiculo;
import Model.Vendedor;

import java.util.ArrayList;

/**
 *
 * @author ramon
 */
public class MainController {
    
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    

    public ArrayList<String> cadastrarCliente(String nome, String cpf) {
        ArrayList<String> retorno = new ArrayList<String>();
        
        for(Cliente c : this.clientes) {
            if(c.getCpf().equals(cpf)) {
                retorno.add("0");
                return retorno;
            }
        }
        
        Cliente c = new Cliente(nome, cpf);
        
        this.clientes.add(c);
        retorno.add("1");
        retorno.add(c.getNome());
        retorno.add(c.getCpf());
        
        return retorno;
    }

    public ArrayList<String> cadastrarVendedor(String nome, String cpf, String salario, String comissao) {
        ArrayList<String> retorno = new ArrayList<String>();
        
        for(Vendedor c : this.vendedores) {
            if(c.getCpf().equals(cpf)) {
                retorno.add("0");
                return retorno;
            }
        }
        
        Cliente c = new Cliente(nome, cpf);
        
        this.clientes.add(c);
        retorno.add("1");
        retorno.add(c.getNome());
        retorno.add(c.getCpf());
        
        return retorno;
    }

    public ArrayList<String> cadastrarVeiculo(String montadora, String modelo, String motor, String cor, String ano, String placa, String combustivel) {
        ArrayList<String> retorno = new ArrayList<String>();
        
        for(Veiculo c : this.veiculos) {
            if(c.getPlaca().equals(placa)) {
                retorno.add("0");
                return retorno;
            }
        }
        
        Carro c = new Carro(montadora, modelo, motor, cor, ano, placa, combustivel);
        
        this.veiculos.add(c);
        retorno.add("1");
        retorno.add(c.toString());
        
        return retorno;
    }
    
    public String[] mostrarClientes() {
        String[] retornoClientes = new String[50];
        int count = 0;
        for(Cliente c : this.clientes) {
            retornoClientes[count] = c.getNome() + " - CPF " + c.getCpf();
            count++;
        }
        return retornoClientes;
    }
    
    public int removerCliente(String cpf) {
        for(Cliente c : clientes) {
            if(c.getCpf().equals(cpf)) {
                clientes.remove(c);
                return 1;
            }
        }
        return 0;
    }
    
}
