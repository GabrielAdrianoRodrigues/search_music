package br.com.models.daos;

import br.com.models.entities.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AlbumDAO {

    @PersistenceContext
    private EntityManager em;

    public Album getAlbumById(Long idAlbum) {
        return em.find(Album.class, idAlbum);
    }
}
