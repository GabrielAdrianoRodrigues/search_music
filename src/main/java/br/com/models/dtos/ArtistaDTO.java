package br.com.models.dtos;

import java.util.List;

import br.com.models.entities.Album;
import br.com.models.entities.Artista;

public record ArtistaDTO(
    Long id,
    String nome,
    String descricao,
    String nacionalidade,
    List<Album> albuns
) {
    public ArtistaDTO(Artista artista) {
        this(artista.getId(), artista.getNome(), artista.getDescricao(), artista.getNacionalidade(), artista.getAlbuns());
    }
}
