package expert.os.demos.travel.assistance;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Param;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttractionRepository extends BasicRepository<Attraction, UUID> {

    @Query("WHERE city.id = :city")
    List<Attraction> findByCityName(@Param("city") UUID city);

    @Query("WHERE city.id = :city AND type = :type")
    List<Attraction> findByCityNameAndType(@Param("city") String city, @Param("type") AttractionType type);
}
