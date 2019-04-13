package con.hef.spittr.service;

import con.hef.spittr.domain.Spitter;

public interface SpitterService {

    Spitter findSpitterById(Long id);

    Spitter saveSpitter(Spitter spitter);

    void deleteSpitter(long id);
}
