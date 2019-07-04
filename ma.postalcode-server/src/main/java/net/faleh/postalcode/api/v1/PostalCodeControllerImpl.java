package net.faleh.postalcode.api.v1;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import net.faleh.postalcode.database.PostalCode;
import net.faleh.postalcode.services.PostalCodeService;

@Named
public class PostalCodeControllerImpl implements PostalCodeController {

    @Inject
    private PostalCodeService postalCodeService;

    @Override
    @NotNull
    @Valid
    public List<PostalCodeView> findPostalCode(String startingWith) {
        return postalCodeService.find(startingWith).stream().map(PostalCodeView::from).collect(Collectors.toList());
    }
}
