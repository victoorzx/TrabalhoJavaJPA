package com.victor.jpa.repository;

import com.victor.jpa.entity.Video;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {

    // Q1: Buscar vídeos pelo título com ordenação
    List<Video> findByTituloContainingIgnoreCaseOrderByTituloAsc(String titulo);

    // Q2: Todos os vídeos de uma categoria ordenado pelo título
    List<Video> findByCategoriaNomeIgnoreCaseOrderByTituloAsc(String nomeCategoria);

    // Q3: Os top 10 vídeos mais bem avaliados
    @Query("SELECT v FROM Video v JOIN v.avaliacoes a GROUP BY v.id ORDER BY AVG(a.nota) DESC")
    List<Video> findTopRatedVideos(Pageable pageable);

    // Q4: Os top 10 vídeos mais assistidos
    @Query("SELECT v FROM Video v JOIN v.visualizacoes vz GROUP BY v.id ORDER BY COUNT(v.id) DESC")
    List<Video> findTopWatchedVideos(Pageable pageable);
}