package locadora.app;

import locadora.model.Cliente;
import locadora.model.Locacao;
import locadora.model.Veiculo;
import locadora.model.Vendedor;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        ArrayList<Locacao> locacoes = new ArrayList<>();
        ArrayList<Vendedor> vendedores = new ArrayList<>();

        int opcao = 0;

        while (opcao != 18) {
            System.out.println("========= LOCADORA =========\n" +
                    "\n" +
                    "1  - Cadastrar cliente\n" +
                    "2  - Cadastrar veículo\n" +
                    "3  - Cadastrar vendedor\n" +
                    "4  - Realizar locação\n" +
                    "5  - Finalizar locação\n" +
                    "\n" +
                    "6  - Mostrar clientes\n" +
                    "7  - Mostrar veículos\n" +
                    "8  - Mostrar vendedores\n" +
                    "9  - Mostrar locações\n" +
                    "10 - Mostrar veículos disponíveis\n" +
                    "11 - Mostrar veículos alugados\n" +
                    "\n" +
                    "12 - Atualizar cliente\n" +
                    "13 - Atualizar veículo\n" +
                    "14 - Atualizar vendedor\n" +
                    "\n" +
                    "15 - Remover cliente\n" +
                    "16 - Remover veículo\n" +
                    "17 - Remover vendedor\n" +
                    "\n" +
                    "18 - Sair");
            try {
                opcao = Integer.parseInt(scanner.nextLine());

                if (opcao == 1) {

                    System.out.println("Me diga o cpf do cliente: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Me diga o nome do cliente: ");
                    String nome = scanner.nextLine();

                    System.out.println("Me diga o telefone do cliente: ");
                    String telefone = scanner.nextLine();

                    System.out.println("Me diga o saldo do cliente: ");
                    double saldo = Double.parseDouble(scanner.nextLine());

                    for (Cliente cliente : clientes) {
                        if (cliente.getCpf().equals(cpf)) {
                            throw new RuntimeException("Cliente já cadastrado!");
                        }
                    }
                    if (saldo < 0) {
                        throw new RuntimeException("Saldo inválido.");
                    }

                    Cliente cliente = new Cliente(cpf, nome, telefone, saldo);

                    clientes.add(cliente);

                    System.out.println("Cliente cadastrado com sucesso!");
                } else if (opcao == 2) {


                    System.out.println("Me diga a placa do veiculo");
                    String placa = scanner.nextLine();

                    System.out.println("Me diga o modelo do veiculo");
                    String modelo = scanner.nextLine();

                    System.out.println("Me diga a marca do veiculo");
                    String marca = scanner.nextLine();

                    System.out.println("Me diga o preco do veiculo");
                    double preco = Double.parseDouble(scanner.nextLine());



                    for (Veiculo veiculo : veiculos) {
                        if (veiculo.getPlaca().equals(placa)) {
                            throw new RuntimeException("Já temos esse veículo no sistema.");
                        }
                    }

                    Veiculo veiculo = new Veiculo(placa, modelo, marca, preco);

                    veiculos.add(veiculo);

                    System.out.println("Veículo cadastrado com sucesso!");

                } else if (opcao == 3) {

                    System.out.println("Me diga o cpf do vendedor: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Me diga o nome do vendedor: ");
                    String nome = scanner.nextLine();

                    System.out.println("Me diga o telefone do vendedor: ");
                    String telefone = scanner.nextLine();

                    int carrosVendidos = 0;

                    for (Vendedor vendedor : vendedores) {
                        if (vendedor.getCpf().equals(cpf)) {
                            throw new RuntimeException("Vendedor já cadastrtado!");
                        }
                    }

                    Vendedor vendedor = new Vendedor(cpf, nome, telefone, carrosVendidos);
                    vendedores.add(vendedor);

                    System.out.println("Vendedor cadastrado com sucesso!");

                } else if (opcao == 4) {
                    Cliente clienteEncontrado = null;

                    System.out.println("Qual o cpf do cliente: ");
                    String cpfC = scanner.nextLine();

                    for (Cliente cliente : clientes) {
                        if (cliente.getCpf().equals(cpfC)) {
                            clienteEncontrado = cliente;
                            break;
                        }
                    }

                    if(clienteEncontrado == null){
                        throw new RuntimeException("Cliente não encontrado.");
                    }

                    Veiculo veiculoEncontrado = null;
                    System.out.println("Qua a placa do veiculo: ");
                    String placa = scanner.nextLine();
                    for (Veiculo veiculo : veiculos) {
                        if (veiculo.getPlaca().equals(placa)) {
                            veiculoEncontrado = veiculo;
                            break;
                        }
                    }

                    if(veiculoEncontrado == null){
                        throw new RuntimeException("Veículo não encontrado");
                    }

                    Vendedor vendedorEncontrado = null;
                    System.out.println("Qual o cpf do vendedor: ");
                    String cpfV = scanner.nextLine();
                    for (Vendedor vendedor : vendedores) {
                        if (vendedor.getCpf().equals(cpfV)) {
                            vendedorEncontrado = vendedor;
                            break;
                        }
                    }

                    if(vendedorEncontrado == null){
                        throw new RuntimeException("Vendedor não encontrado");
                    }

                    System.out.println("Qual a data da locação: ");
                    String data = scanner.nextLine();



                    Locacao locacao = new Locacao(clienteEncontrado, veiculoEncontrado, data, vendedorEncontrado);

                    locacao.realizarLocacao();

                    locacoes.add(locacao);

                    System.out.println("Locação realizada com sucesso!");

                } else if (opcao == 5) {
                    System.out.println("Placa do veículo: ");
                    String placa = scanner.nextLine();

                    Locacao locacaoEncontrada = null;
                    for (Locacao locacao : locacoes) {
                        if (locacao.isAtiva() && locacao.getVeiculo().getPlaca().equalsIgnoreCase(placa)) {
                            locacaoEncontrada = locacao;
                            break;
                        }

                    }
                    if (locacaoEncontrada != null) {
                        locacaoEncontrada.finalizarLocacao();
                        System.out.println("Locação finalizada com sucesso!");
                    } else {
                        throw new RuntimeException("Não existe locação ativa para esse veículo.");
                    }

                } else if (opcao == 6) {
                    for (Cliente cliente : clientes) {
                        cliente.mostrarDados();
                        System.out.println();
                    }

                } else if (opcao == 7) {
                    for (Veiculo veiculo : veiculos) {
                        veiculo.mostrarDados();
                        System.out.println();
                    }

                } else if (opcao == 8) {
                    for (Vendedor vendedor : vendedores) {
                        vendedor.mostrarDados();
                        System.out.println();
                    }

                } else if (opcao == 9) {
                    for (Locacao locacao : locacoes) {
                        locacao.mostrarDados();
                        System.out.println();
                    }

                } else if (opcao == 10) {
                    for (Veiculo veiculo : veiculos) {
                        if (veiculo.isDisponivel()) {
                            veiculo.mostrarDados();
                        }
                    }
                } else if (opcao == 11) {
                    for (Veiculo veiculo : veiculos) {
                        if (!veiculo.isDisponivel()) {
                            veiculo.mostrarDados();
                        }
                    }

                } else if (opcao == 12) {

                    System.out.println("Digite o cpf do cliente que você quer atualizar: ");
                    String cpf = scanner.nextLine();

                    Cliente clienteEncontrado = null;
                    for (Cliente cliente : clientes) {
                        if (cliente.getCpf().equals(cpf)) {
                            clienteEncontrado = cliente;
                            break;
                        }
                    }

                    if (clienteEncontrado == null) {
                        throw new RuntimeException(
                                "Cliente não encontrado para atualização."
                        );
                    }

                    System.out.println("Qual o novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    clienteEncontrado.setTelefone(novoTelefone);

                    System.out.println("Qual o novo Saldo: ");
                    double novoSaldo = Double.parseDouble(scanner.nextLine());

                    if (novoSaldo < 0) {
                        throw new RuntimeException(
                                "O saldo não pode ser negativo."
                        );
                    }

                    clienteEncontrado.setTelefone(novoTelefone);
                    clienteEncontrado.setSaldo(novoSaldo);

                    System.out.println("Cliente atualizado com sucesso!");

                } else if (opcao == 13) {

                    System.out.println("Digite a placa do veículo que vocÊ quer atualizar: ");
                    String placa = scanner.nextLine();

                    Veiculo veiculoEncontrado = null;
                    for (Veiculo veiculo : veiculos) {
                        if (veiculo.getPlaca().equals(placa)) {

                            veiculoEncontrado = veiculo;
                            break;
                        }
                    }

                    if (veiculoEncontrado == null) {
                        throw new RuntimeException(
                                "Veículo não encontrado para atualização."
                        );
                    }

                    System.out.println("Me diga o modelo atualizado do veiculo");
                    String novoModelo = scanner.nextLine();

                    System.out.println("Me diga a marca atualizada do veiculo");
                    String novoMarca = scanner.nextLine();

                    System.out.println("Me diga o preco atualizado do veiculo");
                    double novoPreco = Double.parseDouble(scanner.nextLine());

                    if(novoPreco <=0){
                        throw new RuntimeException("O preço deve ser maior que 0.");
                    }

                    veiculoEncontrado.setModelo(novoModelo);
                    veiculoEncontrado.setMarca(novoMarca);
                    veiculoEncontrado.setPreco(novoPreco);

                    System.out.println("Veículo atualizado com sucesso!");


                }  else if (opcao == 14) {

                System.out.println("Digite o CPF do vendedor que deseja atualizar:");
                String cpf = scanner.nextLine();

                Vendedor vendedorEncontrado = null;

                for (Vendedor vendedor : vendedores) {
                    if (vendedor.getCpf().equals(cpf)) {
                        vendedorEncontrado = vendedor;
                        break;
                    }
                }


                if (vendedorEncontrado == null) {
                    throw new RuntimeException(
                            "Vendedor não encontrado para atualização."
                    );
                }

                System.out.println("Digite o novo nome:");
                String novoNome = scanner.nextLine();

                System.out.println("Digite o novo telefone:");
                String novoTelefone = scanner.nextLine();

                vendedorEncontrado.setNome(novoNome);
                vendedorEncontrado.setTelefone(novoTelefone);

                System.out.println("Vendedor atualizado com sucesso!");

            } else if (opcao == 15) {
                    System.out.println("CPF do cliente que vocÊ quer remover: ");
                    String cpf = scanner.nextLine();
                    for(Locacao locacao : locacoes){
                        if(locacao.isAtiva() && locacao.getCliente().getCpf().equals(cpf)){
                            throw new RuntimeException("Não podemos remover um cliente que está com uma locação ativa.");
                        }
                    }

                    int indice = -1;

                    for(int i = 0; i <clientes.size(); i++){
                        if(clientes.get(i).getCpf().equals(cpf)){
                            indice = i;
                            break;
                        }
                    }

                    if(indice == -1){
                        throw new RuntimeException("Cliente não encontrado!");
                    }

                    clientes.remove(indice);

                    System.out.println("Cliente removido com sucesso!");

                } else if (opcao == 16) {
                    System.out.println("Placa do veículo que você quer remover: ");
                    String placa = scanner.nextLine();;


                    int indice = -1;

                    for(int i = 0; i< veiculos.size(); i++){
                        if(veiculos.get(i).getPlaca().equals(placa)){
                            if(!veiculos.get(i).isDisponivel()){
                                throw new RuntimeException("Não é possivel remover um veículo que está alugado!");
                            }

                            indice=i;
                            break;
                        }
                    }

                    if(indice==-1){
                        throw new RuntimeException("Esse veículo não está cadastrado no sistema!");
                    }

                    veiculos.remove(indice);

                    System.out.println("Veículo removido com sucesso!");
                } else if(opcao == 17){

                    System.out.println("Me diga o CPF do vendedor: ");
                    String cpf = scanner.nextLine();

                    for(Locacao locacao : locacoes){
                        if(locacao.isAtiva() && locacao.getVendedor().getCpf().equals(cpf)){
                            throw new RuntimeException("Não podemos remover um vendedor responsável por uma locação ativa.");
                        }
                    }

                    int indice = -1;

                    for(int i = 0; i <vendedores.size(); i++){
                        if(vendedores.get(i).getCpf().equals(cpf)){
                            indice = i;
                            break;
                        }
                    }

                    if(indice == -1){
                        throw new RuntimeException("Vendedor não encontrado!");
                    }

                    vendedores.remove(indice);

                    System.out.println("Vendedor removido com sucesso!");

                } else if (opcao == 18) {
                    System.out.println("Saindo do sistema...");
                } else {
                    System.out.println("Opção inválida.");
                }

            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
