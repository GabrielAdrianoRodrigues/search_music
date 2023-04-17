package br.com.models.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class MusicaDAO {
    @PersistenceContext
    private EntityManager em;
}
