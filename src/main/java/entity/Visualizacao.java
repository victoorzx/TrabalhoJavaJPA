package com.victor.jpa.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Visualizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @Column(nullable = false)
    private LocalDateTime data_hora;

    @Column(nullable = false)
    private Integer progresso;

    public Visualizacao() {
    }

    public Visualizacao(Perfil perfil, Video video, LocalDateTime data_hora, Integer progresso) {
        this.perfil = perfil;
        this.video = video;
        this.data_hora = data_hora;
        this.progresso = progresso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public Integer getProgresso() {
        return progresso;
    }

    public void setProgresso(Integer progresso) {
        this.progresso = progresso;
    }
}