package mariapiabaldoin.Giorno_2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Il record con id " + id + " non è stato trovato");
    }
}
