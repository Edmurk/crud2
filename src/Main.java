import classes.Aluno;
import classes.Turma;
import java.util.*;


public class Main {

    private static List<Turma> turmas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Principal");
            System.out.println("1. Criar Turma");
            System.out.println("2. Adicionar Aluno");
            System.out.println("3. Remover Aluno");
            System.out.println("4. Listar Alunos de uma Turma");
            System.out.println("5. Calcular Média Geral de uma Turma");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 -> criarTurma(scanner);
                case 2 -> adicionarAluno(scanner);
                case 3 -> removerAluno(scanner);
                case 4 -> listarAlunos(scanner);
                case 5 -> calcularMediaGeral(scanner);
                case 6 -> {
                    System.out.println("Encerrando sistema...");
                    return;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void criarTurma(Scanner scanner) {
        System.out.print("Digite o ID da turma: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o nome da turma: ");
        String nome = scanner.nextLine();
        turmas.add(new Turma(id, nome));
        System.out.println("Turma criada com sucesso!");
    }

    private static void adicionarAluno(Scanner scanner) {
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Turma turma = turmas.stream().filter(t -> t.getId() == idTurma).findFirst().orElse(null);

        if (turma == null) {
            System.out.println("Turma não encontrada!");
            return;
        }

        System.out.print("Digite o ID do aluno: ");
        int idAluno = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = scanner.nextLine();
        System.out.print("Digite as 4 notas do aluno (separadas por espaço): ");
        List<Double> notas = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            notas.add(scanner.nextDouble());
        }
        scanner.nextLine(); // Limpar o buffer

        turma.adicionarAluno(new Aluno(idAluno, nomeAluno, notas));
        System.out.println("Aluno adicionado com sucesso!");
    }

    private static void removerAluno(Scanner scanner) {
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Turma turma = turmas.stream().filter(t -> t.getId() == idTurma).findFirst().orElse(null);

        if (turma == null) {
            System.out.println("Turma não encontrada!");
            return;
        }

        System.out.print("Digite o ID do aluno: ");
        int idAluno = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        turma.removerAluno(idAluno);
        System.out.println("Aluno removido com sucesso!");
    }

    private static void listarAlunos(Scanner scanner) {
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Turma turma = turmas.stream().filter(t -> t.getId() == idTurma).findFirst().orElse(null);

        if (turma == null) {
            System.out.println("Turma não encontrada!");
            return;
        }

        turma.listarAlunos();
    }

    private static void calcularMediaGeral(Scanner scanner) {
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Turma turma = turmas.stream().filter(t -> t.getId() == idTurma).findFirst().orElse(null);

        if (turma == null) {
            System.out.println("Turma não encontrada!");
            return;
        }

        System.out.println("Média geral da turma: " + turma.calcularMediaGeral());
    }
}