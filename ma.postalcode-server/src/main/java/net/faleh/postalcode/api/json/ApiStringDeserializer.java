package net.faleh.postalcode.api.json;

import java.io.IOException;

import javax.inject.Named;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import lombok.extern.slf4j.Slf4j;

@Named
@Slf4j
public class ApiStringDeserializer extends JsonDeserializer<String> {

    private final boolean safeHtmlParsing;

    private final Whitelist whitelist;

    public ApiStringDeserializer(@Value("${" + "safe.html.parsing" + ":true}") boolean safeHtmlParsing,
                                 @Value("${safe.html.white.list:none}") String htmlWhiteList) {
        this.safeHtmlParsing = safeHtmlParsing;
        this.whitelist = determineWhiteList(htmlWhiteList);
    }

    @Override
    public String deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String jsonAsString = jp.getValueAsString();
        if (safeHtmlParsing) {
            boolean isValid = Jsoup.isValid(jsonAsString, whitelist);
            if (!isValid) {
                String errorMessage = "input has tags and attributes not allowed by the Whitelist. Input String was : "
                        + jsonAsString;
                throw new StringWithNotAllowedTagsAndAttributesException(errorMessage);
            }
        }
        jsonAsString = StringUtils.trimAllWhitespace(jsonAsString);
        return SingleQuoteNormalizer.normalizeQuotes(jsonAsString);
    }

    private Whitelist determineWhiteList(String htmlWhiteList) {
        switch (htmlWhiteList) {
            case "basic":
                return Whitelist.basic();
            case "simpleText":
                return Whitelist.simpleText();
            case "basicWithImages":
                return Whitelist.basicWithImages();
            case "none":
                return Whitelist.none();
            case "relaxed":
                return Whitelist.relaxed();
        }
        return Whitelist.none();
    }
}