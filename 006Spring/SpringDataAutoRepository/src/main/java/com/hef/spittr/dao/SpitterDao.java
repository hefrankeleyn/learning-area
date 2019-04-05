package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 使用 Spring DataJPA终结 愚蠢的样版行为
 */
public interface SpitterDao extends JpaRepository<Spitter, Long> {
}
