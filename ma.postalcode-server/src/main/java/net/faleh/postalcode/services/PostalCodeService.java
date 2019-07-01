package net.faleh.postalcode.services;

import java.util.List;

import javax.validation.constraints.NotBlank;

import net.faleh.postalcode.database.PostalCode;

public interface PostalCodeService {

    List<PostalCode> find(@NotBlank String value);

}
