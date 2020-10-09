
package View;

import Controller.MainController;
import java.util.ArrayList;
import java.util.Scanner;

public class TpaMVC {
    
    public static void main(String[] args) {
        // TODO code application logic here
        TpaMVC tela = new TpaMVC();
        tela.start();
    }
    
    public void start() {
        MainController ctr = new MainController();
        int op = TpaMVC.mostrarOpcoes();
        
        
        switch(op) {
            case 1:
                String[] dadosCliente = TpaMVC.formCliente();
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
                //String[] dadosVendedor = TpaMVC.formVendedor();
                //ctr.cadastrarVendedor(dadosVendedor[0], dadosVendedor[1]);
                break;
            case 3:
                //String[] dadosVeiculo = TpaMVC.formVeiculo();
                //ctr.cadastrarVeiculo(dadosVeiculo);
                break;
            default:
                break;
        }
    }
    
    public static int mostrarOpcoes() {
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
}
