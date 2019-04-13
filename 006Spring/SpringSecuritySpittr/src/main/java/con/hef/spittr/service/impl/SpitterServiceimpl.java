package con.hef.spittr.service.impl;

import con.hef.spittr.dao.SpitterDao;
import con.hef.spittr.domain.Spitter;
import con.hef.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.logging.Logger;

@Component
public class SpitterServiceimpl implements SpitterService {

    private static final Logger logger = Logger.getLogger("SpitterServiceimpl");

    @Autowired
    private SpitterDao spitterDao;

    @Override
    @Transactional
    @RolesAllowed(value = {"ROLE_SPITTER","ROLE_ADMIN"})
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
    @PostAuthorize("returnObject.fullName == principal")
    public Spitter findOneSpitterById(Long id) {
        try {
            Spitter spitter = spitterDao.findSpitterById(id);;
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
    @PreAuthorize("hasAnyRole('ROLE_SPITTER', 'ROLE_ADMIN')")
    @PreFilter("hasRole('ROLE_ADMIN') || filterObject.updateByEmail == false ")
    public List<Spitter> addSppiters(List<Spitter> spitters) {
        List<Spitter> spitterList = spitterDao.saveAll(spitters);
        return spitterList;
    }

    @Override
    public void deleteSpitter(long id) {
        Spitter spitter = findSpitterById(id);
        if (spitter!=null){
            spitterDao.delete(spitter);
        }
    }


    @Override
    @PreAuthorize("hasRole('ROLE_SPITTER')")
    public void deleteOneSpitter(long id) {
        Spitter spitter = findSpitterById(id);
        if (spitter!=null){
            spitterDao.delete(spitter);
        }
    }

    @Override
    @Transactional
    @PreAuthorize("(hasRole('ROLE_SPITTER') and #spitter.updateByEmail == true ) or hasRole('ROLE_ADMIN')")
    public Spitter addSpitter(Spitter spitter) {
        Spitter save = spitterDao.save(spitter);
        return save;
    }

    /*
    过滤返回的数据
    如果是admin权限，就返回将所有，否则只返回 updateByEmail 为false的数据
     */
    @Override
    @PreAuthorize("hasAnyRole({'ROLE_SPITTER', 'ROLE_ADMIN'})")
    @PostFilter("hasRole('ROLE_ADMIN') || filterObject.updateByEmail == false")
    public List<Spitter> findAllSpitter() {
        return spitterDao.findAll();
    }

    @Override
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_SPITTER'})")
    @PreFilter("hasPermission(filterObject, 'delete')")
    public void deleteSpitters(List<Spitter> spitters) {
        spitterDao.deleteAll(spitters);
    }
}
