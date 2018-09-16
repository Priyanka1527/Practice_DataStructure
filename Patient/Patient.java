import java.util.*;

class Patient extends Person
{
  private Disease disease;
  private List<Medication> medications;

  public Patient(String name, String phone, String email, Address address, Disease disease, List<Medication> medications)
  {
    super(name,phone,email,address);
    this.disease = disease;
    this.medications = medications;
  }

  public void setDisease(Disease disease)
  {
    this.disease = disease;
  }
  public Disease getDisease()
  {
    return disease;
  }

  public void setMedication(List<Medication> medications)
  {
    this.medications = medications;
  }
  public List<Medication> getMedication()
  {
    return medications;
  }
}
