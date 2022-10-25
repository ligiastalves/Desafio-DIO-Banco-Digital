import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente ligia = new Cliente();
        ligia.setNome("Ligia");

        Conta cc = new ContaCorrente(ligia);
        Conta cp = new ContaPoupanca(ligia);

        cc.depositar(250);
        cc.imprimirExtrato();

        cc.transferir(300, cp);


        cp.imprimirExtrato();
        cc.imprimirExtrato();
    }
}
