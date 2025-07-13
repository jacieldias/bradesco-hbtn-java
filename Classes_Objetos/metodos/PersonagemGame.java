public class PersonagemGame{
    private int saudeAtual;
    private String nome;

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void tomarDano(int quantidadeDeDano){
        if(this.saudeAtual > quantidadeDeDano){
            this.saudeAtual -= Math.abs(quantidadeDeDano);
        }else{
            this.saudeAtual = 0;
        }
    }

    public void receberCura(int quantidadeDeCura){
        if(this.saudeAtual + Math.abs(quantidadeDeCura) > 100){
            this.saudeAtual = 100;
        }else{
            this.saudeAtual += Math.abs(quantidadeDeCura);
        }
    }
}