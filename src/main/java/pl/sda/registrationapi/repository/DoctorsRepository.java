package pl.sda.registrationapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.registrationapi.model.Doctor;
import pl.sda.registrationapi.model.Patient;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctor, Long> {

}
