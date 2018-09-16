class Person
{
  private String name, phone, email;
  private Address address;

  public Person(String name, String phone, String email, Address address)
  {
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.address = address;
  }

  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }

  public String getPhone()
  {
    return phone;
  }
  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public String getEmail()
  {
    return email;
  }
  public void setEmail(String email)
  {
    this.email = email;
  }

  public Address getAddress()
  {
    return address;
  }
  public void setName(Address address)
  {
    this.address = address;
  }
}
