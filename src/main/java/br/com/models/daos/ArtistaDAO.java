package br.com.models.daos;

import java.util.List;

import br.com.models.entities.Artista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ArtistaDAO {
    @PersistenceContext
    private EntityManager em;

    public Artista buscarArtista(Long id) {
        return em.find(Artista.class, id);
    }

    public void criarArtista(Artista artista) {
        em.getTransaction().begin();
        em.persist(artista);
        em.getTransaction().commit();
    }

    public void alterarArtista(Artista artista) {
        em.getTransaction().begin();
        em.merge(artista);
        em.getTransaction().commit();
    }

    public void deletarArtista(Artista artista) {
        em.getTransaction().begin();
        em.remove(artista);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Artista> buscarArtistasByNome(String nome) {
        return em.createNativeQuery("SELECT * FROM pd_artistas WHERE nome ILIKE :nome").setParameter("nome", "%nome%").getResultList();        
    }
}
