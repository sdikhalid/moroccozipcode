package net.faleh.postalcode.services;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;

import net.faleh.postalcode.database.PostalCode;

@Named
public class PostalCodeServiceImpl implements PostalCodeService {

    @Inject
    PostalCodRepository postalCodRepository;

    @Override
    public List<PostalCode> find(@NotBlank String value) {
        List<PostalCode> result = new ArrayList<>();
        result.addAll(postalCodRepository.find(value));
        return result;
    }
}
