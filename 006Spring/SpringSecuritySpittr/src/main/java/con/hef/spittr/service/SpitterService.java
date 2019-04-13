package con.hef.spittr.service;

import con.hef.spittr.domain.Spitter;

import java.util.List;

public interface SpitterService {

    Spitter findSpitterById(Long id);

    Spitter findOneSpitterById(Long id);

    Spitter saveSpitter(Spitter spitter);

    void deleteSpitter(long id);

    Spitter addSpitter(Spitter spitter);

    void deleteOneSpitter(long id);

    List<Spitter> findAllSpitter();

    List<Spitter> addSppiters(List<Spitter> spitters);

    void deleteSpitters(List<Spitter> spitters);
}
