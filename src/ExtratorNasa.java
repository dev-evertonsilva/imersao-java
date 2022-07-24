import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorNasa {

    public List<Conteudo> extraiCouteudos(String json){

       // extrair só os dados que interessam (Titulo, poster, Classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);


        List<Conteudo> conteudos = new ArrayList<>();

        //popular a lista de conteudos

        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
            
        }

        return conteudos;
    }
    
}
