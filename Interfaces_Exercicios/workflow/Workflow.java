import java.util.List;

import atividades.Atividade;

public class Workflow {

    List<Atividade> atividades;

    public void registrarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

}
