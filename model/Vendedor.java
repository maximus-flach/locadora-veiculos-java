package locadora.model;

public class Vendedor extends Pessoa {
    private int carrosVendidos;


    public Vendedor(String cpf, String nome, String telefone, int carrosVendidos) {
        super(cpf, nome, telefone);
        this.carrosVendidos = carrosVendidos;
    }

    public int getCarrosVendidos() {
        return carrosVendidos;
    }

    public void setCarrosVendidos(int carrosVendidos) {
        this.carrosVendidos = carrosVendidos;
    }

    public void registrarLocacao() {
        carrosVendidos++;
    }

    @Override
    public void mostrarDados(){
        super.mostrarDados();
        System.out.println("Quantidade de carros vendidos: " + carrosVendidos);
    }



}
