package br.com.models.daos;

import br.com.models.entities.Musica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class MusicaDAO {
    @PersistenceContext
    private EntityManager em;

    public Musica getMusicaById(Long id) {
        return em.find(Musica.class, id);
    }
}
