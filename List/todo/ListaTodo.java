import java.util.ArrayList;
import java.util.List;

public class ListaTodo {

    private List<Tarefa> tarefas;

    public ListaTodo() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa){
        if(tarefas.stream().anyMatch(t -> t.getIdentificador() == tarefa.getIdentificador())){
            throw new IllegalArgumentException(String.format("Tarefa com identificador %d ja existente na lista", tarefa.getIdentificador()));
        }
        tarefas.add(tarefa);
    }

    public boolean marcarTarefaFeita(int identificador){
        if(tarefas.stream().anyMatch(t -> t.getIdentificador() == identificador)){
            tarefas.stream().filter(t -> t.getIdentificador() == identificador).findFirst().ifPresent(t -> t.setEstahFeita(true));
            return true;
        }            

        return false;
    }

    public boolean desfazerTarefa(int identificador){
        if(tarefas.stream().anyMatch(t -> t.getIdentificador() == identificador)){
            tarefas.stream().filter(t -> t.getIdentificador() == identificador).findFirst().ifPresent(t -> t.setEstahFeita(false));
            return true;
        }            

        return false;
    }

    public void desfazerTodas(){
        tarefas.forEach(t -> t.setEstahFeita(false));
    }

    public void fazerTodas(){
        tarefas.forEach(t -> t.setEstahFeita(true));
    }

    public void listarTarefas(){
        for(int i=0;i<tarefas.size();i++){
            if(tarefas.get(i).isEstahFeita()){
                System.out.println(String.format("[X]  Id: %d - Descricao: %s", i, tarefas.get(i).getDescricao()));
            }else{
                System.out.println(String.format("[ ]  Id: %d - Descricao: %s", i, tarefas.get(i).getDescricao()));
            }
        }
    }

}
