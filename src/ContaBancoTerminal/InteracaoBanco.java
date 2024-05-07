package ContaBancoTerminal;

import java.util.Scanner;

public class InteracaoBanco extends FuncionalidadeBanco{

    public static void main(String[] args){

        InteracaoBanco vb = new InteracaoBanco();

        Scanner scan = new Scanner(System.in);

        System.out.println("Por favor digite seu nome: ");
        String nomeCompleto = scan.nextLine();

        vb.validarNome(" ");

        System.out.println("Digite o número do CPF abaixo: ");
        Double cpf = scan.nextDouble();

        vb.validarCpf(cpf);

        System.out.println("Seu primeiro deposito tem um valor máximo de R$ 200,00. Insira o valor desejado abaixo: ");
        int deposito = scan.nextInt();

        vb.valorDeposito(deposito);

        System.out.println("Para realizar saques digite 1, ou 2 para encerrar a operação.");
        //int opcSaque = scan.nextInt();

        vb.valorSaque(' ');

        vb.informacaoGeral(" ");
    }
}