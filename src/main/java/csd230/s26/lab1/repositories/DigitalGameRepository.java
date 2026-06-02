package csd230.s26.lab1.repositories;

import csd230.s26.lab1.entities.DigitalGameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DigitalGameRepository extends JpaRepository<DigitalGameEntity, Long> {
    List<DigitalGameEntity> findByTitle(String title);
}
