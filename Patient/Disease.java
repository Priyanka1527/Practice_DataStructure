import java.sql.Timestamp;
import java.util.ArrayList;

class Disease
{
  private String dname;
  private ArrayList<String> symptoms;
  private Timestamp recordTime;

  public Disease(String dname, ArrayList<String> symptoms)
  {
    this.dname = dname;
    this.symptoms = symptoms;
    this.recordTime = new Timestamp(System.currentTimeMillis());
  }

  public void setDname(String dname)
  {
    this.dname = dname;
  }
  public String getDname()
  {
    return dname;
  }

  public void addSymptom(String symptom)
  {
    this.symptoms.add(symptom);
  }
  public ArrayList<String> getSymptoms()
  {
    return symptoms;
  }

  public Timestamp getRecordTime()
  {
    return recordTime;
  }
}
