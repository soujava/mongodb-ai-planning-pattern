package expert.os.demos.travel;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Repository;
import jakarta.data.restrict.Restriction;

import java.util.List;
import java.util.UUID;

@Repository
public interface TravelRepository extends BasicRepository<Travel, UUID> {

    List<Travel> query(Restriction<Travel> restriction);
}
