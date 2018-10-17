class Temperature
{
  private double temperature;
  private Location location;

  public Temperature(double temperature, Location location)
  {
    this.temperature = temperature;
    this.location = location;
  }

  public double getTemperature()
  {
    return temperature;
  }
  public void setTemperature()
  {
    this.temperature = temperature;
  }

  public Location getLocation()
  {
    return location;
  }
  public void setLocation()
  {
    this.location = location;
  }
}
