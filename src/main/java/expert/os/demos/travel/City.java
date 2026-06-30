package expert.os.demos.travel;

import jakarta.nosql.Embeddable;

@Embeddable(Embeddable.EmbeddableType.GROUPING)
public record City(String name) {
}
