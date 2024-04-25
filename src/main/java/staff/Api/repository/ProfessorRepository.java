package staff.Api.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import staff.Api.entity.Professor;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProfessorRepository {
    private final MongoTemplate mongoTemplate;

    public Professor save(Professor professor){
        return mongoTemplate.save(professor, "professor");
    }

    public Professor findByLoginAndSenha(String login, String senha){
        Query query = Query.query(Criteria.where("login").is(login).and("senha").is(senha));
        return mongoTemplate.findOne(query, Professor.class);
    }

    public List<Professor> findAll() {
        return mongoTemplate.findAll(Professor.class);
    }

    public Professor findById(String id){
        return mongoTemplate.findById(id, Professor.class);
    }

}
