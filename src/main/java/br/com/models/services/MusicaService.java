package br.com.models.services;

import java.util.List;

import br.com.models.daos.MusicaDAO;
import br.com.models.entities.Musica;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;

public class MusicaService {

    @Inject
    private MusicaDAO musicaDAO;

    @Inject
    private AlbumService albumService;

    public Musica buscarMusica(Long id) {
        return musicaDAO.buscarMusica(id);
    }

    public List<Musica> buscarMusicas(List<Long> ids) {
        return musicaDAO.buscarMusicas(ids);
    }

    public void criarMusica(Musica musica) throws IllegalArgumentException, Exception {
        if (musica.getAlbum() == null || musica.getArtista() == null || musica.getNome() == null || musica.getNome().isEmpty() || musica.getDuracao() == null || musica.getDuracao() < 0 || musica.getEstiloMusical() == null || musica.getEstiloMusical().isEmpty()) {
            throw new IllegalAccessException();
        }

        musicaDAO.criarAlbum(musica);
        albumService.adicionarMusica(musica);
    }

    public void alterarMusica(Long id, Musica musica) throws NoResultException, Exception{
        Musica musicaOriginal = musicaDAO.buscarMusica(id);

        if (musicaOriginal == null) {
            throw new NoResultException();
        }

        if(musica.getNome() != null && !musica.getNome().isEmpty()) {
            musicaOriginal.setNome(musica.getNome());
        }

        musicaDAO.alterarMusica(musicaOriginal);
    }

    public void deletarMusica(Long id) throws NoResultException, Exception {
        Musica musica = musicaDAO.buscarMusica(id);

        if (musica == null) {
            throw new NoResultException();
        }
        musicaDAO.deletarMusica(musica);
        albumService.removerMusica(musica);
    }
    
}
