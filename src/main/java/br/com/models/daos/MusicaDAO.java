package br.com.models.daos;

import java.util.List;

import br.com.models.entities.Musica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class MusicaDAO {
    @PersistenceContext
    private EntityManager em;

    public Musica buscarMusica(Long id) {
        return em.find(Musica.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Musica> buscarMusicas(List<Long> ids) {
        return em.createNativeQuery("SELECT * FROM pd_musicas WHERE id IN :ids").setParameter("ids", ids).getResultList();        
    }

    @SuppressWarnings("unchecked")
    public List<Musica> buscarMusicasByNome(String nome) {
        return em.createNativeQuery("SELECT * FROM pd_musicas WHERE nome ILIKE :nome").setParameter("nome", "%nome%").getResultList();        
    }

    public void criarAlbum(Musica musica) {
        em.getTransaction().begin();
        em.persist(musica);
        em.getTransaction();

    }

    public void alterarMusica(Musica musica) {
        em.getTransaction().begin();
        em.merge(musica);
        em.getTransaction().commit();
    }

    public void deletarMusica(Musica musica) {
        em.getTransaction().begin();
        em.remove(musica);
        em.getTransaction();
    }
}
