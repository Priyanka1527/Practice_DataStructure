import java.util.List;
import java.util.Date;

class Patient extends Person
{
  private List<Allergy> allergies;
  private List<Disease> diseases;
  private List<Medication> medications;
  private Temperature temperature;
  private Date lastseen;

  public Patient(String name, int age, Address address, List<Allergy> allergies, List<Disease> diseases, List<Medication> medications, Temperature temperature )
  {
    super(name,age,address);
    this.allergies = allergies;
    this.diseases = diseases;
    this.medications = medications;
    this.temperature = temperature;
    this.lastseen = new Date();
  }

  public Patient(String name, int age, Address address, List<Allergy> allergies, List<Disease> diseases, List<Medication> medications, Temperature temperature, Date lastseen )
  {
    super(name,age,address);
    this.allergies = allergies;
    this.diseases = diseases;
    this.medications = medications;
    this.temperature = temperature;
    this.lastseen = lastseen;
  }

  public List<Allergy> getAllergy()
  {
    return allergies;
  }
  public void setAllergy(List<Allergy> allergies)
  {
    this.allergies = allergies;
  }

  public List<Disease> getDisease()
  {
    return diseases;
  }
  public void setDisease(List<Disease> diseases)
  {
    this.diseases = diseases;
  }

  public List<Medication> getMedication()
  {
    return medications;
  }
  public void setMedication(List<Medication> medications)
  {
    this.medications = medications;
  }

  public Temperature getTemperature()
  {
    return temperature;
  }
  public void setTemperature(Temperature temperature)
  {
    this.temperature = temperature;
  }

  public Date getLastSeen()
  {
    return lastseen;
  }
  public void setLastSeen()
  {
    this.lastseen = lastseen;
  }

  //All the functions

  public boolean hasFever()
  {
    return (temperature.getTemperature() > 39) ? true : false;
  }

//Get the list of all the allergies
  public String getFullAllergies()
  {
    String fullAllergies = String.format("%s has the next allergies: \n", this.getName());

    for(int i=0; i<this.getAllergy().size(); i++)
    {
      fullAllergies += String.format("%s with a severity %s and symptom %s", this.getAllergy().get(i).getAllergyName(), this.getAllergy().get(i).getSeverity(), this.getAllergy().get(i).getSymptom());

      fullAllergies += "\n";
    }

    return fullAllergies;
  }

  //Get the list of all the diseases
  public String getFullDiseases()
  {
    String fullDiseases = String.format("%s has the next diseases: \n", this.getName());

    for(int i=0; i<this.getDisease().size(); i++)
    {
      fullDiseases += String.format("Disease: %s and Symptoms: %s", this.getDisease().get(i).getDname(), this.getDisease().get(i).getFullSymptoms()); //need to print the symptoms and recorded time

      fullDiseases += "\n";
    }

    return fullDiseases;
  }

  //Get the list of all the medications
  public String getFullMedications()
  {
    String fullMedications = String.format("%s has the next medications: \n", this.getName());

    for(int i=0; i<this.getMedication().size(); i++)
    {
      fullMedications += String.format("%s with dosage %s and %d times", this.getMedication().get(i).getMname(), this.getMedication().get(i).getDosage(), this.getMedication().get(i).getFrequency());

      fullMedications += "\n";
    }

    return fullMedications;
  }
}
