package io.datajek.databaserelationships.repository;

import io.datajek.databaserelationships.onetomany.uni.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
}
