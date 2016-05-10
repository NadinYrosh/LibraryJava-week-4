public class Author {
  String first_name;
  String last_name;

  public Author (String firstName, String lastName) {
    this.first_name = firstName;
    this.last_name = lastName;
  }

  public String getFirstName() {
    return this.first_name;
  }

  public String getLastName() {
    return this.last_name;
  }
}
