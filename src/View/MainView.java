
package View;

import Controller.MainController;
import java.util.ArrayList;
import java.util.Scanner;

public class MainView {
    
    public static void main(String[] args) {
        // TODO code application logic here
        MainView tela = new MainView();
        tela.start();
    }
    
    public void start() {
        MainController ctr = new MainController();
        
        do {
            Scanner sc = new Scanner(System.in);
            int op = MainView.mostrarOpcoes();
        
        
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
                    System.out.println("Digite o cpf do cliente a ser removido: ");
                    String cpf = sc.nextLine();
                    
                    int cod = ctr.removerCliente(cpf);
                    
                    if(cod == 1) {
                        System.out.println("Cliente removido com sucesso!");
                    }
                    else if(cod == 0) {
                        System.out.println("CPF não encontrado!");
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Aperte qualquer tecla para voltar...");
            String key = sc.nextLine();
            if(key.equals("")){
                continue;
            }
        } while(true);
    }
    
    public static int mostrarOpcoes() {
        int op;
        Scanner sc = new Scanner(System.in);
        
        final String opcoes = "Olá! Escolha uma das opções a seguir: \n"
                + "1 - Cadastrar cliente\n"
                + "2 - Mostrar clientes\n"
                + "3 - Remover cliente";
        
        System.out.println(opcoes);
        
        do {
            op = sc.nextInt();
        }
        while(op < 1 || op > 3);
        
        return op;
        
    }
    
    public static String[] formCliente() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Insira o nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Insira o cpf do cliente: ");
        String cpf = sc.nextLine();
        
        String[] dados = {nome, cpf};
        
        return dados;
    }
    
    public static String[] formVendedor() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Insira o nome do vendedor: ");
        String nome = sc.nextLine();
        System.out.print("Insira o cpf do cliente: ");
        String cpf = sc.nextLine();
        
        String[] dados = {nome, cpf};
        
        return dados;
    }
}
