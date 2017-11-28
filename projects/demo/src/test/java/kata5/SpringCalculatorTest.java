package kata5;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

/**
 * Date: 2017-11-28
 * Author: Patryk Kozak @pakz
 */
public class SpringCalculatorTest {

  private SpringCalculator springCalculator = new SpringCalculator();

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void emptyStringShouldReturnZero() {
    //given
    String testData = "";
    //when
    int result = springCalculator.add(testData);
    //then
    assertEquals(result, 0);
  }

  @Test
  public void whenOneNumbersPassedReturnIt() {
    //given
    String testData = "1";
    //when
    int result = springCalculator.add(testData);
    //then
    assertEquals(result, 1);
  }

  @Test
  public void twoNumbersShouldReturnTheirSum() {
    //given
    String testData = "1,2";
    //when
    int result = springCalculator.add(testData);
    //then
    assertEquals(result, 3);
  }

  @Test
  public void shouldSumMoreThenTwoNumbers() {
    //given
    String testData = "1,2,3,4,5";
    //when
    int result = springCalculator.add(testData);
    //then
    assertEquals(result, 15);
  }

  @Test
  public void shouldSumNumbersWhenCommaAndNewLineDelimiter() {
    //given
    String testData = "1\n2,3,4\n5";
    //when
    int result = springCalculator.add(testData);
    //then
    assertEquals(result, 15);
  }

  @Test
  public void shouldSumNumbersWithCustomDelimiter() {
    //given
    String testData = "//;\n1;2;3";
    //when
    int result = springCalculator.add(testData);
    //then
    assertEquals(result, 6);
  }

  @Test
  public void shouldThrowExceptionWhenNegativeNumbersArePassed() {
    //expect
    expectedException.expect(NegativesAreNotAllowedException.class);
    expectedException.expectMessage("negatives are not allowed: -1 -3 -5 ");
    //given
    String testData = "//;\n-1;2;-3;4;-5";
    //when
    int result = springCalculator.add(testData);
  }

  @Test
  public void numbersBiggerThenThousandShouldBeIgnored() {
    //given
    String testData = "3,4,5,2567";
    //when
    int result = springCalculator.add(testData);
    //then
    assertEquals(result, 12);
  }

  @Test
  public void customDelimiterCanBeLongerThenOneChar() {
    //given
    String testData = "//[****]\n1[****]2[****]3";
    //when
    int result = springCalculator.add(testData);
    //then
    assertEquals(result, 6);
  }

  @Test
  public void moreThenOneCustomDelimeterDefined() {
    //given
    String testData = "//[**][^^]\n1[**]2[**]3[^^]4[^^]5";
    //when
    int result = springCalculator.add(testData);
    //then
    assertEquals(result, 15);
  }

}
