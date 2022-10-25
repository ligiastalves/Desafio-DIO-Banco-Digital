import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    protected int tipoConta;
    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }
    @Override
    public void sacar(double valor){
        saldo -= valor;
    }
    @Override
    public void depositar(double valor) {
        saldo += valor;
    }
    public void transferir(double valor, Conta contaDestino) {
        System.out.println("Para transferir amanhã digite 0, para transferência imediata digite 1: ");
        Scanner teclado = new Scanner(System.in);
        int tipoConta = teclado.nextInt();

        if (tipoConta == 0) {
            if (saldo <= valor) {
                System.out.println("Não possui saldo para transferir");
            }else{
                this.sacar(valor);
                contaDestino.depositar(valor);
                System.out.println("A transferencia de " + valor + " irá acontecer em 1 dia util");
            }
        }else if(tipoConta == 1){
            System.out.println("Não possui saldo para transferir");
        }else{
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("A transferencia de " + valor + " irá acontecer em instantes");
        }
    }
    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}