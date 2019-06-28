package net.faleh.postalcode.api.v1;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import net.faleh.postalcode.database.PostalCodRepository;
import net.faleh.postalcode.database.PostalCode;

@Named
public class PostalCodeControllerImpl implements PostalCodeController {

    @Inject
    private PostalCodRepository postalCodRepository;

    @Override
    @NotNull @Valid
    public List<PostalCode> findPostalCode(String startingWith) {
        return postalCodRepository.find(startingWith);
    }
}
