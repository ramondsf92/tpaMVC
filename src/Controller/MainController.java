/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author ramon
 */
public class MainController {
    
    private ArrayList<Cliente> clientes = new ArrayList();
    
    public ArrayList<String> cadastrarCliente(String nome, String cpf) {
        ArrayList<String> retorno = new ArrayList();
        
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
