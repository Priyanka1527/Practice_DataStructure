class Medication
{
  private String mname;
  private String dosage;
  private int frequency;

  public Medication(String mname, String dosage, int frequency)
  {
    this.mname = mname;
    this.dosage = dosage;
    this.frequency = frequency;
  }

  public void setMname(String mname)
  {
    this.mname = mname;
  }
  public String getMname()
  {
    return mname;
  }

  public void etDosage(String dosage)
  {
    this.dosage = dosage;
  }
  public String getDosage()
  {
    return dosage;
  }

  public void getFrequency(int frequency)
  {
    this.frequency = frequency;
  }
  public int getFrequency()
  {
    return frequency;
  }
}
