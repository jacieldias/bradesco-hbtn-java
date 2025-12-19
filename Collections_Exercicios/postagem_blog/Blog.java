import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Blog {

    private List<Post> posts;

    public Blog() {
        this.posts = new ArrayList<>();
    }

    public void adicionarPostagem(Post post){
        Optional<Post> optional = posts.stream()
        .filter(p -> p.getAutor().equals(post.getAutor()) && p.getTitulo().equalsIgnoreCase(post.getTitulo()))
        .findFirst();

        if(optional.isPresent()){
            throw new IllegalArgumentException("Postagem jah existente");
        }

        posts.add(post);
    }

    public Set<Autor> obterTodosAutores(){
        return posts.stream()
        .map(Post::getAutor)
        .sorted()
        .collect(Collectors.toCollection(TreeSet::new));
    }

    public Map<Categorias, Integer> obterContagemPorCategoria(){
        Map<Categorias, Integer> contagemCategorias = new TreeMap<>();
        List<Categorias> categorias = posts.stream().map(Post::getCategoria).distinct().sorted().toList();
        categorias.stream().forEach(categoria -> {
            int totalPost = (int) posts.stream()
            .filter(p -> p.getCategoria().equals(categoria))
            .count();
            contagemCategorias.put(categoria, totalPost);
        });

        return contagemCategorias;
    }

    public Set<Post> obterPostsPorAutor(Autor autor){
        return posts.stream()
        .filter(p -> p.getAutor().equals(autor))
        .sorted()
        .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria){
        return posts.stream()
        .filter(p -> p.getCategoria().equals(categoria))
        .sorted()
        .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias(){
        Map<Categorias, Set<Post>> contagemCategorias = new LinkedHashMap();
        for(Categorias categoria : Categorias.values()){
            Set<Post> postsCategoria = posts.stream()
            .filter(p -> p.getCategoria().equals(categoria))
            .sorted()
            .collect(Collectors.toCollection(LinkedHashSet::new));
            contagemCategorias.put(categoria, postsCategoria);
        }
        return contagemCategorias;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor(){
        Map<Autor, Set<Post>> postsPorAutor = posts.stream()
            .sorted()
            .collect(Collectors.groupingBy(
                Post::getAutor,
                Collectors.toCollection(LinkedHashSet::new)
            ));
        
        return postsPorAutor;  
    }
    

}
