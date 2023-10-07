package befaster.solutions.CHK;

import befaster.solutions.HLO.HelloSolution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class CheckoutSolutionTest {

  private CheckoutSolution checkoutSolution;

  @BeforeEach public void setUp() {
    checkoutSolution = new CheckoutSolution();
  }

  @Test public void hello() {
    assertThat(checkoutSolution.checkout("ABC"), equalTo(100));
  }

}
