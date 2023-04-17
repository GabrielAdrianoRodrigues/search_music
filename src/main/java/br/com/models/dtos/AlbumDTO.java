package br.com.models.dtos;

import java.util.List;

import br.com.models.entities.Album;
import br.com.models.entities.Artista;

public record AlbumDTO(
    Long id,
    String nome,
    String descrica, 
    Integer qtdMusicas, 
    Artista artista, 
    Double duracao, 
    List<Artista> feats) {
    
    public AlbumDTO(Album album) {
        this(album.getId(), album.getNome(), album.getDescricao(), album.getQtdMusicas(), album.getArtista(), album.getDuracao(), album.getFeats());
    }
}