package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.model.Spittle;

import java.util.List;

@Repository
public interface SpittleRepository {

    List<Spittle> findRecentSpittles();

    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);

    void save(Spittle spittle);
}
