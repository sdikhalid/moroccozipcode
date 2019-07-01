package net.faleh.postalcode.api.v1;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import net.faleh.postalcode.services.PostalCodRepository;
import net.faleh.postalcode.database.PostalCode;
import net.faleh.postalcode.services.PostalCodeService;

@Named
public class PostalCodeControllerImpl implements PostalCodeController {

    @Inject
    private PostalCodeService postalCodeService;

    @Override
    @NotNull @Valid
    public List<PostalCode> findPostalCode(String startingWith) {
        return postalCodeService.find(startingWith);
    }
}
