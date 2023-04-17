package br.com.controllers;

import br.com.models.entities.Album;
import br.com.models.services.AlbumService;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;

public class AlbumController {
    @Inject
    private AlbumService albumService;

    public void criarAlbum(Album album) {
        try {
            albumService.criarAlbum(album);
        } catch (IllegalArgumentException ex0) {
            System.out.println("parametros inválidos ou nulos");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }

    public void alterarAlbum(Long id, Album album) {
        try {
            albumService.alterarAlbum(id, album);
        } catch (NoResultException ex0) {
            System.out.println("album ou artista não casdastrado");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }

    public void deletarAlbum(long id) {
        try {
            albumService.deletarAlbum(id);
        } catch (NoResultException ex0) {
            System.out.println("album ou artista não casdastrado");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }
}
