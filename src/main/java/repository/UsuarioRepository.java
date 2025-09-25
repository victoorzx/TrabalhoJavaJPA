package com.victor.jpa.repository;

import com.victor.jpa.entity.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Q5: O usuário que mais assistiu vídeos
    @Query("SELECT p.usuario FROM Visualizacao v JOIN v.perfil p GROUP BY p.usuario ORDER BY COUNT(p.usuario) DESC")
    List<Usuario> findTopWatcher(Pageable pageable);
}