package br.com.models.daos;

import br.com.models.entities.Album;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AlbumDAO {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private ArtistaDAO artistaDAO;

    public Album buscarAlbum(Long id) {
        return em.find(Album.class, id);
    }

    public void criarAlbum(Album album) {
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
    }

    public void alterarAlbum(Album album) {
        em.getTransaction().begin();
        em.merge(album);
        em.getTransaction().commit();
    }

    public void deletarAlbum(Album album) {
        em.getTransaction().begin();
        em.remove(album); 
        em.getTransaction().commit();
    }
}
