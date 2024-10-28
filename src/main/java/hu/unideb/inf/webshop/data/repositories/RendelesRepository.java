package hu.unideb.inf.webshop.data.repositories;

import hu.unideb.inf.webshop.data.entities.RendelesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendelesRepository extends JpaRepository<Long, RendelesEntity> {
}
