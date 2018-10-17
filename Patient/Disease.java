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

  public String getDname()
  {
    return dname;
  }

  public void setDname(String dname)
  {
    this.dname = dname;
  }

  public ArrayList<String> getSymptoms()
  {
    return symptoms;
  }

  public void setSymptom(String symptom)
  {
    this.symptoms.add(symptom);
  }

  public Timestamp getRecordTime()
  {
    return recordTime;
  }

  public String getFullSymptoms()
  {
    String symp_list = String.format("The Symptoms of the Disease %s are: \n", this.getDname());
    for(int i = 0; i < this.symptoms.size(); i++)
    {
      symp_list += this.symptoms.get(i);
      symp_list += ", ";
    }
    return symp_list;
  }
}
