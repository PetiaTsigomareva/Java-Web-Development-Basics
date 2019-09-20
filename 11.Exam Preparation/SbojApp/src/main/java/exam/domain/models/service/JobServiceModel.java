package exam.domain.models.service;

import exam.domain.entities.SectorsEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class JobServiceModel {

    private String id;
    private SectorsEnum sector;
    private String profession;
    private BigDecimal salary;
    private String description;

    public JobServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull(message = "can not be empty!")
    public SectorsEnum getSector() {
        return sector;
    }

    public void setSector(SectorsEnum sector) {
        this.sector = sector;
    }

    @NotNull(message = "can not be empty!")
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @NotNull(message = "can not be empty!")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @NotNull(message = "can not be empty!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
