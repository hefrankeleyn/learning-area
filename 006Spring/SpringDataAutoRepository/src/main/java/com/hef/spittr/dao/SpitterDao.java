package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 使用 Spring DataJPA终结 愚蠢的样版行为
 */
public interface SpitterDao extends JpaRepository<Spitter, Long>, SpitterSweeper {


    /**
     * 定义查询方法
     * 使用一组小型的领域特定语言( domain-specific language, DSL)
     * Spring Data JPA 将创建这个方法的实现
     * @param username
     * @return
     */
    Spitter findByUsername(String username);

    /**
     * 声明自定义查询
     * 仍然不需要编写该方法的实现
     *
     * 仅限于单个JPA查询
     * @return
     */
    @Query("select s from Spitter s where s.email like '%gmail.com'")
    List<Spitter> findAllGmailSpitters();



}
