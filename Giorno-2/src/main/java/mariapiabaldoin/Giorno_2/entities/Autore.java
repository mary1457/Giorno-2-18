package mariapiabaldoin.Giorno_2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Autore {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar;


    public Autore(String nome, String cognome, String email, LocalDate dataNascita) {

        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
    }
}