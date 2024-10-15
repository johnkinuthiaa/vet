package com.crud.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String breed;
    private String color;
    private Integer age;
    private String description;
    private BigDecimal price;
    private LocalDateTime createdOn;

    public Pet(){}
    public Pet(String name,String breed,String color,Integer age,String description,BigDecimal price,LocalDateTime createdOn){
        this.name=name;
        this.breed=breed;
        this.color=color;
        this.age =age;
        this.description=description;
        this.price=price;
        this.createdOn=createdOn;
    }
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setBreed(String breed){
        this.breed =breed;
    }
    public String getBreed(){
        return breed;
    }
    public void setAge(Integer age){
        this.age=age;
    }
    public Integer getAge(){
        return age;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setPrice(BigDecimal price){
        this.price=price;
    }
    public BigDecimal getPrice(){
        return price;
    }
    public void setCreatedOn(LocalDateTime createdOn){
        this.createdOn=createdOn;
    }
}
