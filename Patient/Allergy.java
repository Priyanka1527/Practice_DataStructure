/*Create an Allergy class with symptoms and severity as properties. Search allergy based on symptoms.  */
import java.util.*;

class Allergy
{
  private String allergyName;
  private Severity severity;
  private String symptom;

  public Allergy(String allergyName, Severity severity, String symptom)
  {
    this.allergyName = allergyName;
    this.severity = severity;
    this.symptom = symptom;
  }

  public Severity getSeverity()
  {
    return severity;
  }
  public void setSeverity(Severity severity)
  {
    this.severity = severity;
  }

  public String getAllergyName()
  {
    return allergyName;
  }
  public void setAllergyName(String allergyName)
  {
    this.allergyName = allergyName;
  }

  public String getSymptom()
  {
    return symptom;
  }
  public void setSymptom(String symptom)
  {
    this.symptom = symptom;
  }

  //Search Allergy based on symptom
  public static void searchAllergy(List<Allergy> allergies, String symptom)
   {
     for(Allergy allergy : allergies)
     {
         if(allergy.getSymptom().equals(symptom))
             System.out.println("\n You have Allergy: " + allergy.getAllergyName());
     }
   }
}
