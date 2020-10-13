/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;

import java.util.ArrayList;

/**
 *
 * @author ramon
 */
public class MainController {
    
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    public void inserirExemplos() {
        this.clientes.add(new Cliente("Mário", "111"));
        this.clientes.add(new Cliente("Tomás", "222"));
        this.vendedores.add(new Vendedor("Cármen", "333", "2000", "0.1"));
        this.vendedores.add(new Vendedor("Matilda", "444", "3000", "0.2"));
        this.veiculos.add(new Carro("Renault", "Clio", "1.6", "Azul", "2005", "KPU0240", "Flex"));
        this.veiculos.add(new Carro("Fiat", "Uno", "1.0", "Preto", "2017", "JDK2020", "Flex"));
    }
    
    public Cliente buscaCliente(String id) {
        for(Cliente c : this.clientes) {
            if(c.getID().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public Vendedor buscaVendedor(String id) {
        for(Vendedor v : this.vendedores) {
            if(v.getID().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public Veiculo buscaVeiculo(String id) {
        for(Veiculo c : this.veiculos) {
            if(c.getID().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<String> realizarVenda(String codigo, String placa, String cpfV, String cpfC, double valor, String metodo) {
        ArrayList<String> retorno = new ArrayList<String>();
        
        if(buscaVeiculo(placa) == null || buscaVendedor(cpfV) == null || buscaCliente(cpfC) == null) {
            retorno.add("0");
        }
        else {
            Venda v = new Venda(buscaVendedor(cpfV), buscaVeiculo(placa), buscaCliente(cpfC), valor, metodo);
            buscaVendedor(cpfV).realizarVenda(v);
            v.setID(codigo);
            retorno.add("1");
            retorno.add(v.toString());
        }
        return retorno;
    }

    public String[] calcularComissao(String id) {
        String nome = "";
        String comissao = "";
        for(Vendedor v : this.vendedores) {
            if(v.getID().equals(id)) {
                nome = v.getNome();
                comissao = String.valueOf(v.calcularComissao());
            }
        }
        String[] retorno = {nome, comissao};

        return retorno;
    }

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
