package hello.helpers;

import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by Serzh on 3/5/17.
 */
public class LocalDateISO8601AdapterTest {
    //TODO us it somewhere
//	@XmlElement(name = "insertionDate")
//	@XmlJavaTypeAdapter(DateISO8601Adapter.class)
    LocalDate insertionDate;

    String string = "2011-12-03";

    @Test
    public void unmarshal() throws Exception {
        insertionDate = new LocalDateISO8601Adapter().unmarshal(string);
        System.out.println(insertionDate);
    }

    @Test
    public void marshal() throws Exception {
    }

}