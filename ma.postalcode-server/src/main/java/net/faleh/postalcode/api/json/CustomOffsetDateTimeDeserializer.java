package net.faleh.postalcode.api.json;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * This deserializer is a custom JSON deserializer. It aims to deserialize dates into OffsetDateTime format, handling
 * the case of having a LocalDate format as input. Use for backward compatibility.
 */
public class CustomOffsetDateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {

	@Override
	public OffsetDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		jp.getValueAsString();
		return convert(jp.getValueAsString());
	}

	private OffsetDateTime convert(String valueAsString) {
		OffsetDateTime offsetDateTime;

		try {
			offsetDateTime = OffsetDateTime.parse(valueAsString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		} catch (Exception e) {
			LocalDate localDate = LocalDate.parse(valueAsString);

			offsetDateTime = OffsetDateTime.of(localDate, LocalTime.now(), OffsetDateTime.now().getOffset());
		}

		return offsetDateTime;
	}
}
