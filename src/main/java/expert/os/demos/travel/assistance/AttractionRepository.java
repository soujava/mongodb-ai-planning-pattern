package expert.os.demos.travel.assistance;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.UUID;

@Repository
public interface AttractionRepository extends CrudRepository<Attraction, UUID> {
}
