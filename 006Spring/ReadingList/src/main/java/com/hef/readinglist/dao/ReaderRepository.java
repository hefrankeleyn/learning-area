package com.hef.readinglist.dao;

import com.hef.readinglist.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, String> {

    Reader findReaderByUsername(String username);
}
