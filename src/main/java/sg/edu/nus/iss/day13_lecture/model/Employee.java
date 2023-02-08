package sg.edu.nus.iss.day13_lecture.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Employee {

    @NotEmpty(message = "First Name is a mandatory field")
    @Size(min=30, max=100, message = "First Name must be between 30 to 100 characters")
    private String firstName;

    @NotEmpty(message = "Last Name is a mandatory field")
    @Size(min=30, max=100, message = "Last Name must be between 30 to 100 characters")
    private String lastName;

    @Email(message = "Invalid email format")
    @Size(max=120)
    @Pattern(regexp = ".+@.+\\..+", message = "Wrong email format")
    @NotBlank(message = "Email is a mandatory field")
    private String email;

    @Pattern(regexp = "(\\8|9)[0-9]{7}", message = "Invalid phone format")
    private String phoneNo;

    @Min(value = 1500, message = "Min salary starts from 1500")
    @Max(value = 400000, message = "Max salary 400000")
    private Integer salary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Birth date cannot be greater than today")
    private Date birthDay;

    private String address;

    @Digits(fraction = 0, integer = 6, message = "Postal code format, i.e: 123456")
    private Integer postalCode;

    
    public Employee() {
    }

    
    public Employee(String firstName, String lastName, String email, String phoneNo, Integer salary, Date birthDay,
            String address, Integer postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.salary = salary;
        this.birthDay = birthDay;
        this.address = address;
        this.postalCode = postalCode;
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public Date getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }


    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNo="
                + phoneNo + ", salary=" + salary + ", birthDay=" + birthDay + ", address=" + address + ", postalCode="
                + postalCode + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (phoneNo == null) {
            if (other.phoneNo != null)
                return false;
        } else if (!phoneNo.equals(other.phoneNo))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;
        if (birthDay == null) {
            if (other.birthDay != null)
                return false;
        } else if (!birthDay.equals(other.birthDay))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode.equals(other.postalCode))
            return false;
        return true;
    }

    
    
}
