package hu.unideb.inf.webshop.data.repositories;

import hu.unideb.inf.webshop.data.entities.Felhasznalo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FelhasznaloRepository extends JpaRepository<Long, Felhasznalo> {
}