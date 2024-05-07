package ContaBancoTerminal;

import java.util.Locale;
import java.util.Scanner;


public class FuncionalidadeBanco{           

    Double cpf;
    int valorConta;
    int deposito;
    int saque;
    int opcSaque;
    String nomeCompleto;
    String saldo;
    String agencia = "067-8";
    String senha = "1509";
    String dadosBancarios;

    public String validarNome(String nomeCompleto){
        
        Scanner sc = new Scanner(System.in);
        
        this.nomeCompleto = nomeCompleto;
        
            if (nomeCompleto.equals(nomeCompleto)) {
            System.out.println("Olá " + nomeCompleto + " é um prazer atendelo, por favor siga os demais passos...");      
        }
            else{
                System.out.println("Nome invalido!!!");
                String validarCpf = sc.nextLine();
            }
            return nomeCompleto;
        }

        public Double validarCpf(Double cpf){
    
        Scanner sc = new Scanner(System.in);
    
            this.cpf = cpf;
    
            if (cpf != 111111111 && cpf != 999999999) {
                System.out.println("Parabéns, você está elegivel para possuir uma conta em nosso banco!");
                System.out.println("Essa é a sua agencia: " + agencia + " e senha: " +  senha);          
            }
            else{
                System.out.println("CPF inválido, tente novamente");
                String validarCpf = sc.nextLine();
            }
            return cpf;
        }

        public int valorDeposito(int deposito){

            Scanner sc = new Scanner(System.in);

            this.deposito = deposito;

            if(deposito < 200){
                System.out.println("Seu saldo atual é de R$ " + deposito);
            }
            else if(deposito > 200){
                System.out.println("Valor não liberado. Lembre-se, comece pequeno!!");
                System.out.println("Tente novamente abaixo: ");
                int valorDeposito = sc.nextInt();
            }
            return deposito;
        }

        public int valorSaque(int saque){

            Scanner sc = new Scanner(System.in);

            this.saque = saque;
            this.deposito = deposito;
            this.opcSaque = opcSaque;
            this.valorConta = valorConta;

            int opcSaque = sc.nextInt();

            if(opcSaque == (1)){

                System.out.println("Insira abaixo o valor para saque: ");

                saque = sc.nextInt();

                valorConta = deposito - saque;

                System.out.println("Saldo atual é de R$" + valorConta);

                if (valorConta < (0)) {
                    System.out.println("Seu saldo está negativo, regularize o quanto antes. Lembre-se, atrasos estão sujeitos a juros!!");
                }
                else{System.out.println("Operação concluida com sucesso!!");
                }
            }
            else{
                System.out.println("Operação cancelada, tenha um bom dia!!");
            }
            return saque;
        }

        public String informacaoGeral(String dadosBancarios){
            this.agencia = agencia;
            this.senha = senha;
            this.cpf= cpf;
            this.nomeCompleto = nomeCompleto;
            this.valorConta = valorConta;

            Scanner sc = new Scanner(System.in);

            System.out.println("Pressione 1 para visualizar suas inforamações que estão no sistema, e 2 para sair. ");
            String opcVisualizar = sc.nextLine();

            if (opcVisualizar.equals("1")) {
                System.out.println("Olá " + nomeCompleto + " portador do " + cpf + " ,aqui estão seus dado| Agencia - " + agencia + " senha - " + senha + " .Você tem disponível em conta R$ " + valorConta + "!!");
            }
            else{
                System.out.println("Tenha uma ótima semana!!(Caso ocorreu erro de digitação, tecle novamente abaixo)");
                opcVisualizar = sc.nextLine();
            }


            return dadosBancarios;
        }


}
