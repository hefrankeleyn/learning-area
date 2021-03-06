package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 使用Spring Data Jpa 结束样版式代码
 */
public interface SpitterDao extends JpaRepository<Spitter, Long> {
}
