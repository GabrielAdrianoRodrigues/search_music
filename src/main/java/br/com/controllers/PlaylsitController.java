package br.com.controllers;

import java.util.List;

import br.com.models.entities.Album;
import br.com.models.entities.Musica;
import br.com.models.entities.PlayList;
import br.com.models.services.PlayListService;
import jakarta.inject.Inject;

public class PlaylsitController {

    private PlayList playListAtual;
    private List<Musica> selectedMusics;

    @Inject
    private PlayListService playListService;

    public void salvarPlayList() {
        playListService.salvarPlayList(playListAtual);
    }

    public void removePlayList() {
        playListService.removePlayList(playListAtual);
    }

    public void removeMusicasPlayList() {
        playListService.removeMusicasPlayList(selectedMusics);
    }

}
