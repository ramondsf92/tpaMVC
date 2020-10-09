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
    
}
