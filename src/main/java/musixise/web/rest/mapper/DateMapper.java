package musixise.web.rest.mapper;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by zhaowei on 16/12/29.
 */
@Component
public class DateMapper {

    public String asString (Date date) {
        return date != null ? new SimpleDateFormat("yyyy-MM-dd").format(date) : null;
    }

    public Date asDate (String date) {
        try {
            return date != null ? new SimpleDateFormat("yyyy-MM-dd").parse(date) : null;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String asDate(LocalDateTime localDateTime) {
        Date dd = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dd);

        return dateStr;
    }
}
