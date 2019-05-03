package com.hef.spittr.dao;

import com.hef.spittr.domain.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpittleDao extends JpaRepository<Spittle, Long> {

    Spittle findSpittleById(long id);
}
