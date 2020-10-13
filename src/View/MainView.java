
package View;

import Controller.MainController;
import java.util.ArrayList;
import java.util.Scanner;

public class MainView {
    
    public static void main(String[] args) {
        MainView tela = new MainView();
        tela.start();
    }
    
    public void start() {
        MainController ctr = new MainController();
        
        do {
            Scanner sc = new Scanner(System.in);
            int op = MainView.mostrarOpcoesCadastro();
        
        
            switch(op) {
                case 1:
                   String[] dadosCliente = MainView.formCliente();
                   ArrayList<String> retorno = ctr.cadastrarCliente(dadosCliente[0], dadosCliente[1]);
                  if(retorno.get(0).equals("1")) {
                      System.out.println("Cliente cadastrado com sucesso!");
                     System.out.println("Cliente: " 
                                        + retorno.get(1) + "\n"
                                        + "CPF: "
                                              + retorno.get(2));
                   }
                    else {
                        System.out.println("Houve um erro ao cadastrar o cliente!");
                    }
                    break;
                case 2:
                    String[] clientes = ctr.mostrarClientes();
                    for(String cliente : clientes) {
                        if(cliente != null)
                            System.out.println(cliente);
                    }
                    break;
                case 3:
                    String[] dadosVeiculo = MainView.formVeiculo();
                    ArrayList<String> retornoVeiculo = ctr.cadastrarVeiculo(
                        dadosVeiculo[0], dadosVeiculo[1], dadosVeiculo[2], dadosVeiculo[3], 
                        dadosVeiculo[4], dadosVeiculo[5], dadosVeiculo[6]);
                    if(retornoVeiculo.get(0).equals("1")) {
                      System.out.println("Veiculo cadastrado com sucesso!");
                     System.out.println(retornoVeiculo.get(1));
                   }
                    else {
                        System.out.println("Houve um erro ao cadastrar o cliente!");
                    }
                    /* System.out.println("Digite o cpf do cliente a ser removido: ");
                    String cpf = sc.nextLine();
                    
                    int cod = ctr.removerCliente(cpf);
                    
                    if(cod == 1) {
                        System.out.println("Cliente removido com sucesso!");
                    }
                    else if(cod == 0) {
                        System.out.println("CPF não encontrado!");
                    } */
                    break;
                default:
                    break;
            }
            System.out.println("Aperte qualquer tecla para voltar...");
            String key = sc.nextLine();
            //sc.close();
            if(key.equals("")){
                continue;
            }
        } while(true);
    }
    
    public static int mostrarOpcoesCadastro() {
        int op;
        Scanner sc = new Scanner(System.in);
        
        final String opcoes = "Olá! Escolha uma das opções a seguir: \n"
                + "1 - Cadastrar cliente\n"
                + "2 - Cadastrar vendedor\n"
                + "3 - Cadastrar veículo";
        
        System.out.println(opcoes);
        
        do {
            op = sc.nextInt();
        }
        while(op < 1 || op > 3);
       // sc.close();
        return op;
        
    }
    
    public static String[] formCliente() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Insira o nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Insira o cpf do cliente: ");
        String cpf = sc.nextLine();
        
        String[] dados = {nome, cpf};
        //sc.close();
        return dados;
    }
    
    public static String[] formVendedor() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Insira o nome do vendedor: ");
        String nome = sc.nextLine();
        System.out.print("Insira o cpf do vendedor: ");
        String cpf = sc.nextLine();
        System.out.print("Insira o salário do vendedor: ");
        String salario = sc.nextLine();
        System.out.print("Insira a comissão do vendedor: ");
        String comissao = sc.nextLine();

        String[] dados = {nome, cpf, salario, comissao};
        //sc.close();
        return dados;
    }

    public static String[] formVeiculo() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Insira a montadora do veiculo: ");
        String montadora = sc.nextLine();
        System.out.print("Insira o modelo do veiculo: ");
        String modelo = sc.nextLine();
        System.out.print("Insira o motor do veiculo: ");
        String motor = sc.nextLine();
        System.out.print("Insira a cor do veiculo: ");
        String cor = sc.nextLine();
        System.out.print("Insira o ano do veículo: ");
        String ano = sc.nextLine();
        System.out.print("Insira a placa do veículo: ");
        String placa = sc.nextLine();
        System.out.print("Insira o combustível do veículo: ");
        String combustivel = sc.nextLine();

        String[] dados = {montadora, modelo, motor, cor, ano, placa, combustivel};
        //sc.close();
        return dados;
    }
}
