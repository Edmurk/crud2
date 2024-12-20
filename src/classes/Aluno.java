package classes;
import java.util.*;


public class Aluno {
    private int id;
    private String nome;
    private List<Double> notas;

    public Aluno(int id, String nome, List<Double> notas) {
        this.id = id;
        this.nome = nome;
        this.notas = notas;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public double calcularMedia() {
        return notas.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public boolean verificarAprovacao() {
        return calcularMedia() >= 6;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Média: " + calcularMedia() + ", Aprovado: " + verificarAprovacao();
    }
}