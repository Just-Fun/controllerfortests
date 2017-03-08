package hello.helpers;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;

public class BigDecimalAdapter extends XmlAdapter<Float, BigDecimal> {

	/*@XmlJavaTypeAdapter(BigDecimalAdapter.class)
    protected BigDecimal netFare;*/

	@Override
	public BigDecimal unmarshal(Float v) throws Exception {
//        BigDecimal bigDecimal = new BigDecimal(String.valueOf(v)).setScale(2, BigDecimal.ROUND_CEILING);
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(v));
//         bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_CEILING);
        return bigDecimal;
	}

	@Override
	public Float marshal(BigDecimal v) throws Exception {
		return v.floatValue();
	}

	/*@Override
	public LocalDate unmarshal(String v) throws Exception {
		return parse(v, formatter);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.format(formatter);
	}*/

}
