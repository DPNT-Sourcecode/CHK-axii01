package befaster.solutions.CHK;

public class DiscountStrategy {

  ItemName itemName;
  int numOfItems;
  int discountedPrice;

  public DiscountStrategy(ItemName itemName, int numOfItems, int discountedPrice) {
    this.itemName = itemName;
    this.numOfItems = numOfItems;
    this.discountedPrice = discountedPrice;
  }

  public ItemName getItemName() {
    return itemName;
  }

  public int getNumOfItems() {
    return numOfItems;
  }

  public int getDiscountedPrice() {
    return discountedPrice;
  }
}



