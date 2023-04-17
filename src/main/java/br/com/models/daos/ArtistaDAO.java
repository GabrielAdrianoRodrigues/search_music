package br.com.models.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ArtistaDAO {
    @PersistenceContext
    private EntityManager em;
}
