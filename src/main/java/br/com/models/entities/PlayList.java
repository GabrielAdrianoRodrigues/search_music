package br.com.models.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(fetch = FetchType.LAZY)		
    private List<Musica> musicas;

}
