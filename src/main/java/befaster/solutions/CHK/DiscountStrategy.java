package befaster.solutions.CHK;

public class DiscountStrategy {

  String itemName;
  int numOfItems;
  int discountedPrice;

  public DiscountStrategy(String itemName, int numOfItems, int discountedPrice) {
    this.itemName = itemName;
    this.numOfItems = numOfItems;
    this.discountedPrice = discountedPrice;
  }

  public String getItemName() {
    return itemName;
  }

  public int getNumOfItems() {
    return numOfItems;
  }

  public int getDiscountedPrice() {
    return discountedPrice;
  }
}
