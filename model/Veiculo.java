package locadora.model;
public class Veiculo {
    private String placa;
    private String modelo;
    private String marca;
    private boolean disponivel;
    private double preco;


    public Veiculo(String placa, String modelo, String marca,  double preco) {

        if (preco <= 0) {
            throw new RuntimeException("O preço deve ser maior que zero.");
        }

        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.disponivel = true;
        this.preco = preco;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new RuntimeException("O preço deve ser maior que zero.");
        }

        this.preco = preco;
    }



    public void alugar() {

        if (!disponivel) {
            throw new RuntimeException("Veículo já está alugado.");
        }

        disponivel = false;


    }

    public void devolver(){
        if(disponivel){
            throw new RuntimeException("Veiculo não pode ser devolvido sendo que está disponivel.");
        }

        disponivel = true;


    }


    public void mostrarDados(){
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Marca: " + marca);
        System.out.println("Disponível: " + disponivel);
        System.out.println("Preco: " + preco);
    }


}
