package ma.livre.livreexposant.Repository;

import ma.livre.livreexposant.Model.Exposant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ExposantRepository extends JpaRepository<Exposant, Integer> {
}
