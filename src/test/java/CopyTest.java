import org.junit.*;
import org.sql2o.*;
import java.util.List;
import static org.junit.Assert.*;

public class CopyTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Copy_instantiatesCorrectly_true(){
    Copy myCopy = new Copy();
    assertEquals(true, myCopy instanceof Copy);
  }
}
