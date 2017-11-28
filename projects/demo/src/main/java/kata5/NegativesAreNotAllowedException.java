package kata5;

/**
 * Date: 2017-11-28
 * Author: Patryk Kozak @pakz
 */
public class NegativesAreNotAllowedException extends RuntimeException {

  NegativesAreNotAllowedException(String msg) {
    super(msg);
  }

}
