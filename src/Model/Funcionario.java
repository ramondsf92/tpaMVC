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
public abstract class Funcionario {
    private String nome;
    private String cpf;
    private String salario;
    
    public void baterPonto() {
        
    }

    public Funcionario(String nome, String cpf, String salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

}
