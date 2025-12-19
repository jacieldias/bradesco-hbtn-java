import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Blog {

    private List<Post> posts;

    public Blog() {
        this.posts = new ArrayList<>();
    }

    public void adicionarPostagem(Post post){
        posts.add(post);
    }

    public Set<String> obterTodosAutores(){
        return posts.stream()
        .map(Post::getAutor)
        .sorted()
        .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Map<String, Integer> obterContagemPorCategoria(){
        HashMap<String, Integer> contagemCategorias = new HashMap<>();
        List<String> categorias = posts.stream().map(Post::getCategoria).distinct().sorted().toList();
        categorias.stream().forEach(categoria -> {
            int totalPost = (int) posts.stream()
            .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
            .count();
            contagemCategorias.put(categoria, totalPost);
        });

        return contagemCategorias;
    }
    

}
