package fdmcv2.domain.models.service;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

public class CatServiceModel {
    private String id;
    private String name;
    private String breed;
    private String color;
    private Integer age;
    private String gender;
    private BigDecimal price;
    private Date addedOn;
    private boolean hasPassport;

    public CatServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    @Size(min = 2, max = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(min = 5, max = 20)
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @NotNull
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @NotNull
    @Min(1)
    @Max(31)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @NotNull
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @NotNull
    @DecimalMin("0.01")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public boolean isHasPassport() {
        return hasPassport;
    }

    public void setHasPassport(boolean hasPassport) {
        this.hasPassport = hasPassport;
    }
}
