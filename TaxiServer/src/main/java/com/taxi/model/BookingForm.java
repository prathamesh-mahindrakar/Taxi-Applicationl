package com.taxi.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class BookingForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 30, message = "Invalid name length")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only alphabets")
    private String name;

    @NotEmpty(message = "Source cannot be empty")
    @Size(min = 2, max = 100, message = "Invalid source length")
    private String source;

    @NotEmpty(message = "Destination cannot be empty")
    @Size(min = 2, max = 100, message = "Invalid destination length")
    private String destination;

    @NotEmpty(message = "Email cannot be empty")
    @Size(min = 8, max = 50, message = "Invalid email length")
    private String email;

    @NotNull(message = "Time cannot be empty")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;

    @NotNull(message = "Date cannot be empty")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotEmpty(message = "Comfort cannot be empty")
    @Size(min = 2, max = 20, message = "Invalid comfort length")
    private String comfort;

    @NotNull(message = "Adult count cannot be empty")
    @Min(value = 1, message = "Adult must be at least 1")
    @Max(value = 4, message = "Adult can be at most 4")
    private Integer adult;

    @NotNull(message = "Children count cannot be empty")
    @Min(value = 0, message = "Children cannot be negative")
    @Max(value = 3, message = "Children can be at most 3")
    private Integer children;

    @NotEmpty(message = "Message cannot be empty")
    @NotBlank(message = "Message cannot be blank")
    @Size(min = 2, max = 2000, message = "Invalid message length")
    private String message;

    public BookingForm() {
        super();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComfort() {
        return comfort;
    }

    public void setComfort(String comfort) {
        this.comfort = comfort;
    }

    public Integer getAdult() {
        return adult;
    }

    public void setAdult(Integer adult) {
        this.adult = adult;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BookingForm [id=" + id + ", name=" + name + ", source=" + source + ", destination=" + destination
                + ", email=" + email + ", time=" + time + ", date=" + date + ", comfort=" + comfort + ", adult=" + adult
                + ", children=" + children + ", message=" + message + "]";
    }
}
