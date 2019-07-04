package net.faleh.postalcode.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import net.faleh.postalcode.database.CityDistrict;
import net.faleh.postalcode.database.PostalCode;
import net.faleh.postalcode.database.RegionCommunity;

public interface PostalCodRepository<T extends PostalCode> extends PagingAndSortingRepository<T, Long> {

    PostalCode findByCode(long code);

    @Query("select pc from PostalCode pc where" +
            " (lower(pc.name) like lower(concat('%',?1, '%'))) " +
            "or (lower(pc.code) like lower(concat('%',?1, '%'))) ")
    List<PostalCode> find(@Param("value") String value);

}
