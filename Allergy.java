/*Create an Allergy class with symptoms and severity as properties. Search allergy based on symptoms.  */

import java.util.ArrayList;
import java.util.List;

public class Allergy
{
  private String symptom;
  private String reporter;
  private Severity severity;
  private String diseaseName;
  
  public Allergy(String symptom, String reporter, Severity severity, String diseaseName)
  {
   	this.symptom = symptom;
    this.reporter=reporter;
    this.severity=severity;
    this.diseaseName=diseaseName;
  }
  
  public void setSymptom(String symptom)
  {
    this.symptom = symptom;
  }
  
  public String getSymptom()
  {
    return this.symptom;
  }
  
  public void setReporter(String reporter)
  {
    this.reporter = reporter;
  }
  
  public String getReporter()
  {
    return this.reporter;
  }
  
  public void setSeverity(Severity severity)
  {
    this.severity = severity;
  }
  
  public Severity getSeverity()
  {
    return this.severity;
  }
  
  public void setDiseaseName(String diseaseName)
  {
    this.diseaseName = diseaseName;
  }
  
  public String getDiseaseName()
  {
    return this.diseaseName;
  }
  
}

enum Severity
{
  HIGH, MEDIUM, LOW;
}



