import java.util.Date;
import java.util.TimeZone;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

class Baby
{
  private String name;
  private Date birth;
  private String continent;
  private String city;

  public Baby(String name, Date birth, String continent, String city)
  {
    this.name = name;
    this.birth = birth;
    this.continent = continent;
    this.city = city;
  }

  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }

  public Date getBirth()
  {
    return birth;
  }
  public void setBirth(Date birth)
  {
    this.birth = birth;
  }

  public String getContinent()
  {
    return continent;
  }
  public void setContinent(String continent)
  {
    this.continent = continent;
  }

  public String getCity()
  {
    return city;
  }
  public void setCity(String city)
  {
    this.city = city;
  }

  public String convertToTimeZone(String continent, String city)
  {
    Calendar calendar = new  GregorianCalendar();
    calendar.setTime(this.birth);

    DateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss z");

    formatter.setCalendar(calendar);
    formatter.setTimeZone(TimeZone.getTimeZone(continent + "/" + city));

    return formatter.format(calendar.getTime());
  }
}
