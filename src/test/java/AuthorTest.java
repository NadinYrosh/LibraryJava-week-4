import org.junit.*;
import org.sql2o.*;
import java.util.List;
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

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Author.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAreTheSame_true() {
    Author firstAuthor = new Author("Dave", "Smith");
    Author secondAuthor = new Author("Dave", "Smith");
    assertTrue(firstAuthor.equals(secondAuthor));
  }

  @Test
  public void save_savesObjectIntoDatabase_true() {
    Author myAuthor = new Author("Dave", "Smith");
    myAuthor.save();
    assertTrue(Author.all().get(0).equals(myAuthor));
  }

  @Test
  public void save_assignsIdToObject() {
    Author myAuthor = new Author("Dave", "Smith");
    myAuthor.save();
    Author savedAuthor = Author.all().get(0);
    assertEquals(myAuthor.getId(), savedAuthor.getId());
  }

  @Test
  public void find_findsAuthorsInDatabase_True() {
    Author myAuthor = new Author("Dave", "Smith");
    myAuthor.save();
    Author savedAuthor = Author.find(myAuthor.getId());
    assertTrue(myAuthor.equals(savedAuthor));
  }

  @Test
  public void update_updatesAuthorFirstName_true() {
    Author myAuthor = new Author("Dave", "Smith");
    myAuthor.save();
    myAuthor.update("Stephen", "Smith");
    assertEquals("Stephen", Author.find(myAuthor.getId()).getFirstName());
  }

  @Test
  public void update_updatesAuthorLastName_true() {
    Author myAuthor = new Author("Dave", "Smith");
    myAuthor.save();
    myAuthor.update("Dave", "Wells");
    assertEquals("Wells", Author.find(myAuthor.getId()).getLastName());
  }

  @Test
  public void delete_deletesAuthor_true() {
    Author myAuthor = new Author("Dave", "Smith");
    myAuthor.save();
    int myAuthorId = myAuthor.getId();
    myAuthor.delete();
    assertEquals(null, Author.find(myAuthorId));
  }

  // @Test
  // public void addCategory_addsCategoryToTask() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   Task myTask = new Task("Mow the lawn");
  //   myTask.save();
  //   myTask.addCategory(myCategory);
  //   Category savedCategory = myTask.getCategories().get(0);
  //   assertTrue(myCategory.equals(savedCategory));
  // }
  //
  // @Test
  // public void getCategories_returnsAllCategories_List() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   Task myTask = new Task("Mow the lawn");
  //   myTask.save();
  //   myTask.addCategory(myCategory);
  //   List savedCategories = myTask.getCategories();
  //   assertEquals(1, savedCategories.size());
  // }
  //
  //
  // @Test
  // public void delete_deletesAllTasksAndCategoriesAssociations() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   Task myTask = new Task("Mow the lawn");
  //   myTask.save();
  //   myTask.addCategory(myCategory);
  //   myTask.delete();
  //   assertEquals(0, myCategory.getTasks().size());
  // }

}
