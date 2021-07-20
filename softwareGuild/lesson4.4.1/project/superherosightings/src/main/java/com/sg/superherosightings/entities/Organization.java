package com.sg.superherosightings.entities;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Organization {
    private int organizationId;
    
    @NotBlank(message = "Organization name must not be empty.")
    @Size(max = 100, message = "Organization name must be less than 100 characters.")
    private String organizationName;
    
    @Size(max = 256, message = "Organization description must be less than 256 characters.")
    private String organizationDescription;
    
    @Size(max = 256, message = "Organization contact info must be less than 256 characters.")
    private String organizationContactInfo;

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public String getOrganizationContactInfo() {
        return organizationContactInfo;
    }

    public void setOrganizationContactInfo(String organizationContactInfo) {
        this.organizationContactInfo = organizationContactInfo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.organizationId;
        hash = 23 * hash + Objects.hashCode(this.organizationName);
        hash = 23 * hash + Objects.hashCode(this.organizationDescription);
        hash = 23 * hash + Objects.hashCode(this.organizationContactInfo);
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
        final Organization other = (Organization) obj;
        if (this.organizationId != other.organizationId) {
            return false;
        }
        if (!Objects.equals(this.organizationName, other.organizationName)) {
            return false;
        }
        if (!Objects.equals(this.organizationDescription, other.organizationDescription)) {
            return false;
        }
        if (!Objects.equals(this.organizationContactInfo, other.organizationContactInfo)) {
            return false;
        }
        return true;
    }
}
