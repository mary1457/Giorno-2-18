package mariapiabaldoin.Giorno_2.controllers;


import mariapiabaldoin.Giorno_2.entities.Autore;
import mariapiabaldoin.Giorno_2.payloads.NewAutorePayload;
import mariapiabaldoin.Giorno_2.services.AutoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoriController {
    @Autowired
    private AutoriService autoriService;


    @GetMapping
    public List<Autore> getAutore() {
        return this.autoriService.findAll();
    }


    @GetMapping("/{autoreId}")
    public Autore findAutoreById(@PathVariable int autoreId) {
        return this.autoriService.findById(autoreId);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAutore(@RequestBody NewAutorePayload body) {
        return this.autoriService.saveAutore(body);
    }


    @PutMapping("/{autoreId}")
    public Autore findAutoreByIdAndUpdate(@PathVariable int autoreId, @RequestBody NewAutorePayload body) {
        return this.autoriService.findByIdAndUpdate(autoreId, body);
    }


    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAutoreByIdAndDelete(@PathVariable int autoreId) {
        this.autoriService.findByIdAndDelete(autoreId);
    }


}
