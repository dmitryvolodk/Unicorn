package com.sg.superherosightings.entities;

import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Hero {
    private int heroId;
    
    @NotBlank(message = "Hero name must not be empty.")
    @Size(max = 50, message = "Hero name must be less than 50 characters.")
    private String heroName;
    
    @Size(max = 256, message = "Hero description must be less than 256 characters.")
    private String heroDescription;
    
    private Superpower superpower;
    
    @Size(max = 50, message = "Photo name must be less than 50 characters.")
    private String photoName;
    
    @NotNull(message = "Organizations must not be empty.")
    private List<Organization> organizations;

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroDescription() {
        return heroDescription;
    }

    public void setHeroDescription(String heroDescription) {
        this.heroDescription = heroDescription;
    }

    public Superpower getSuperpower() {
        return superpower;
    }

    public void setSuperpower(Superpower superpower) {
        this.superpower = superpower;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.heroId;
        hash = 79 * hash + Objects.hashCode(this.heroName);
        hash = 79 * hash + Objects.hashCode(this.heroDescription);
        hash = 79 * hash + Objects.hashCode(this.superpower);
        hash = 79 * hash + Objects.hashCode(this.photoName);
        hash = 79 * hash + Objects.hashCode(this.organizations);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hero other = (Hero) obj;
        if (this.heroId != other.heroId) {
            return false;
        }
        if (!Objects.equals(this.heroName, other.heroName)) {
            return false;
        }
        if (!Objects.equals(this.heroDescription, other.heroDescription)) {
            return false;
        }
        if (!Objects.equals(this.photoName, other.photoName)) {
            return false;
        }
        if (!Objects.equals(this.superpower, other.superpower)) {
            return false;
        }
        if (!Objects.equals(this.organizations, other.organizations)) {
            return false;
        }
        return true;
    }
}
