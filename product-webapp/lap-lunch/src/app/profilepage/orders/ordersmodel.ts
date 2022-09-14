export class OrderModel {
  orderId!: number;
  userEmailId!: string;
  totalPrice!: number;
  time!: String;
  itemsList!: menuModel[];
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
