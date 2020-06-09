package labcourse.healthcare;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
    private Long iddoctor;
    private String name;
    private String specialization;
    private String address;
    private int departmentid;

    protected Doctor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Long iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }
}
