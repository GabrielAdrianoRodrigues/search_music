package br.com.models.dtos;

import java.util.List;

import br.com.models.entities.Album;
import br.com.models.entities.Artista;
import br.com.models.entities.Musica;

public record MusicaDTO(
    Long id,
    String nome,
    Artista artista,
    List<Artista> feats,
    Double duracao,
    String estiloMusical,
    Album album
) {
    public MusicaDTO(Musica musica) {
        this(musica.getId(), musica.getNome(), musica.getArtista(), musica.getFeats(), musica.getDuracao(), musica.getEstiloMusical(), musica.getAlbum());
    }
}
