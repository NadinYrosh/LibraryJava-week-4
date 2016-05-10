import org.junit.*;
import org.sql2o.*;
// import java.util.List;
// import java.util.ArrayList;

import static org.junit.Assert.*;

public class AuthorTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Author_instantiatesCorrectly_true() {
    Author myAuthor = new Author("Dave", "Smith");
    assertEquals(true, myAuthor instanceof Author);
  }

  @Test
  public void getFirstName_instantiatesWithFirstName_string() {
    Author myAuthor = new Author("Dave", "Smith");
    assertEquals("Dave", myAuthor.getFirstName());
  }

  @Test
  public void getLastName_instantiatesWithLastName_string() {
    Author myAuthor = new Author("Dave", "Smith");
    assertEquals("Smith", myAuthor.getLastName());
  }


}
