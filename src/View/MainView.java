
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
        ctr.inserirExemplos();
        int codVenda = 1;
        
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
                        System.out.println("\nHouve um erro ao cadastrar o cliente!\n");
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
                case 4:
                    System.out.print("Insira a placa do carro a ser vendido: ");
                    String placa = sc.nextLine();
                    System.out.print("Insira o cpf do vendedor: ");
                    String cpfVend = sc.nextLine();
                    System.out.print("Insira o cpf do cliente: ");
                    String cpfCliente = sc.nextLine();
                    System.out.print("Insira o valor da venda: ");
                    double valor = sc.nextDouble();
                    System.out.print("Insira método de pagamento: ");
                    String metodo = sc.nextLine();
                    sc.next();
                    
                    ArrayList<String> dadosVenda = ctr.realizarVenda("V00" + codVenda, placa, cpfVend, cpfCliente, valor, metodo);
                    if(dadosVenda.get(0).equals("0")) {
                        System.out.println("\nDados incorretos. Tente novamente.\n");
                    } else if(dadosVenda.get(0).equals("2")) {
                        System.out.println("\nVeículo não está mais em estoque.\n");
                    }
                    else
                        System.out.println("\nVenda realizada com sucesso!\n" + dadosVenda.get(1));
                    break;
                case 5:
                    System.out.print("Digite o CPF do vendedor para calcular o total de comissão: ");
                    String cpfV = sc.nextLine();
                    String[] totalComissao = ctr.calcularComissao(cpfV);
                    if(totalComissao[1] == "") {
                        System.out.println("\nVendedor ainda não possui venda ou não está cadastrado.\n");
                    }
                    else {
                        System.out.println("\nVendedor " + totalComissao[0] + " possui " + totalComissao[1] + " de comissão.\n");
                    }
                    break;
                case 6:
                    System.out.print("Digite a placa do carro que está sendo liberado.");
                    String idPlaca = sc.nextLine();
                    boolean liberado = ctr.liberarVeiculo(idPlaca);
                    if(liberado) {
                        System.out.println("\nVeículo liberado com sucesso.\n");
                    }
                    else {
                        System.out.println("\nEste veículo já não se encontra mais no estoque.\n");
                    }

                default:
                    break;
            }
            codVenda++;
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
                + "2 - Listar clientes\n"
                + "3 - Cadastrar veículo\n"
                + "4 - Realizar venda\n"
                + "5 - Calcular comissão\n"
                + "6 - Liberar veículo";
        
        System.out.println(opcoes);
        
        do {
            op = sc.nextInt();
        }
        while(op < 1 || op > 10);
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
