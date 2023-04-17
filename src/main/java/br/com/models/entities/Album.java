package br.com.models.entities;

import java.util.List;

import jakarta.persistence.Column;
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
@Table(name = "pd_album")
@NoArgsConstructor@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "descrica", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "qtd_musica")
    private Integer qtdMusicas;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artista artista;

    @Column(name = "duracao")
    private Long duracao;

    @Column(name = "ano")
    private Integer ano;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Artista> feats;
}
