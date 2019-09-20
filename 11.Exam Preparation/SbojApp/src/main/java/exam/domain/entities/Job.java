package exam.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "jobs")
public class Job extends BaseEntity {

    private SectorsEnum sector;
    private String profession;
    private BigDecimal salary;
    private String description;

    public Job() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "sector", nullable = false)

    public SectorsEnum getSector() {
        return sector;
    }

    public void setSector(SectorsEnum sector) {
        this.sector = sector;
    }


    @Column(name = "profession", nullable = false)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Column(name = "salary", nullable = false, columnDefinition = "DECIMAL(10, 2) DEFAULT '0.00'")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
