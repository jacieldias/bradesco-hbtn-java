public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome){
        boolean encontrado = false;
        int esquerda = 0;
        int direita = nomes.length-1;

        System.out.println("Procurando nome: \""+ nome+"\"");
        while(esquerda <= direita){
            int meio = (esquerda + direita)/2;
            int result = nomes[meio].compareToIgnoreCase(nome);
            System.out.println("Passando pelo indice: "+meio);
            if(result == 0){
                System.out.println(String.format("Nome %s encontrado na posição %d", nome, meio));
                encontrado = true;
                break;
            }else if(result < 0){
                esquerda = meio + 1;
            }else{
                direita = meio -1;
            }
        }

        if(!encontrado) throw new IllegalArgumentException(String.format("O nome %s não se encontra no array de nomes", nome));
    }
}