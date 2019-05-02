package com.hef.marco.dao;

import com.hef.marco.domain.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpittleDao extends JpaRepository<Spittle, Long> {

    Spittle findSpittleById(long id);
}
