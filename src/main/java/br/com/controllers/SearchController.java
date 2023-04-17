package br.com.controllers;

import br.com.models.services.SearchService;
import jakarta.inject.Inject;

public class SearchController {    

    @Inject
    private SearchService searchService;


    public void realizarBusca(String nome) {
        searchService.realizarBusca(nome);
    }

    

}
