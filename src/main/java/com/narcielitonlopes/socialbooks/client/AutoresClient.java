package com.narcielitonlopes.socialbooks.client;

import com.narcielitonlopes.socialbooks.client.domain.Autor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class AutoresClient {

    private String credencial = "Basic bG9wZXM6czNuaDQ=";

    public List<Autor> listar(){

        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> request = RequestEntity.get(URI.create("http://localhost:8080/autores"))
                .header("Authorization", credencial).build();
        ResponseEntity<Autor[]> response = restTemplate.exchange(request, Autor[].class);
        return Arrays.asList(response.getBody());
    }

    public String salvar(Autor autor){
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Autor> request = RequestEntity
                .post(URI.create("http://localhost:8080/autores"))
                .header("Authorization", credencial)
                .body(autor);
        ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
        return response.getHeaders().getLocation().toString();
    }

    public Autor buscar(String uri){
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> request = RequestEntity.get(URI.create(uri))
                .header("Authorization", credencial)
                .build();
        ResponseEntity<Autor> response = restTemplate.exchange(request, Autor.class);
        return response.getBody();
    }
}
