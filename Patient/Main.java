import java.util.ArrayList;
import java.util.List;

public class Main
{

  public void searchAllergy(List<Allergy> allergies, String symptom)
  	{
    	for(Allergy allergy : allergies)
    	{
      		if(allergy.getSymptom().equals(symptom))
              System.out.println("\n You have Allergy: " + allergy.getDiseaseName());
    	}
  	}

  public static void main(String args[])
  {
    Allergy allergy1 = new Allergy("coughing", "Priya", Severity.LOW, "Regular cough");
    Allergy allergy2 = new Allergy("swelling", "John", Severity.HIGH, "Anaphylaxis");
    Allergy allergy3 = new Allergy("itchiness", "Ben", Severity.MEDIUM, "Contact Dermatitis");

    Fever temp1 = new Fever(35);

    List<Allergy> allergies = new ArrayList<Allergy>();

	allergies.add(allergy1);
	allergies.add(allergy2);
    allergies.add(allergy3);

    Main obj = new Main();
    obj.searchAllergy(allergies, "itchiness");

    /*for(Allergy allergy : allergies)
    {
      System.out.println(allergy.getDiseaseName());
    }*/

  }
}
