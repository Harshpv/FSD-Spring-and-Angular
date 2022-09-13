import { Address } from "./address.model";

export class User {
    userEmailId!: string;
    firstName!: string;
    lastName!: string;
    password: string = '';
    address!: Address[];
}