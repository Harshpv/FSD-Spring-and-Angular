export class OrderModel {
  orderId!: number;
  userEmailId!: string;
  private totalPrice!: number;
  time!: String;
  itemsList!: menuModel[];

  getTotalPrice(): number {
    var a: number = 0;
    var i;
    for (i = 0; i < this.itemsList.length; i++) {
      a = a + this.itemsList[i].itemCost;
    }
    return a;
  }
}

export class menuModel {
  itemId!: number;
  itemName!: string;
  itemDescription!: string;
  qty!: number;
  isVeg!: boolean;
  itemCost!: number;
  image!: string;
}
