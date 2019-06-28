package net.faleh.postalcode.database;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
public class PostalCode {

    @Id
    private long id;
    
    private final BigInteger code;

    private final String city;

    private final String place;

}
