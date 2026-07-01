package expert.os.demos.travel;

import expert.os.demos.travel.infrastructure.FieldVisibilityStrategy;
import jakarta.json.bind.annotation.JsonbVisibility;

import java.math.BigDecimal;
import java.util.Optional;

@JsonbVisibility(value = FieldVisibilityStrategy.class)
public class TravelRequest {

    private String city;
    private TravelType type;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    public Optional<String> city() {
        return Optional.ofNullable(city);
    }

    public Optional<TravelType> type() {
        return Optional.ofNullable(type);
    }

    public Optional<BigDecimal> minPrice() {
        return Optional.ofNullable(minPrice);
    }

    public Optional<BigDecimal> maxPrice() {
        return Optional.ofNullable(maxPrice);
    }
}
