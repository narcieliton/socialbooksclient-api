package com.narcielitonlopes.socialbooks.client;

import com.narcielitonlopes.socialbooks.client.domain.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class AutoresClient {

    private RestTemplate restTemplate;

    private String URI_BASE;

    private String URN_BASE = "/autores";

    private String credencial;


    public AutoresClient(String url, String usuario, String senha){
        restTemplate = new RestTemplate();

        URI_BASE = url.concat(URN_BASE);

        String credencialAux = usuario + ":" + senha;

//        credencial = "Basic " + Base64.getEncoder().encodeToString(credencialAux.getBytes());
//
    }

    public AutoresClient(){}

    public List<Autor> listar(){

        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> request = RequestEntity.get(URI.create("http://localhost:8080/autores"))
                .header("Authorization", "Basic bG9wZXM6czNuaDQ=").build();
        ResponseEntity<Autor[]> response = restTemplate.exchange(request, Autor[].class);
        return Arrays.asList(response.getBody());
    }

    public String salvar(Autor autor){
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Autor> request = RequestEntity
                .post(URI.create("http://localhost:8080/autores"))
                .header("Authorization", "Basic bG9wZXM6czNuaDQ=")
                .body(autor);
        ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
        return response.getHeaders().getLocation().toString();
    }

    public Autor buscar(String uri){
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> request = RequestEntity.get(URI.create(uri))
                .header("Authorization", "Basic bG9wZXM6czNuaDQ=")
                .build();
        ResponseEntity<Autor> response = restTemplate.exchange(request, Autor.class);
        return response.getBody();
    }



}
