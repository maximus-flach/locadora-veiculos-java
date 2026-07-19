package locadora.model;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private String dataLocacao;
    private boolean ativa;
    private Vendedor vendedor;

    public Locacao(Cliente cliente, Veiculo veiculo, String dataLocacao,  Vendedor vendedor) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataLocacao = dataLocacao;
        this.ativa = false;
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void realizarLocacao() {

        if(ativa){
            throw new RuntimeException("Esta locação está ativa.");
        }

        cliente.verificarPermissaoParaAlugar(veiculo);

        veiculo.alugar();

        cliente.pagar(veiculo.getPreco());

        vendedor.registrarLocacao();

        ativa = true;


    }


    public void finalizarLocacao(){
        veiculo.devolver();
        ativa = false;

    }

    public void mostrarDados(){
        System.out.println("\nCliente:");
        cliente.mostrarDados();

        System.out.println("\nVeículo:");
        veiculo.mostrarDados();

        System.out.println("\nVendedor:");
        vendedor.mostrarDados();

        System.out.println("Data da locação: " + dataLocacao);

        System.out.println("Status: " + (ativa ? "Ativa" : "Finalizada"));
    }



}





