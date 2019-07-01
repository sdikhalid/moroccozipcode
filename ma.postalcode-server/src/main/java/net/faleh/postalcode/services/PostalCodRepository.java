package net.faleh.postalcode.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import net.faleh.postalcode.database.PostalCode;

public interface PostalCodRepository extends PagingAndSortingRepository<PostalCode, Long> {

    PostalCode findByCode(long code);

    @Query("select pc from PostalCode pc where" +
            " (lower(city)  like lower(concat('%',?1, '%'))) " +
            "or (lower(place) like lower(concat('%',?1, '%'))) " +
            "or (lower(code) like lower(concat('%',?1, '%')))")
    List<PostalCode> find(@Param("value") String value);

}
