package br.toba.party.domain.responsible;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {

    Responsible findByName(String name);
}
