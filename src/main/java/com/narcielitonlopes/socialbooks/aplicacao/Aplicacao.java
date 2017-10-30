package com.narcielitonlopes.socialbooks.aplicacao;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by narcieliton on 30/10/17.
 */
public class Aplicacao {

    public static void main(String []args) {

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> request = RequestEntity.get(URI.create("http://localhost:8080/autores"))
                .build();

        ResponseEntity<Autor[]> response = restTemplate.exchange(request, Autor[].class);

        for (Autor autor : response.getBody()){
            System.out.println(autor.getNome());
        }

    }
}
