//java.util.Collection.List.ArrayList;
//java.util.Collection.Set.TreeSet;

import java.util.*;

class Driver
{
  public static void main(String args[])
  {
    //Patients
    Patient ron, brad, julia;
    List<Patient> patients;
    Date birthday = new Date();
    Baby neal = new Baby("Benjamin Potter", birthday, "Europe", "Italy");

    //Birthday converted to Timezones
    System.out.println("After Timezone Conversion: " + neal.convertToTimeZone("Asia", "China"));

    //Addressess
    Address add1 = new Address("1942, Baker Drive","Lenexa","Kansas",66219);
    Address add2 = new Address("1211, Stewart Ave","Lawrence","Kansas",66045);
    Address add3 = new Address("1991, Crestline Dr", "Olathe", "Kansas",66278);

    //Allergies
    Allergy alg1 = new Allergy("Contact Dermatitis", Severity.LOW, "Itchiness");
    Allergy alg2 = new Allergy("Dust", Severity.HIGH, "Redness");
    Allergy alg3 = new Allergy("Cat", Severity.MEDIUM, "Coughing");
    List<Allergy> allergies = new ArrayList<Allergy>();
    allergies.add(alg1);
    allergies.add(alg2);
    allergies.add(alg3);

    //Symptoms of Diseases
    ArrayList<String> sym_asthma = new ArrayList<String>();
    sym_asthma.add("wheezing");
    sym_asthma.add("coughing");

    ArrayList<String> sym_crohn = new ArrayList<String>();
    sym_crohn.add("diarrhoea");
    sym_crohn.add("fatigue");
    sym_crohn.add("cramping");

    ArrayList<String> sym_hiv = new ArrayList<String>();
    sym_hiv.add("fever");
    sym_hiv.add("rash");

    //Diseases
    Disease asthma = new Disease("Asthma", sym_asthma);
    Disease crohn = new Disease("Crohn's Disease", sym_crohn);
    Disease hiv = new Disease("HIV", sym_hiv);

    List<Disease> disease_ron = new ArrayList<Disease>();
    disease_ron.add(asthma);

    List<Disease> disease_brad = new ArrayList<Disease>();
    disease_brad.add(asthma);
    disease_brad.add(crohn);

    List<Disease> disease_julia = new ArrayList<Disease>();
    disease_julia.add(hiv);

    //Medication
    Medication med1 = new Medication("Benadryl","25mg",3);
    Medication med2 = new Medication("Cortef","30mg",2);
    Medication med3 = new Medication("Zidovudine","70mg",1);

    List<Medication> medList = new ArrayList<Medication>();
    medList.add(med1);
    medList.add(med2);
    medList.add(med3);

    List<Medication> medList1 = new ArrayList<Medication>();
    medList1.add(med1);
    medList1.add(med2);

    List<Medication> medList2 = new ArrayList<Medication>();
    medList2.add(med2);
    medList2.add(med3);

    List<Medication> medList3 = new ArrayList<Medication>();
    medList3.add(med3);

    //temperature
    Temperature temp_ron = new Temperature(40, Location.EAR);
    Temperature temp_brad = new Temperature(60, Location.ARMPIT);
    Temperature temp_julia = new Temperature(35, Location.MOUTH);
    Temperature temp_ron1 = new Temperature(40, Location.EAR);
    Temperature temp_brad1 = new Temperature(55, Location.ARMPIT);
    Temperature temp_julia1 = new Temperature(35, Location.EAR);
    Temperature temp_julia2 = new Temperature(38, Location.EAR);
    Set<Double> temperatures = new HashSet<Double>();
    temperatures.add(temp_ron.getTemperature());
    temperatures.add(temp_brad.getTemperature());
    temperatures.add(temp_julia.getTemperature());
    temperatures.add(temp_ron1.getTemperature());
    temperatures.add(temp_brad1.getTemperature());
    temperatures.add(temp_julia1.getTemperature());
    temperatures.add(temp_julia2.getTemperature());


    //Creating the patients
    ron = new Patient("Ron Smith", 22, add1, allergies, disease_ron, medList1, temp_ron1);
    brad = new Patient("Brad Cullen", 35, add2, allergies, disease_brad, medList2, temp_brad1);
    julia = new Patient("Julie Finley", 28, add3, allergies, disease_julia, medList3, temp_julia2);

    patients = new ArrayList<Patient>();
    patients.add(ron);
    patients.add(brad);
    patients.add(julia);

    //Printing Patient  Details
    for(int i = 0 ; i < patients.size() ; i++)
    {
      System.out.println();
      System.out.println("Patient Name: " + patients.get(i).getName());
      System.out.println("Patient Age: " + patients.get(i).getAge());
      System.out.println("Patient Address: " + patients.get(i).getFullAddress());
      System.out.println("Patient Allergies: " + patients.get(i).getFullAllergies());
      System.out.println("Patient Disease: " + patients.get(i).getFullDiseases());
      System.out.println("Patient Medication: " + patients.get(i).getFullMedications());
      System.out.println("Patient Temperature: " + patients.get(i).getTemperature().getTemperature() + " measured at Location: " + patients.get(i).getTemperature().getLocation());
    }

    /*
       The Functions begin here
    */

    System.out.println("\n\n Check if a patient has Fever or Not");

    //Check if a patient has Fever or Not
    if(ron.hasFever())
      System.out.println("Ron has Fever with temperature: " + ron.getTemperature().getTemperature());
    else
      System.out.println("Ron has NO Fever with temperature: " + ron.getTemperature().getTemperature());

    if(brad.hasFever())
      System.out.println("Brad has Fever with temperature: " + brad.getTemperature().getTemperature());
    else
      System.out.println("Brad has NO Fever with temperature: " + brad.getTemperature().getTemperature());

    if(julia.hasFever())
      System.out.println("Julia has Fever with temperature: " + julia.getTemperature().getTemperature());
    else
      System.out.println("Julia has NO Fever with temperature: " + julia.getTemperature().getTemperature());

    System.out.println("\n\n Tell the Nurse Frequency of a Medicine");

    //Tell the Nurse Frequency of a Medicine

    for(int i = 0; i < medList.size(); i++)
    {
      System.out.println();
      System.out.println("Medicine Name: " + medList.get(i).getMname() + " and Frequency: " + medList.get(i).getFrequency());
    }

    System.out.println("\n\n Top 3 Temperatures");

    //Top 3 Temperatures - remove duplicates using Set and Ordered using TreeSet

    List<Double> temp_ordered = new ArrayList<Double>();
    temp_ordered.addAll(temperatures);

    Collections.sort(temp_ordered, Collections.reverseOrder()); //sort in descending order

    for(int i = 0; i < 3; i++)
    {
      System.out.println(temp_ordered.get(i));
    }

    // for(Double temp : temperatures)
    // {
    //   System.out.println("Temperature: " + temp);
    // }

    System.out.println("\n\n Search Allergy Based on Symptoms");

    //Search Allergy Based on Symptoms - Reference: Main.java
    Allergy.searchAllergy(allergies, "Itchiness");

  }
}
