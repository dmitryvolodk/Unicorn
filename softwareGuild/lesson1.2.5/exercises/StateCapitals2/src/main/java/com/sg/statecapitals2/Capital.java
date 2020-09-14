package com.sg.statecapitals2;

public class Capital {
    private String name;
    private Integer population;
    private Integer sqMileage;

    public void setNamePopulationSqMileage(String name, Integer population, Integer sqMileage){
        this.name = name;
        this.population = population;
        this.sqMileage = sqMileage;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getSqMileage() {
        return sqMileage;
    }

    public void setSqMileage(Integer sqMileage) {
        this.sqMileage = sqMileage;
    }
}
