package br.com.models.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pd_playlist")
@AllArgsConstructor@NoArgsConstructor
public class PlayList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;
    
    @Lob
    @Column(name = "imagem")
    private byte[] imagem;

    @Column(name = "descricao")
    private String descricao;

    @JoinTable(name="playlist_musica",
			   joinColumns={ @JoinColumn(name = "id_playlist") },
			   inverseJoinColumns={ @JoinColumn(name="id_musica") }
    )					
    private List<Musica> musicas;

}
