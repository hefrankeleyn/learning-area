package com.hef.marco.dao;

import com.hef.marco.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 使用Spring Data Jpa 结束样版式代码
 */
public interface SpitterDao extends JpaRepository<Spitter, Long> {
}
