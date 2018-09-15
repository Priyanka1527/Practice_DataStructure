import java.util.*;

public class Fever
{
  private double temperature;

  public Fever(double temperature)
  {
    this.temperature=temperature;
    checkFever(temperature);
  }

  public void checkFever(double temperature)
  {
    if(temperature >= 38)
      System.out.println("This person has Fever with body temperature: " + temperature);
    else
      System.out.println("This person doesn't have fever and body temperature is: " + temperature);
  }
}
