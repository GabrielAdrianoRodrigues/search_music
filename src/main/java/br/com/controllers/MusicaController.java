package br.com.controllers;

import br.com.models.entities.Musica;
import br.com.models.services.MusicaService;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;

public class MusicaController {
    @Inject
    private MusicaService musicaService;

    public void criarMusica(Musica musica) {
        try {
            musicaService.criarMusica(musica);
        } catch (IllegalArgumentException ex0) {
            System.out.println("parametros nulos ou invalidos");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }

    public void alterarMusica(Long id, Musica musica) {
        try {
            musicaService.alterarMusica(id, musica);
        } catch (NoResultException ex0) {
            System.out.println("musica ou album não registrado");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }

    public void deletarMusica(Long id) {
        try {
            musicaService.deletarMusica(id);
        } catch (NoResultException ex0) {
            System.out.println("musica ou album não registrado");
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }
}
