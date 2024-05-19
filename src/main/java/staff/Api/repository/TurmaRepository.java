package staff.Api.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;
import staff.Api.entity.Turma;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class TurmaRepository {
    private final MongoTemplate mongoTemplate;

    public List<Turma> findByProfessor(String professorId){
        Criteria criteria = new Criteria().orOperator(
                Criteria.where("professorResponsavel.professorId").is(professorId),
                Criteria.where("professoresAuxiliares").elemMatch(Criteria.where("professorId").is(professorId))
        );
        Query query = Query.query(criteria);
        return mongoTemplate.find(query, Turma.class);
    }

    public Turma findById(String turmaId) {
        return mongoTemplate.findById(turmaId, Turma.class);
    }
}
