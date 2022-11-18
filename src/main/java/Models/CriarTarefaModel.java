package Models;

public class CriarTarefaModel {
    private String title;
    private String description;
    private String deadline;
    private boolean done;

    public CriarTarefaModel(){

        this.title ="Tarefa para teste";
        this.description = "Tarefa criada para testar API";
        this.deadline = "2022-11-16 17:00:00";
        this.done = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public boolean isDone() {
        return done;
    }
}
