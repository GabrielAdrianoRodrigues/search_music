package br.com.models.daos;

import br.com.models.entities.PlayList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PlayListDAO {
    @PersistenceContext
    private EntityManager em;

    public PlayList buscarPlayList(Long id) {
        return em.find(PlayList.class, id);
    }

    public void alterarPlayList(PlayList playList) {
        em.getTransaction().begin();
        em.merge(playList);
        em.getTransaction().commit();
    }

    public void deletarPlaylist(PlayList playList) {
        em.getTransaction().begin();
        em.remove(playList);
        em.getTransaction().commit();
    }

    public void criarPlaylist(PlayList playList) {
        em.getTransaction().begin();
        em.persist(playList);
        em.getTransaction().commit();
    }
    
}
