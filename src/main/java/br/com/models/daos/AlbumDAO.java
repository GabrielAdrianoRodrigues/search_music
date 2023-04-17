package br.com.models.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AlbumDAO {
    @PersistenceContext
    private EntityManager em;
}
