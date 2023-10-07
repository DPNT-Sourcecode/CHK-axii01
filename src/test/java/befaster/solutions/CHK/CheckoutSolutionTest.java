package befaster.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CheckoutSolutionTest {

  private CheckoutSolution checkoutSolution;

  @BeforeEach public void setUp() {
    checkoutSolution = new CheckoutSolution();
  }

  @Test public void checkout1() {
    assertThat(checkoutSolution.checkout("ABC"), equalTo(100));
  }

  @Test public void checkoutAllSimple() {
    assertThat(checkoutSolution.checkout("ABCA"), equalTo(150));
  }

  @Test public void checkoutOfferA() {
    assertThat(checkoutSolution.checkout("ABCAA"), equalTo(180));
  }

  @Test public void checkoutOfferB() {
    assertThat(checkoutSolution.checkout("BB"), equalTo(45));
  }

  @Test public void checkoutCD() {
    assertThat(checkoutSolution.checkout("CD"), equalTo(35));
  }

  @Test public void checkoutWrong() {
    assertThat(checkoutSolution.checkout("CDE"), equalTo(-1));
  }

  @Test public void checkoutOffers() {
    assertThat(checkoutSolution.checkout("AAABB"), equalTo(175));
  }

  @Test public void checkoutMultipleOffers() {
    assertThat(checkoutSolution.checkout("AAAAAABB"), equalTo(260+45));
    assertThat(checkoutSolution.checkout("AAABB"), equalTo(130+45));
    assertThat(checkoutSolution.checkout("AAAAAAA"), equalTo(260+50));
    assertThat(checkoutSolution.checkout("BBB"), equalTo(45+30));
    assertThat(checkoutSolution.checkout("BBBC"), equalTo(45+30+20));
  }

}
