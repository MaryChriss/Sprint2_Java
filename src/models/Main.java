package models;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<OficinaMecanica> oficinas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        adicionarOficinas();
        cadastrarCliente();
        exibirClientes();
        mostrarOficinas();
    }

    private static void adicionarOficinas() {
        adicionarOficina("Centro Automotivo Porto Seguro", "Av. Elísio Cordeiro de Siqueira, 369", "08:00 às 17:00", "123456789");
        adicionarOficina("Centro Automotivo Porto Seguro", "R. Guaipá, 1380 - Vila Leopoldina, São Paulo", "09:00 às 19:00", "987654321");
        adicionarOficina("Centro Automotivo Porto Seguro Morumbi", "R. Clarindo, 253 - Morumbi, São Paulo", "10:00 às 20:00", "111222333");
    }

    private static void adicionarOficina(String nome, String endereco, String horarioFuncionamento, String telefone) {
        oficinas.add(new OficinaMecanica(nome, endereco, horarioFuncionamento, telefone));
    }

    private static void cadastrarCliente() {
        System.out.println("___Cadastro de Cliente:___\n");

        Cliente novoCliente = new Cliente(
                String.valueOf(random.nextInt(100000)),
                solicitarEntrada("Nome: "),
                solicitarEntrada("Telefone: ")
        );

        clientes.add(novoCliente);
        System.out.println("\n*****-----Informações pessoais preenchidas!-----*****\n");

        if (solicitarEntrada("Deseja cadastrar um veículo para este cliente? (s/n)\n").equalsIgnoreCase("s")) {
            cadastrarVeiculo(novoCliente);
        } else {
            System.out.println("Cadastro de veículo não realizado.");
        }
    }

    private static void cadastrarVeiculo(Cliente cliente) {
        System.out.println("___Cadastro de Veículo: ___\n");

        Veiculo novoVeiculo = new Veiculo(
                String.valueOf(random.nextInt(100000)),
                solicitarEntrada("-Marca do Veículo: "),
                solicitarEntrada("-Modelo do Veículo: "),
                Integer.parseInt(solicitarEntrada("-Ano do Veículo: ")),
                solicitarEntrada("-Placa do Veículo: ")
        );

        Date dataEmissao = obterData("Data de emissão do documento (dd/MM/yyyy): ");
        Date dataValidade = obterData("Data de validade do documento (dd/MM/yyyy): ");
        DocumentacaoVeiculo documento = new DocumentacaoVeiculo(
                String.valueOf(random.nextInt(100000)),
                "Documento",
                dataEmissao,
                dataValidade
        );

        if (documento.verificarValidade()) {
            cliente.adicionarVeiculo(novoVeiculo);
            System.out.println("\n*****-----Veículo cadastrado com sucesso!-----*****\n");
            novoVeiculo.adicionarProblema(cadastrarProblema());
        } else {
            System.out.println("Documento do veículo inválido. Veículo não cadastrado.");
        }
    }

    private static Date obterData(String mensagem) {
        while (true) {
            try {
                return new SimpleDateFormat("dd/MM/yyyy").parse(solicitarEntrada(mensagem));
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Por favor, digite novamente (dd/MM/yyyy):");
            }
        }
    }

    private static Problema cadastrarProblema() {
        System.out.println("___Cadastro de Problema:___\n");

        return new Problema(
                String.valueOf(random.nextInt(100000)),
                solicitarEntrada("-Descrição do Problema: "),
                Integer.parseInt(solicitarEntrada("-Qual a prioridade do Problema de 1 a 5 (levando em conta que 5 é urgente): "))
        );
    }

    private static void exibirClientes() {
        System.out.println("\n___Clientes cadastrados:___\n");
        for (Cliente cliente : clientes) {
            System.out.println("  -ID: " + cliente.getIdCliente());
            System.out.println("  -Nome: " + cliente.getNome());
            System.out.println("  -Telefone: " + cliente.getTelefone());

            for (Veiculo veiculo : cliente.getVeiculos()) {
                System.out.println("\n  -ID Veículo: " + veiculo.getIdVeiculo());
                System.out.println("  -Marca: " + veiculo.getMarca());
                System.out.println("  -Modelo: " + veiculo.getModelo());
                System.out.println("  -Ano: " + veiculo.getAno());
                System.out.println("  -Placa: " + veiculo.getPlaca());
                veiculo.exibirProblemas();

                for (String diagnostico : obterDiagnostico(veiculo.getProblemas())) {
                    System.out.println("  -Diagnóstico: " + diagnostico);
                }
                System.out.println();
            }
        }
    }

    private static List<String> obterDiagnostico(List<Problema> problemas) {
        List<String> diagnosticos = new ArrayList<>();
        for (Problema problema : problemas) {
            String descricao = problema.getDescricaoProblema().toLowerCase();
            if (descricao.contains("aquecimento") || descricao.contains("aquecendo") || descricao.contains("esquentando")) {
                diagnosticos.add("O problema pode ser relacionado ao sistema de refrigeração. Verifique o radiador e o sistema de arrefecimento.");
            } else if (descricao.contains("ruído") || descricao.contains("barulho")) {
                diagnosticos.add("O problema pode estar relacionado ao sistema de transmissão ou aos rolamentos. Verifique a caixa de câmbio e as rodas.");
            } else if (descricao.contains("falha de partida") || descricao.contains("liga") || descricao.contains("ligar")) {
                diagnosticos.add("O problema pode estar relacionado ao sistema de ignição ou à bateria. Verifique as velas de ignição e a carga da bateria.");
            } else {
                diagnosticos.add("Não foi possível determinar o diagnóstico com base na descrição fornecida.");
            }
        }
        return diagnosticos;
    }

    private static void mostrarOficinas() {
        System.out.println("___Opções de Oficinas:___\n");
        int i = 1;
        for (OficinaMecanica oficina : oficinas) {
            System.out.println(i++ + ". " + oficina.getNome() + " - " + oficina.getEndereco() + " horário: " + oficina.getHorarioFuncionamento() + " Telefone: " + oficina.getTelefone());
        }
        System.out.println("\nAgora é só escolher a oficina de sua preferência!\n");
    }

    private static String solicitarEntrada(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}