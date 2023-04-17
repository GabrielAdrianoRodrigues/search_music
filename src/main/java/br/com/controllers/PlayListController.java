package br.com.controllers;

import java.util.List;

import br.com.models.entities.PlayList;
import br.com.models.services.PlayListService;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;

public class PlayListController {

    @Inject
    private PlayListService playListService;

    public void criarPlayList(PlayList playList) {
        try {
            playListService.criarPlayList(playList);
        } catch (IllegalArgumentException ex0) {
            System.out.println("parametros invalidos ou nulos");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }

    public void deletarPlayList(Long id) {
        try {
            playListService.deletarPlayList(id);
        } catch (NoResultException ex0) {
            System.out.println("playlist não cadastrada");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }

    public void removeMusicasPlayList(List<Long> musicasIds, Long playListId) {
        try {
            playListService.removeMusicasPlayList(musicasIds, playListId);
        } catch (NoResultException ex0) {
            System.out.println("musica ou playlist não cadastrada");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }

    public void adicionarMusicaPlayList(Long musicaId, Long playListId) {
        try {
            playListService.adicionarMusicaPlayList(musicaId, playListId);
        } catch (NoResultException ex0) {
            System.out.println("musica ou playlist não cadastrada");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }

}
