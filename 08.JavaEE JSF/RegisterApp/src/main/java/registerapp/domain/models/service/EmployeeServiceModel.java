package registerapp.domain.models.service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class EmployeeServiceModel {
    private String id;
    private String firstName;
    private String lastName;
    private String position;
    private BigDecimal salary;
    private Integer age;

    public EmployeeServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @NotNull
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @NotNull
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
