package befaster.solutions.CHK;

enum ItemName {
  A('A'),
  B('B'),
  C('C'),
  D('D'),
  E('E');

  private final char name;

  ItemName(char letter) {
    this.name = letter;
  }

  public char getName() {
    return name;
  }

}
