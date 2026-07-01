package expert.os.demos.travel;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public record Travel (@Id UUID id, @Column String city, @Column TravelType type, @Column BigDecimal price) {

}
