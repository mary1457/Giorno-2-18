package mariapiabaldoin.Giorno_2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BlogPost {
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoLettura;

    public BlogPost(String categoria, String titolo, String contenuto, int tempoLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoLettura = tempoLettura;
    }
}