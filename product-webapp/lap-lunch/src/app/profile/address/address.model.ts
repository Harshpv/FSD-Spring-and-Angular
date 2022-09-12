export class userModel {
  userEmailId!: string;
  firstName!: string;
  lastName!: string;
  password: string = '';
  address!: addressModel[];
}

export class addressModel {
  houseId!: number;
  houseNum!: string;
  street!: string;
  city!: string;
  state!: string;
  pincode!: number;
}
