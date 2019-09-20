package fdmcv2.domain.models.binding;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

public class CatBindingModel {

    private String name;
    private String breed;
    private String color;
    private Integer age;
    private String gender;
    private BigDecimal price;
    private Date addedOn;
    private boolean hasPassport;

    public CatBindingModel() {
    }

    @NotNull(message = "can't be empty!")
    @Size(min = 2, max = 10, message = "must be between 2 and 10 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "can't be empty!")
    @Size(min = 5, max = 20, message = "must be between 5 and 20 characters!")
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @NotNull(message = "can't be empty!")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @NotNull(message = "can't be empty!")
    @Min(value = 1, message = "must be at least than 1!")
    @Max(value = 31, message = "must not be biggest than 31!")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @NotNull(message = "can't be empty!")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @NotNull(message = "can't be empty!")
    @DecimalMin(value = "0.01", message = "must be at least 0.01")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = "can't be empty!")
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
