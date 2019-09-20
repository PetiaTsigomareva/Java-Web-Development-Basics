package app.domain.models.service;

import java.math.BigDecimal;

public class JobServiceModel {
    private String id;
    private String sector;
    private String profession;
    private BigDecimal salary;
    private String description;

    public JobServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public String getSector() {
        return this.sector;
    }

    public String getProfession() {
        return this.profession;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(String id) {
        this.id = id;
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
