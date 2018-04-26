package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.model.Spittle;

import java.util.List;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findRecentSpittles() {
        return null;
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public Spittle findOne(long id) {
        return null;
    }

    @Override
    public void save(Spittle spittle) {

    }
}
