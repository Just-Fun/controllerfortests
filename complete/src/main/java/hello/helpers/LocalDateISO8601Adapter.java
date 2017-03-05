package hello.helpers;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.parse;

public class LocalDateISO8601Adapter extends XmlAdapter<String, LocalDate> {

    private static final String ISO_8601_DATE_FORMAT = "yyyy-MM-dd";
	private DateTimeFormatter formatter;

	public LocalDateISO8601Adapter() {
		super();

		formatter = DateTimeFormatter.ofPattern(ISO_8601_DATE_FORMAT);
//		formatter = DateTimeFormatter.ISO_OFFSET_DATE;
	}

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		return parse(v, formatter);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.format(formatter);
	}

}
