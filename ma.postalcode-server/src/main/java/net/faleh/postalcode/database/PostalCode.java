package net.faleh.postalcode.database;

import java.math.BigInteger;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",
        discriminatorType = DiscriminatorType.STRING)
@ToString(callSuper = true)
public abstract class PostalCode {

    @Id
    private long id;

    private final String name;

    private final String code;

    public abstract String getLabel();

    public abstract boolean isCommunity();

    public abstract boolean isDistrict();
}
