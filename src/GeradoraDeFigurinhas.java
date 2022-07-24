import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;






public class GeradoraDeFigurinhas {
    
    public void criar(InputStream inputStream, String nomeArquivo) throws Exception{

        //leitura da imagem
        //InputStream inputStrem = new FileInputStream("entrada/filme.jpg");
        //InputStream inputStrem = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria nova imagem em memoria com tranparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novoAltura = altura + 200;
        BufferedImage novaImage = new BufferedImage(largura, novoAltura, BufferedImage.TRANSLUCENT);


        //copiar a imagem original para nova imagem
        Graphics2D graphics = (Graphics2D) novaImage.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar a fonte da figurinha
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        //escrever uma frase na imagem
        graphics.drawString("TOPZERA", 100, novoAltura - 100);

        //escrever nova imagem em um arquivo
        ImageIO.write(novaImage, "png", new File(nomeArquivo));

    }
   
    
}
