package com.hef.readinglist;

import com.hef.readinglist.dao.ReaderRepository;
import com.hef.readinglist.domain.Reader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Date 2019-05-08
 * @Author lifei
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReaderDaoTest {

    @Autowired
    private ReaderRepository readerRepository;

    @Test
    public void saveReader(){
        BCryptPasswordEncoder en = new BCryptPasswordEncoder();
        Reader reader = new Reader();
        reader.setUsername("user");
        reader.setPassword(en.encode("password"));
        reader.setFullname("xiao Ming");
//        readerRepository.delete(reader);
        readerRepository.save(reader);
    }
}
