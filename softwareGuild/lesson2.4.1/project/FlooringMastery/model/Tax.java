package com.sg.flooring.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Tax {
    private String stateAbbreviation;
    private String stateName;
    private BigDecimal taxRate;
    
    public Tax(String stateAbbreviation){
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.stateAbbreviation);
        hash = 29 * hash + Objects.hashCode(this.stateName);
        hash = 29 * hash + Objects.hashCode(this.taxRate);
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
        final Tax other = (Tax) obj;
        if (!Objects.equals(this.stateAbbreviation, other.stateAbbreviation)) {
            return false;
        }
        if (!Objects.equals(this.stateName, other.stateName)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tax{" + "stateAbbreviation=" + stateAbbreviation + ", stateName=" + stateName + ", taxRate=" + taxRate + '}';
    }
    
}
