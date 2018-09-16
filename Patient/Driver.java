import java.util.*;

class Driver
{
  public static void main(String args[])
  {
    ArrayList<String> sym = new ArrayList<String>();
    sym.add("itchiness");
    sym.add("redness");
    Address add1 = new Address("1942, Baker Drive","Lenexa","Kansas",66219);

    Disease dis1 = new Disease("Contact Dermatitis", sym);

    Medication med1 = new Medication("Benadryl","25mg",3);
    Medication med2 = new Medication("Cortef","30mg",2);
    List<Medication> medList1 = new ArrayList<Medication>();
    medList1.add(med1);
    medList1.add(med2);

    Patient pat1 = new Patient("Ron", "7859993434", "ron88@gmail.com", add1, dis1, medList1);

    System.out.println("Name: " + pat1.getName());
    // System.out.println("Contact: " + pat1.getPhone());
    // System.out.println("Email: " + pat1.getEmail());
    // System.out.println("Address: " + pat1.getAddress().getAddressLine() + " " + pat1.getAddress().getCity() + " , " + pat1.getAddress().getState() + " - " + pat1.getAddress().getZip());
    // System.out.println("Health Condition: " + pat1.getDisease().getDname());
    // System.out.println("Symptoms: " + pat1.getDisease().getSymptoms());
    // System.out.println("Disease Recoreded Time: " + pat1.getDisease().getRecordTime());

    for(int i = 0 ; i < medList1.size() ; i++)
    {
      System.out.println("Medication Name: " + pat1.getMedication().get(i).getMname() + " and Frequency: " + pat1.getMedication().get(i).getFrequency());
    }

    // System.out.println("\nMedication: ");
    // for(Medication med : medList1)
    // {
    //   System.out.println("Medicine Name: " + med.getMname());
    //   System.out.println("Medicine Dosage: " + med.getDosage());
    //   System.out.println("Frequency: " + med.getFrequency());
    // }
  }
}
