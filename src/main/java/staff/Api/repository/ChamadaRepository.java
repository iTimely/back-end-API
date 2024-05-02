package staff.Api.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import staff.Api.entity.Chamada;

@Repository
@RequiredArgsConstructor
public class ChamadaRepository {
    private final MongoTemplate mongoTemplate;

    public void save(Chamada chamada){
        mongoTemplate.save(chamada);
    }

    public Chamada findById(String id){
        return mongoTemplate.findById(id, Chamada.class);
    }
}
