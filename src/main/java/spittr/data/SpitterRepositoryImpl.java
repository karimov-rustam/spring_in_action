package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.model.Spitter;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {
    @Override
    public Spitter save(Spitter spitter) {
        return null;
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }
}
