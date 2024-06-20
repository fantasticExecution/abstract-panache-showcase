package debugging;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@TestTransaction
class EntityTest {

    @Test
    void createAndDeleteEntitiesById() {

        ChildEntityA cea1 = new ChildEntityA();
        cea1.commonColumn = UUID.randomUUID().toString();
        cea1.specificFieldA = 5;
        cea1.persist();

        ChildEntityA cea2 = new ChildEntityA();
        cea2.commonColumn = UUID.randomUUID().toString();
        cea2.specificFieldA = 8;
        cea2.persist();

        ChildEntityA cea3 = new ChildEntityA();
        cea3.commonColumn = UUID.randomUUID().toString();
        cea3.specificFieldA = 3;
        cea3.persist();

        assertEquals(2, ChildEntityA.deleteBulkById(Set.of(cea1.id, cea2.id)));
    }

}
