package com.narcielitonlopes.socialbooks.aplicacao;

import com.narcielitonlopes.socialbooks.client.AutoresClient;
import com.narcielitonlopes.socialbooks.client.domain.Autor;

import java.util.List;

public class Aplicacao {

    public static void main(String []args) {

         AutoresClient cliente = new AutoresClient();

         List<Autor> listaAutores = cliente.listar();

         for(Autor autor : listaAutores){
             System.out.println(autor.getNome());
         }

         Autor autor = new Autor();
         autor.setNome("narcieliton lopes");
         autor.setNacionalidade("Brasileiro");


         String localizacao = cliente.salvar(autor);
         System.out.println("URI do autor salvo: " + localizacao);

        Autor autorBuscado = cliente.buscar(localizacao);


          System.out.println("Autor buscado: " + autorBuscado.getNome());

    }
}
