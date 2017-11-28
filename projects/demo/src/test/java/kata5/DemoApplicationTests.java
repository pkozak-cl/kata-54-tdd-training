package kata5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

  @Test
  public void contextLoads() {
    String[] strings = new String[2];
    strings[0] = "1";
    strings[1] = "2";
    DemoApplication.main(strings);
  }

}
