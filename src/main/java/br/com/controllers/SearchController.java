package br.com.controllers;

import java.util.HashMap;
import java.util.List;

import br.com.models.services.SearchService;
import jakarta.inject.Inject;

public class SearchController {    

    @Inject
    private SearchService searchService;

    public HashMap<String, List<?>> realizarBusca(String nome) {
        try {
            return searchService.realizarBusca(nome);
        } catch (IllegalArgumentException ex0) {
            System.out.println("parametro de busca nulo ou invalido");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
        return null;
    }

    

}
