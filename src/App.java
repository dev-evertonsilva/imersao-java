import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
               
          //pegar json http NASA
         //String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope";  
         //ExtratorDeConteudo extrator = new ExtratorNasa();

          //pegar json http IMDB
         String url = "https://api.mocki.io/v2/549a5d8b/MostPopularTVs";
         ExtratorDeConteudo extrator = new ExtratorIMDB();
         
         var http = new ClienteHttp();
         String json = http.buscaDados(url);         

        
        //exibir e manipular os dados       
        List<Conteudo> conteudos = extrator.extraiCouteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++){

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.criar(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();

        }
        




    }
}
