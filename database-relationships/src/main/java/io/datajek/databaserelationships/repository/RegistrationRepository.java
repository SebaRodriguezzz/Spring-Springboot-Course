package io.datajek.databaserelationships.repository;

import io.datajek.databaserelationships.onetomany.uni.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
}
