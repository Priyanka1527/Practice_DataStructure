/*Create an Allergy class with symptoms and severity as properties. Search allergy based on symptoms.  */

class Allergy
{
  private String allergyName;
  private Severity severity;

  public Allergy(String allergyName, Severity severity)
  {
    this.allergyName = allergyName;
    this.severity = severity;
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
}
