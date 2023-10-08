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

  @Test public void checkoutAllSimple() {
    assertThat(checkoutSolution.checkout("ABC"), equalTo(100));
    assertThat(checkoutSolution.checkout("ABCA"), equalTo(150));
    assertThat(checkoutSolution.checkout("CD"), equalTo(35));
  }

  @Test public void checkoutOfferA() {
    assertThat(checkoutSolution.checkout("ABCAA"), equalTo(180));
  }

  @Test public void checkoutOfferB() {
    assertThat(checkoutSolution.checkout("BB"), equalTo(45));
  }

  @Test public void checkoutWrong() {
    assertThat(checkoutSolution.checkout("CDX"), equalTo(-1));
  }

  @Test public void checkoutOffers() {
    assertThat(checkoutSolution.checkout("AAABB"), equalTo(175));
  }

  @Test public void checkoutMultipleOffers() {
    assertThat(checkoutSolution.checkout("AAAAAABB"), equalTo(200+50+45));
    assertThat(checkoutSolution.checkout("AAABB"), equalTo(130+45));
    assertThat(checkoutSolution.checkout("AAAAAAAA"), equalTo(200+130));
    assertThat(checkoutSolution.checkout("BBB"), equalTo(45+30));
    assertThat(checkoutSolution.checkout("BBBC"), equalTo(45+30+20));
    assertThat(checkoutSolution.checkout("AAAAA"), equalTo(200));
    assertThat(checkoutSolution.checkout("BBEEB"), equalTo(45+80));
    assertThat(checkoutSolution.checkout("AAABBCDE"), equalTo(130+45+20+15+40));
  }

  @Test public void checkoutE() {
    assertThat(checkoutSolution.checkout("EE"), equalTo(80));
  }

  @Test public void checkoutFreeItem() {
    assertThat(checkoutSolution.checkout("BBEE"), equalTo(30+80));
    assertThat(checkoutSolution.checkout("BBEEB"), equalTo(45+80));
  }

  @Test public void checkoutEmpty() {
    assertThat(checkoutSolution.checkout(""), equalTo(0));
  }

}




