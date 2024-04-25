package staff.Api.database.migrations;
import io.mongock.api.annotations.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id = "created db", order = "1", author = "Nicole")
public class V1ChangeUnit {
    private  MongoTemplate mongoTemplate;
    public void migrate() {
        createCollectionIfNotExists("aluno");
        createCollectionIfNotExists("turma");
        createCollectionIfNotExists("professor");
        createCollectionIfNotExists("registroPresenca");
    }

    private void createCollectionIfNotExists(String collectionName) {
        if (!mongoTemplate.collectionExists(collectionName)) {
            mongoTemplate.createCollection(collectionName);
        }
    }
}
