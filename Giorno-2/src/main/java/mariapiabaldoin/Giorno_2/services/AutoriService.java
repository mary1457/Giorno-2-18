package mariapiabaldoin.Giorno_2.services;

import mariapiabaldoin.Giorno_2.entities.Autore;
import mariapiabaldoin.Giorno_2.exceptions.NotFoundException;
import mariapiabaldoin.Giorno_2.payloads.NewAutorePayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoriService {
    private List<Autore> autoriList = new ArrayList<>();

    public List<Autore> findAll() {
        return this.autoriList;
    }

    public Autore findById(int autoreId) {
        Autore found = null;
        for (Autore autore : this.autoriList) {
            if (autore.getId() == autoreId) found = autore;
        }
        if (found == null) throw new NotFoundException(autoreId);
        return found;
    }

    public Autore saveAutore(NewAutorePayload body) {
        Random rndm = new Random();
        Autore newAutore = new Autore(body.getNome(), body.getCognome(), body.getEmail(), body.getDataNascita());


        newAutore.setId(rndm.nextInt(1, 10000));
        String avatarUrl = "https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome();
        newAutore.setAvatar(avatarUrl);
        this.autoriList.add(newAutore);
        return newAutore;
    }

    public Autore findByIdAndUpdate(int autoreId, NewAutorePayload body) {
        Autore found = null;
        for (Autore autore : this.autoriList) {
            if (autore.getId() == autoreId) {
                found = autore;
                found.setNome(body.getNome());
                found.setCognome(body.getCognome());
                found.setEmail(body.getEmail());
                found.setDataNascita(body.getDataNascita());
                String avatarUrl = "https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome();
                found.setAvatar(avatarUrl);
            }
        }
        if (found == null) throw new NotFoundException(autoreId);
        return found;
    }

    public void findByIdAndDelete(int autoreId) {
        Autore found = null;
        for (Autore autore : this.autoriList) {
            if (autore.getId() == autoreId) found = autore;
        }
        if (found == null) throw new NotFoundException(autoreId);
        this.autoriList.remove(found);
    }
}

