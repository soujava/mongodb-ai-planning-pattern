package expert.os.demos.travel.assistance;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

@Entity
public record City(@Id String id, @Column String name, @Column String country, @Column String description) {
}