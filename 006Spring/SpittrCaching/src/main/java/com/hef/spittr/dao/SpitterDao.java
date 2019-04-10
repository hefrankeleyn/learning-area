package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 使用 spring data 结束愚蠢的 模板
 */
public interface SpitterDao extends JpaRepository<Spitter, Long> {
}
