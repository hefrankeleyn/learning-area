package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 使用Spring Data Jpa 结束样版式代码
 */
public interface SpitterDao extends JpaRepository<Spitter, Long> {

    List<Spitter> findSpitterByUsername(String username);

    Spitter findSpitterById(Long id);

}
