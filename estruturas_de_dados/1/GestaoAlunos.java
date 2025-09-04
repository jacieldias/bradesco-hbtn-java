package estruturas_de_dados.1;

public class GestaoAlunos {
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
    }

    public void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public void excluirAluno(String nome) {
        alunos.removeIf(aluno -> aluno.getNome().equalsIgnoreCase(nome));
    }

    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println(aluno.toString);
            }
        }
    }
}
