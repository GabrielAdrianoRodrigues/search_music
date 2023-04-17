package br.com.models.services;

import java.util.List;

import br.com.models.daos.AlbumDAO;
import br.com.models.entities.Album;
import br.com.models.entities.Musica;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;

public class AlbumService {
    @Inject
    private AlbumDAO albumDAO;

    @Inject
    private ArtistaService artistaService;

    public void criarAlbum(Album album) throws IllegalArgumentException, Exception {
        if (album.getAno() == null || album.getArtista() == null || album.getNome() == null || album.getNome().isEmpty()) {
            throw new IllegalArgumentException();
        } 

        albumDAO.criarAlbum(album);
        artistaService.adicionarAlbum(album);
    }

    public void alterarAlbum(Long id, Album album) throws NoResultException, Exception{
        Album albumOriginal = albumDAO.buscarAlbum(id);

        if(albumOriginal == null) {
            throw new NoResultException();
        }

        if(album.getNome() != null && !album.getNome().isEmpty()) {
            albumOriginal.setNome(album.getNome());
        }

        if (album.getAno() != null && album.getAno() > 0) {
            albumOriginal.setAno(album.getAno());
        }

        if (album.getDescricao() != null && !album.getDescricao().isEmpty()) {
            albumOriginal.setDescricao(album.getDescricao());
        }

        albumDAO.alterarAlbum(albumOriginal);
    }

    public void deletarAlbum(long id) throws NoResultException, Exception {
        Album album = albumDAO.buscarAlbum(id);

        if(album == null) {
            throw new NoResultException();
        }

        albumDAO.deletarAlbum(album);
        artistaService.removerAlbum(album);
    }

    public void adicionarMusica(Musica musica) throws NoResultException, Exception {
        Album album = albumDAO.buscarAlbum(musica.getAlbum().getId());

        if (album == null) {
            throw new NoResultException();
        }

        album.setDuracao(album.getDuracao() + musica.getDuracao());
        album.setQtdMusicas(album.getQtdMusicas() + 1);
        albumDAO.alterarAlbum(album);
    }

    public void removerMusica(Musica musica) throws NoResultException, Exception {
        Album album = albumDAO.buscarAlbum(musica.getAlbum().getId());

        if (album == null) {
            throw new NoResultException();
        }

        album.setDuracao(album.getDuracao() - musica.getDuracao());
        album.setQtdMusicas(album.getQtdMusicas() - 1);
        albumDAO.alterarAlbum(album);
    }

    public List<Album> buscarAlbunsByNome(String nome) {
        return albumDAO.buscarAlbunsByNome(nome);
    }
    
}
