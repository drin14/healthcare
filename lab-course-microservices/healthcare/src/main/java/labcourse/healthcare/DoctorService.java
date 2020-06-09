package labcourse.healthcare;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DoctorService {

    @Autowired
    private DoctorRepository repo;

    public List<Doctor> listAll() {
        return repo.findAll();
    }

    List<Doctor> orthopedics;
    public List<Doctor> getOrthopedicsData() {
          orthopedics = repo.getOrthopedics();
        return orthopedics;
    }

    public void save(Doctor doctor) {
        repo.save(doctor);
    }

    public Doctor get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}