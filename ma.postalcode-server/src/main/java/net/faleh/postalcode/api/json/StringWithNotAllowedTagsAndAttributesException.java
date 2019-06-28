package net.faleh.postalcode.api.json;

import com.fasterxml.jackson.core.JsonProcessingException;

class StringWithNotAllowedTagsAndAttributesException extends JsonProcessingException {

	StringWithNotAllowedTagsAndAttributesException(String message) {
		super(message);
	}
}
