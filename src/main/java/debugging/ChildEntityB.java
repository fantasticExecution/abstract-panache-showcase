package debugging;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "child_entity_b")
public class ChildEntityB extends AbstractEntity{

    @Column(name = "specific_field_b")
    public Timestamp specificFieldB;

}
