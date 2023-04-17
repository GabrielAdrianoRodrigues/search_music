package br.com.models.services;

import java.util.List;
import java.util.stream.Collectors;

import br.com.models.daos.ArtistaDAO;
import br.com.models.dtos.ArtistaDTO;
import br.com.models.entities.Album;
import br.com.models.entities.Artista;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;

public class ArtistaService {

    @Inject
    private ArtistaDAO artistaDAO;

    public void criarArtista(Artista artista) throws IllegalArgumentException, Exception {
        if(artista.getNome() == null || artista.getNome().isEmpty() || artista.getNacionalidade() == null || artista.getNacionalidade().isEmpty()) {
            throw new IllegalArgumentException();
        }
        artistaDAO.criarArtista(artista);
    }

    public void alterarArtista(Long id, Artista artista) throws NoResultException, Exception {
        Artista artistaOriginal = artistaDAO.buscarArtista(id);

        if (artistaOriginal == null) {
            throw new NoResultException();
        }

        if (artista.getNome() != null && !artista.getNome().isEmpty()) {
            artistaOriginal.setNome(artista.getNome());
        }

        if (artista.getDescricao() != null && !artista.getDescricao().isEmpty()) {
            artistaOriginal.setDescricao(artista.getDescricao());
        }

        if (artista.getNacionalidade() != null && !artista.getNacionalidade().isEmpty()) {
            artistaOriginal.setNacionalidade(artista.getNacionalidade());
        }
        
        artistaDAO.alterarArtista(artistaOriginal);
    }

    public void deletarArtista(Long id) throws NoResultException, Exception {
        Artista artista = artistaDAO.buscarArtista(id);

        if (artista == null) {
            throw new NoResultException();
        }  

        artistaDAO.deletarArtista(artista);
    }

    public void adicionarAlbum(Album album) throws NoResultException, Exception {
        Artista artista = artistaDAO.buscarArtista(album.getArtista().getId());

        if (artista == null) {
            throw new NoResultException();
        }

        artista.getAlbuns().add(album);

        artistaDAO.alterarArtista(artista);
    }

    public void removerAlbum(Album album) throws NoResultException, Exception {
        Artista artista = artistaDAO.buscarArtista(album.getArtista().getId());

        if (artista == null) {
            throw new NoResultException();
        } 

        artista.getAlbuns().remove(album);

        artistaDAO.alterarArtista(artista);
    }

    public List<ArtistaDTO> buscarArtistasByNome(String nome) {
        return artistaDAO.buscarArtistasByNome(nome).stream().map(ArtistaDTO::new).collect(Collectors.toList());
    }
    
}
