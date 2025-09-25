package com.victor.jpa.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 255)
    private String nome_perfil;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "perfil")
    private List<Visualizacao> visualizacoes;

    @OneToMany(mappedBy = "perfil")
    private List<Avaliacao> avaliacoes;

    // GETTERS E SETTERS
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome_perfil() { return nome_perfil; }
    public void setNome_perfil(String nome_perfil) { this.nome_perfil = nome_perfil; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public List<Visualizacao> getVisualizacoes() { return visualizacoes; }
    public void setVisualizacoes(List<Visualizacao> visualizacoes) { this.visualizacoes = visualizacoes; }
    public List<Avaliacao> getAvaliacoes() { return avaliacoes; }
    public void setAvaliacoes(List<Avaliacao> avaliacoes) { this.avaliacoes = avaliacoes; }
}