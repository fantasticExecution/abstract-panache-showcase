package debugging;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "child_entity_a")
public class ChildEntityA extends AbstractEntity{

    @Column(name = "specific_field_a")
    public int specificFieldA;

}
