package org.artemis;

import org.artemis.application.AlertaService;
import org.artemis.application.EquipeResgateService;
import org.artemis.application.IncidenteService;
import org.artemis.domain.entities.Alerta;
import org.artemis.domain.entities.EquipeResgate;
import org.artemis.domain.entities.Incidente;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AlertaService alertaService = new AlertaService();
    private static EquipeResgateService equipeService = new EquipeResgateService();
    private static IncidenteService incidenteService = new IncidenteService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Processar leitura de sensor");
            System.out.println("2. Listar alertas ativos");
            System.out.println("3. Listar todos os alertas");
            System.out.println("4. Buscar alerta por ID");
            System.out.println("5. Criar equipe de resgate");
            System.out.println("6. Listar equipes");
            System.out.println("7. Atualizar disponibilidade de equipe");
            System.out.println("8. Atribuir equipe a incidente");
            System.out.println("9. Listar incidentes");
            System.out.println("0. Sair");
            int opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID da Leitura: ");
                    String idLeitura = scanner.nextLine();
                    System.out.print("ID do Sensor: ");
                    String sensorId = scanner.nextLine();
                    double valor = lerDouble("Valor: ");
                    System.out.print("Unidade (°C ou %): ");
                    String unidade = scanner.nextLine();

                    alertaService.processarLeituraSensor(idLeitura, sensorId, valor, unidade);
                    System.out.println("Leitura processada.");
                }
                case 2 -> {
                    List<Alerta> ativos = alertaService.listarAlertasAtivos();
                    ativos.forEach(System.out::println);
                }
                case 3 -> {
                    List<Alerta> todos = alertaService.listarTodosAlertas();
                    todos.forEach(System.out::println);
                }
                case 4 -> {
                    System.out.print("ID do Alerta: ");
                    String id = scanner.nextLine();
                    Alerta alerta = alertaService.buscarAlertaPorId(id);
                    System.out.println(alerta != null ? alerta : "Alerta não encontrado.");
                }
                case 5 -> {
                    System.out.print("ID da Equipe: ");
                    String id = scanner.nextLine();
                    System.out.print("Nome da Equipe: ");
                    String nome = scanner.nextLine();
                    System.out.print("Localização: ");
                    String local = scanner.nextLine();

                    equipeService.criarEquipe(id, nome, local);
                    System.out.println("Equipe criada com sucesso.");
                }
                case 6 -> {
                    List<EquipeResgate> equipes = equipeService.listarTodasEquipes();
                    equipes.forEach(System.out::println);
                }
                case 7 -> {
                    System.out.print("ID da Equipe: ");
                    String idEquipe = scanner.nextLine();
                    System.out.print("Disponível? (true/false): ");
                    boolean disponivel = Boolean.parseBoolean(scanner.nextLine());

                    equipeService.atualizarDisponibilidade(idEquipe, disponivel);
                    System.out.println("Disponibilidade atualizada.");
                }
                case 8 -> {
                    System.out.print("ID da Equipe para atribuir: ");
                    String idEquipe = scanner.nextLine();
                    boolean sucesso = incidenteService.atribuirEquipeAIncidente(null, idEquipe); // Provavelmente você precisará passar o ID do incidente também!
                    System.out.println(sucesso ? "Equipe atribuída com sucesso." : "Falha ao atribuir equipe.");
                }
                case 9 -> {
                    List<Incidente> incidentes = incidenteService.listarTodosIncidentes();
                    incidentes.forEach(System.out::println);
                }
                case 0 -> {
                    System.out.println("Encerrando sistema...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número decimal (ex: 10.5).");
            }
        }
    }
}