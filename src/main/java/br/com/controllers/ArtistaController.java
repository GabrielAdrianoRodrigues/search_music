package br.com.controllers;

import br.com.models.entities.Artista;
import br.com.models.services.ArtistaService;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;

public class ArtistaController {
    @Inject
    private ArtistaService artistaService;

    public void criarArtista(Artista artista) {
        try {
            artistaService.criarArtista(artista);
        } catch (IllegalArgumentException ex0) {
            System.out.println("parametros nulos ou invalidos");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }

    public void alterarArtista(Long id, Artista artista) {
        try {
            artistaService.alterarArtista(id, artista);
        } catch (NoResultException ex0) {
            System.out.println("artista não cadastrado");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }
    
    public void deletarArtista(Long id) {
        try {
            artistaService.deletarArtista(id);
        } catch (NoResultException ex0) {
            System.out.println("artista não cadastrado");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }
}
