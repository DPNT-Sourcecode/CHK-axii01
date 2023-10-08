package befaster.solutions.CHK;

public class DiscountStrategy {
  Item item;
  int numOfItems;
  int discountedPrice;

  public DiscountStrategy(Item item, int numOfItems, int discountedPrice) {
    this.item = item;
    this.numOfItems = numOfItems;
    this.discountedPrice = discountedPrice;
  }

  public Item getItem() {
    return item;
  }

  public int getNumOfItems() {
    return numOfItems;
  }

  public int getDiscountedPrice() {
    return discountedPrice;
  }
}


