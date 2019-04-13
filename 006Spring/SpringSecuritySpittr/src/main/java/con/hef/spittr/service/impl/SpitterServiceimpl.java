package con.hef.spittr.service.impl;

import con.hef.spittr.dao.SpitterDao;
import con.hef.spittr.domain.Spitter;
import con.hef.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.logging.Logger;

@Component
public class SpitterServiceimpl implements SpitterService {

    private static final Logger logger = Logger.getLogger("SpitterServiceimpl");

    @Autowired
    private SpitterDao spitterDao;

    @Override
    @Transactional
    public Spitter findSpitterById(Long id) {
        try {
            Spitter spitter = spitterDao.getOne(id);;
            return spitter;
        }catch (Exception e){
            logger.info("entity not found.");
        }
        return null;
    }

    @Override
    @Transactional
    @Secured(value = {"ROLE_SPITTER", "ROLE_ADMIN"})
    public Spitter saveSpitter(Spitter spitter) {
        Spitter save = spitterDao.save(spitter);
        return save;
    }

    @Override
    public void deleteSpitter(long id) {
        Spitter spitter = findSpitterById(id);
        if (spitter!=null){
            spitterDao.delete(spitter);
        }
    }
}
