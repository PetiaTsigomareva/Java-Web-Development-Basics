package app.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name= "jobs")
public class Job extends BaseEntity {
    private String sector;
    private String profession;
    private BigDecimal salary;
    private String description;

    public Job() {
    }

    @Column(name = "sector")
    public String getSector() {
        return this.sector;
    }

    @Column(name = "profession")
    public String getProfession() {
        return this.profession;
    }

    @Column(name = "salary")
    public BigDecimal getSalary() {
        return this.salary;
    }

    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
