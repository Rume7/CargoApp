package com.codehacks.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author E238958
 */
@Entity
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String emailAddress;
    
    private String name;
    private Integer quantity;
    private String currentLocationOfGood;

    public Goods() {
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCurrentLocationOfGood() {
        return currentLocationOfGood;
    }

    public void setCurrentLocationOfGood(String currentLocationOfGood) {
        this.currentLocationOfGood = currentLocationOfGood;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.emailAddress);
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
        final Goods other = (Goods) obj;
        if (!Objects.equals(this.emailAddress, other.emailAddress)) {
            return false;
        }
        if (!Objects.equals(this.currentLocationOfGood, other.currentLocationOfGood)) {
            return false;
        }
        return Objects.equals(this.quantity, other.quantity);
    }
    
    @Override
    public String toString() {
        return "Goods[ email = " + emailAddress + " ]";
    }
}
