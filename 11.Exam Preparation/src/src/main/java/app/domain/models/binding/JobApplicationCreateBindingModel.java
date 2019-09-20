package app.domain.models.binding;


import java.math.BigDecimal;

public class JobApplicationCreateBindingModel {
    private String sector;
    private String profession;
    private BigDecimal salary;
    private String description;

    public JobApplicationCreateBindingModel() {
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
