package br.com.pedro.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.models.daos.ArtistaDAO;
import br.com.models.entities.Artista;
import br.com.models.services.ArtistaService;
import jakarta.persistence.NoResultException;

@RunWith(MockitoJUnitRunner.class)
public class ArtistaServiceTest {
    
    @InjectMocks
    private ArtistaService artistaService;

    @Mock
    private ArtistaDAO artistaDAOMock;

    @Rule
    private ExpectedException expected = ExpectedException.none();

    private Artista artistaDefault;

    @Before
    public void init() {
        artistaDefault =  new Artista(null, "Amarildo", "É muito gente fina", "Angolano", null)
    }

    @Test
    void criaArtistaNomeNulo() throws IllegalArgumentException, Exception {
        expected.expect(IllegalArgumentException.class);
        artistaDefault.setNome(null);
        artistaService.criarArtista(artistaDefault);
    }

    @Test
    void criaArtistaNomeVazio() throws IllegalArgumentException, Exception {
        expected.expect(IllegalArgumentException.class);
        artistaDefault.setNome("");
        artistaService.criarArtista(artistaDefault);
    }

    @Test
    void criaArtistaNacionalidadeNula() throws IllegalArgumentException, Exception {
        expected.expect(IllegalArgumentException.class);
        artistaDefault.setNacionalidade(null);
        artistaService.criarArtista(artistaDefault);
    }

    @Test
    void criaArtista() throws IllegalArgumentException, Exception {
        artistaService.criarArtista(artistaDefault);
        Mockito.verify(artistaDAOMock).criarArtista(artistaDefault);
    }

    @Test
    void deletaArtista() throws IllegalArgumentException, Exception {
        Mockito.when(artistaDAOMock.buscarArtista(98l)).thenReturn(artistaDefault);
        artistaService.deletarArtista(98l);
        Mockito.verify(artistaDAOMock).alterarArtista(artistaDefault);
    }

    @Test
    void deletaArtistaNaoEncontrado() throws IllegalArgumentException, Exception {
        expected.expect(NoResultException.class);
        Mockito.when(artistaDAOMock.buscarArtista(98l)).thenReturn(null);
        artistaService.deletarArtista(98l);
    }

}
