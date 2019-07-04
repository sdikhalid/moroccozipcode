package net.faleh.postalcode.api.v1;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.faleh.postalcode.database.City;
import net.faleh.postalcode.database.CityDistrict;
import net.faleh.postalcode.database.PostalCode;
import net.faleh.postalcode.database.Region;
import net.faleh.postalcode.database.RegionCommunity;

@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
public class PostalCodeView {

    private final String code;

    private final String label;

    private final String regionName;

    private final String cityName;

    public static PostalCodeView from(PostalCode postalCode) {
        return PostalCodeView.builder()//
                .cityName(postalCode.isDistrict() ?
                        ((CityDistrict) postalCode).getCity().getName() : null)//
                .code(postalCode.getCode())//
                .regionName(postalCode.isCommunity() ?
                        ((RegionCommunity) postalCode).getRegion().getName() : null)//
                .label(postalCode.getLabel())//
                .build();
    }


}
