package ma.livre.livreexposant.Repository;

import ma.livre.livreexposant.Model.Exposant;
import ma.livre.livreexposant.Model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface LivreRepository extends JpaRepository<Livre, Integer> {
    List<Livre> findByExposant(Exposant exposant);

}
