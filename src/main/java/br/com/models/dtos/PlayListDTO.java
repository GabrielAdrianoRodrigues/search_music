package br.com.models.dtos;

import java.util.List;

import br.com.models.entities.Musica;
import br.com.models.entities.PlayList;

public record PlayListDTO(
    Long id,
    String nome,
    byte[] imagem,
    String descricao,
    List<Musica> musicas
) {
    public PlayListDTO(PlayList playList) {
        this(playList.getId(), playList.getNome(), playList.getImagem(), playList.getDescricao(), playList.getMusicas());
    }
}
