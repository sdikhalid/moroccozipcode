package net.faleh.postalcode.database;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@DiscriminatorValue("DISTRICT")
@AllArgsConstructor
@Entity
@NoArgsConstructor(force = true)
public class CityDistrict extends PostalCode {

    @ManyToOne
    private final City city;

    public String getLabel() {
        return getCity().getName() + " | " + getName();
    }

    @Override
    public boolean isCommunity() {
        return false;
    }

    @Override
    public boolean isDistrict() {
        return true;
    }

}
