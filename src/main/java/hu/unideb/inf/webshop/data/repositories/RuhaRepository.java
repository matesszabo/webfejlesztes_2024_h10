package hu.unideb.inf.webshop.data.repositories;

import hu.unideb.inf.webshop.data.entities.RuhaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuhaRepository extends JpaRepository<RuhaEntity, Long> {
}
