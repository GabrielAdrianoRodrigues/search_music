package br.com.models.services;

import java.util.HashMap;
import java.util.List;

import jakarta.inject.Inject;

public class SearchService {
    @Inject
    private MusicaService musicaService;

    @Inject
    private ArtistaService artistaService;

    @Inject
    private AlbumService albumService;

    public HashMap<String, List<?>> realizarBusca(String nome) throws IllegalArgumentException, Exception {
        if(nome == null || nome.isEmpty()) {
            throw new IllegalAccessException();
        }

        HashMap<String, List<?>> result = new HashMap<String, List<?>>();
        
        result.put("musicas", musicaService.buscarMusicasByNome(nome));
        result.put("artistas", artistaService.buscarArtistasByNome(nome));
        result.put("albuns", albumService.buscarAlbunsByNome(nome));
        
        return result;
    }
}
