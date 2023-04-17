package br.com.models.services;

import java.util.List;

import br.com.models.daos.PlayListDAO;
import br.com.models.dtos.MusicaDTO;
import br.com.models.entities.Musica;
import br.com.models.entities.PlayList;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;

public class PlayListService {
    @Inject
    private PlayListDAO playListDAO;

    @Inject
    private MusicaService musicaService;

    public void adicionarMusicaPlayList(Long musicaId, Long playlistId) throws NoResultException, Exception {
        MusicaDTO musicaDTO = musicaService.buscarMusica(musicaId);
        if (musicaDTO == null) {
            throw new NoResultException();
        }

        PlayList playList = playListDAO.buscarPlayList(playlistId);
        if (playList == null) {
            throw new NoResultException();
        }

        playList.getMusicas().add(new Musica(musicaDTO));

        playListDAO.alterarPlayList(playList);
    }

    public void removeMusicasPlayList(List<Long> musicasIds, Long playlistId) throws NoResultException, Exception {
        List<MusicaDTO> musicasDTO = musicaService.buscarMusicas(musicasIds);
        if (musicasDTO.isEmpty()) {
            throw new NoResultException();
        }

        PlayList playList = playListDAO.buscarPlayList(playlistId);
        if (playList == null) {
            throw new NoResultException();
        }

        musicasDTO.forEach(x -> playList.getMusicas().remove(new Musica(x)));

        playListDAO.alterarPlayList(playList);
    }

    public void alterarPlayList(Long id, PlayList playList) throws NoResultException, Exception {
        PlayList playListOriginal = playListDAO.buscarPlayList(id);

        if (playListOriginal == null) {
            throw new NoResultException();
        }

        if (playList.getNome() != null && !playList.getNome().isEmpty()) {
            playListOriginal.setNome(playList.getNome());
        }

        if (playList.getDescricao() != null && playList.getDescricao().isEmpty()) {
            playListOriginal.setDescricao(playList.getDescricao());
        }

        if (playList.getImagem() != null) {
            playListOriginal.setImagem(playList.getImagem());
        }

        playListDAO.alterarPlayList(playListOriginal);
    }

    public void deletarPlayList(Long id) throws NoResultException, Exception {
        PlayList playList = playListDAO.buscarPlayList(id);

        if (playList == null) {
            throw new NoResultException();
        }

        playListDAO.deletarPlaylist(playList);
    }

    public void criarPlayList(PlayList playList) throws IllegalArgumentException, Exception {
        if (playList.getNome() == null || playList.getNome().isEmpty()) {
            throw new IllegalArgumentException();
        }
        playListDAO.criarPlaylist(playList);
    }
    
}
