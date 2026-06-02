package csd230.s26.lab1.repositories;

import csd230.s26.lab1.entities.PhysicalGameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicalGameRepository extends JpaRepository<PhysicalGameEntity, Long> {
}
