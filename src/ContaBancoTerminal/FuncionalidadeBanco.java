package ContaBancoTerminal;

import java.util.Locale;
import java.util.Scanner;


public class FuncionalidadeBanco{           

    int saque;
    int opcSaque;
    int saldo;
    double valorConta;
    double deposito;
    double cpf;
    String nomeCompleto;
    String agencia = "067-8";
    String senha = "1509";
    String altorizarCriarConta;
    
    
    String dadosCliente;
    String dadosBancarios;

    public void validarNome(){
        
        Scanner sc = new Scanner(System.in);
        
        this.nomeCompleto = nomeCompleto;

        nomeCompleto = sc.nextLine();
        
            if (nomeCompleto.equals(nomeCompleto)) {
            System.out.println("Olá " + nomeCompleto + " é um prazer atende-lo, por favor siga os demais passos...");      
        }
            else{
                System.out.println("Nome invalido!!!");
                nomeCompleto = sc.nextLine();
            }
        }

        public Double validarCpf(Double cpf){
    
        Scanner sc = new Scanner(System.in);
    
            this.cpf = cpf;
    
            if (cpf != 111111111 && cpf != 999999999 && cpf > 1) {
                System.out.println("Parabéns, você está elegivel para possuir uma conta em nosso banco!");          
            }
            else{
                System.out.println("CPF inválido, tente novamente");
                String validarCpf = sc.nextLine();
            }
        return cpf;
        }

        public String altorizarCriacaoConta(String altorizarCriarConta){
            Scanner sc = new Scanner(System.in);

            this.altorizarCriarConta = altorizarCriarConta;
            altorizarCriarConta = sc.nextLine();

            if (altorizarCriarConta.equals("Sim") || altorizarCriarConta.equals("sim")) {
                System.out.println("Essa é a sua agencia: " + agencia + " e senha: " +  senha);
            }
            else{
                System.out.println("Operação cancelada! Espero que você retorne futuramente.");
                System.exit(0);
            }

        return altorizarCriarConta;
        }

        public void valorDeposito(){

            Scanner sc = new Scanner(System.in);

            this.deposito = deposito;
            
            deposito = sc.nextInt();
            if(deposito <= 200){
                System.out.println("Seu saldo atual é de R$ " + deposito);
            }
            else if(deposito > 200){
                System.out.println("Valor não liberado. Lembre-se, comece pequeno!!");
                System.out.println("Tente novamente abaixo: ");
                deposito = sc.nextInt();
            }
            System.out.println(deposito);
        }

        public double valorSaque(double valorConta){

            Scanner sc = new Scanner(System.in);

            this.opcSaque = opcSaque;
            this.deposito =  deposito;
            this.valorConta = valorConta;
            this.saque = saque;

            int opcSaque = sc.nextInt();

            if(opcSaque == (1)){

                System.out.println(deposito);

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
        return valorConta;
        }    

        public void informacaoGeral(){
            this.agencia = agencia;
            this.valorConta = valorConta;
            this.nomeCompleto = nomeCompleto;
            this.senha = senha;
            this.cpf= cpf; 

            Scanner sc = new Scanner(System.in);

            System.out.println("Pressione 1 para visualizar suas inforamações que estão no sistema, e 2 para sair. ");
            String opcVisualizar = sc.nextLine();

            if (opcVisualizar.equals("1")) {

                System.out.println("Insira a agencia: ");
                agencia = sc.nextLine();
                System.out.println("Insira sua senha: ");
                senha = sc.nextLine();
                System.out.println("Insira seu CPF: ");
                cpf = sc.nextDouble();

                if((senha.equals("1509")) && (agencia.equals("067-8")) && cpf > 1 && cpf != 1111111111 && cpf != 999999999 ){
                    System.out.println("Nome: " + nomeCompleto + "| CPF: " + cpf);
                    System.out.println("Agencia: " + agencia + " | Senha: " + senha + " | R$" + valorConta);
                    }
                else{
                    System.out.println("Informações inseridas estão incorretas, tente novamente mais tarde. Em caso de insistencia a conta será bloqueada!");
                    System.exit(0);
                    }
            }
            else{
                System.out.println("Tenha uma ótima semana e volte sempre!!");
                System.exit(0);
            }
        }            
}
