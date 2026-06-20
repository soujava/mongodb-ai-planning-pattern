package expert.os.demos.travel.assistance;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Repository;

import java.util.UUID;

@Repository
public interface AttractionRepository extends BasicRepository<Attraction, UUID> {
}
