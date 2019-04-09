package com.hef.store.db;

import com.hef.store.domain.Order;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AutoOrderDao extends Neo4jRepository<Order, Long> {
}
