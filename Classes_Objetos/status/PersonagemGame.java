public class PersonagemGame{
    private int saudeAtual;
    private String nome;
    private String status;

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
        if(saudeAtual > 0){
            this.status = "vivo";
        }else{
            this.status = "morto";
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDeDano){
        if(this.saudeAtual > quantidadeDeDano){
            setSaudeAtual(getSaudeAtual() - Math.abs(quantidadeDeDano));
        }else{
            setSaudeAtual(0);
        }
    }

    public void receberCura(int quantidadeDeCura){
        if(this.saudeAtual + Math.abs(quantidadeDeCura) > 100){
            setSaudeAtual(100);
        }else{
            setSaudeAtual(getSaudeAtual() + Math.abs(quantidadeDeCura);
        }
    }
}