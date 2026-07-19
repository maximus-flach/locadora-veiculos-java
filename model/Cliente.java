package locadora.model;

public class Cliente extends Pessoa{
    private double saldo;



    public Cliente(String cpf, String nome, String telefone, double saldo) {
        super(cpf, nome, telefone);

        if (saldo < 0) {
            throw new RuntimeException("O saldo não pode ser negativo.");
        }

        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {

        if (saldo < 0) {
            throw new RuntimeException("O saldo não pode ser negativo.");
        }

        this.saldo = saldo;
    }


    @Override
    public void mostrarDados(){
        super.mostrarDados();
        System.out.println("Saldo da conta bancária: " + saldo);
    }

    public void verificarPermissaoParaAlugar(Veiculo veiculo){
        if(saldo < veiculo.getPreco()){
            throw new RuntimeException("Saldo insuficiente para alugar");
        }
    }

    public void pagar(double valor){

        if(valor<=0){
            throw new RuntimeException("Valor de pagamento inválido.");

        }

        if(valor>saldo){
            throw new RuntimeException("Saldo insuficiente");
        }

        saldo -= valor;
    }
}
