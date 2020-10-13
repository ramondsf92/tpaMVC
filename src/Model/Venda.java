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
public class Venda implements Identificavel {
    String codigo;
    Vendedor vendedor;
    Veiculo carro;
    Cliente cliente;
    double valorTotal;
    String metodoPagamento;

    public Venda(Vendedor v, Veiculo c, Cliente cl, double valor, String metodo) {
        this.vendedor = v;
        this.carro = c;
        this.cliente = cl;
        this.valorTotal = valor;
        this.metodoPagamento = metodo;
    }

    public String getID() {
        return this.codigo;
    }

    public void setID(String codigo) {
        this.codigo = codigo;
    }

    public Veiculo getCarro() {
        return carro;
    }

    public void setCarro(Veiculo carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String toString() {
        return "Venda feita por " + this.vendedor.getNome() + " para " + this.cliente.getNome() + " de um " + this.carro.toString();
    }
}
