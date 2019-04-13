package con.hef.spittr.dao;

import con.hef.spittr.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 使用Spring Data jpa 终结愚蠢的样版式代码
 */
public interface SpitterDao extends JpaRepository<Spitter, Long> {
}
