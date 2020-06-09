package labcourse.healthcare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    @Query("select d from Doctor d where d.specialization = 'ortoped'")
    List<Doctor> getOrthopedics();
}
