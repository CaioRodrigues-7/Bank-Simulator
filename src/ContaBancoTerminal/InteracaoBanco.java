package ContaBancoTerminal;

import java.util.Scanner;



public class InteracaoBanco extends FuncionalidadeBanco{

    public static void main(String[] args){

        InteracaoBanco vb = new InteracaoBanco();
        Scanner scan = new Scanner(System.in);

        System.out.println("Por favor digite seu nome: ");
        vb.validarNome();

        System.out.println("Digite o número do CPF: ");
        Double cpf = scan.nextDouble();
        vb.validarCpf(cpf);

        System.out.println("Tecle (sim) para seguir com a criação da conta, ou (não) para encerrar a operação!");
        vb.altorizarCriacaoConta(" ");

        System.out.println("Seu primeiro deposito tem um valor máximo de R$ 200,00. Insira o valor desejado abaixo: ");
        vb.valorDeposito();

        System.out.println("Para realizar saques digite 1, e 2 para encerrar a operação.");
        vb.valorSaque();

        vb.informacaoGeral();
    }
}