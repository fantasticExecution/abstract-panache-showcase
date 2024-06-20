package debugging;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.impl.GenerateBridge;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractEntity extends PanacheEntityBase {

    /**
     * We use cockroach db where UUID as PK is recommended.
     */
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    public UUID id;

    @Column(name = "common_column", nullable = false, unique = true)
    public String commonColumn;

    @GenerateBridge
    public static long deleteBulkById(Set<UUID> ids) {
        if (ids == null || ids.isEmpty()) {
            return -1;
        }
        return delete("id IN ?1", ids);
    }

}
