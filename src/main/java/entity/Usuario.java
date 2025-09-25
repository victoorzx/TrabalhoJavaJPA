package com.victor.jpa.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private LocalDateTime data_cadastro;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Perfil> perfis = new ArrayList<>();

    // GETTERS E SETTERS
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public LocalDateTime getData_cadastro() { return data_cadastro; }
    public void setData_cadastro(LocalDateTime data_cadastro) { this.data_cadastro = data_cadastro; }
    public List<Perfil> getPerfis() { return perfis; }
    public void setPerfis(List<Perfil> perfis) { this.perfis = perfis; }
}