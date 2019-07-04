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
@DiscriminatorValue("COMMUNITY")
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class RegionCommunity extends PostalCode {


    @ManyToOne
    private final Region region;

    public String getLabel() {
        return getRegion().getName() + " | " + getName();
    }

    @Override
    public boolean isCommunity() {
        return true;
    }

    @Override
    public boolean isDistrict() {
        return false;
    }

}
