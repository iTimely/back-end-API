package staff.Api.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import staff.Api.entity.Aluno;
import java.util.List;

@Repository
@AllArgsConstructor
public class AlunoRepository {
    private final MongoTemplate mongoTemplate;

    public Aluno findById(String alunoId) {
        return mongoTemplate.findById(alunoId, Aluno.class);
    }

    public void save(Aluno aluno) {
        mongoTemplate.save(aluno);
    }

    public List<Aluno> alunosByTurma(String turmaId) {
        Query query = new Query(Criteria.where("turmaId").is(turmaId));
        return mongoTemplate.find(query, Aluno.class);
    }
}
