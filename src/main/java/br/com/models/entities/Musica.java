package br.com.models.entities;

import java.util.List;

import br.com.models.dtos.MusicaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pd_musicas")
@AllArgsConstructor@NoArgsConstructor
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artista artista;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Artista> feats;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    @Column(name = "duracao")
    private Double duracao;

    @Column(name = "estilo_musical")
    private String estiloMusical;

    public Musica(MusicaDTO dto) {
        this.id = dto.id();
        this.nome = dto.nome();
        this.artista = dto.artista();
        this.feats = dto.feats();
        this.album = dto.album();
        this.duracao = dto.duracao();
        this.estiloMusical = dto.estiloMusical();
    }
}
