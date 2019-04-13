package con.hef.spittr.service.impl;

import con.hef.spittr.dao.SpitterDao;
import con.hef.spittr.domain.Spitter;
import con.hef.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SpitterServiceimpl implements SpitterService {

    @Autowired
    private SpitterDao spitterDao;

    @Override
    public Spitter findSpitterById(Long id) {
        return spitterDao.getOne(id);
    }

    @Override
    public Spitter saveSpitter(Spitter spitter) {
        Spitter save = spitterDao.save(spitter);
        return save;
    }

    @Override
    public void deleteSpitter(long id) {
        Spitter spitter = findSpitterById(id);
        spitterDao.delete(spitter);
    }
}
