package classes;
import java.util.*;


public class Turma {
    private int id;
    private String nome;
    private List<Aluno> alunos;

    public Turma(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(int idAluno) {
        alunos.removeIf(aluno -> aluno.getId() == idAluno);
    }

    public void listarAlunos() {
        System.out.println("Turma: " + nome);
        alunos.forEach(System.out::println);
    }

    public double calcularMediaGeral() {
        return alunos.stream().mapToDouble(Aluno::calcularMedia).average().orElse(0);
    }
}