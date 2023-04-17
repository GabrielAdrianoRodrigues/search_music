package br.com.controllers;

import br.com.models.entities.Musica;
import br.com.models.services.PlayListService;
import br.com.models.services.SearchService;
import jakarta.inject.Inject;

public class SearchController {
    
    private Musica selectedMusic;
    private String fieldSearch;
    
    @Inject
    private PlayListService playListService;

    @Inject
    private SearchService searchService;


    public void adicionarMusicaPlayList() {
        playListService.adicionarMusicaPlayList(selectedMusic);
    }

    

}
