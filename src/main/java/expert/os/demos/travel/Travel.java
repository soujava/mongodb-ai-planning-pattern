package expert.os.demos.travel;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.UUID;

@Entity
public class Travel {

    @Id
    private UUID id;

    @Column
    private String city;

    @Column
    private TravelType type;
}
