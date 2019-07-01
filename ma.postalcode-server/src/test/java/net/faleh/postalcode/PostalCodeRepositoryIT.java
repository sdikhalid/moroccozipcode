package net.faleh.postalcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.faleh.postalcode.services.PostalCodRepository;
import net.faleh.postalcode.database.PostalCode;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostalCodeRepositoryIT {

    @Autowired
    private PostalCodRepository postalCodRepository;

    @Test
    public void should_load_all_postal_codes() {
        Iterable<PostalCode> codes = postalCodRepository.findAll();
        assertThat(codes.iterator().next()).isNotNull();
    }

    @Test
    public void should_load_postal_codes_city_or_place_start_with() {
        List<PostalCode> codes = postalCodRepository.find("fes");
        assertThat(codes.iterator().next()).isNotNull();
    }

    @Test
    public void should_load_postal_codes_place_start_with() {
        List<PostalCode> codes = postalCodRepository.find("hay oued");
        assertThat(codes.iterator().next()).isNotNull();
    }

}