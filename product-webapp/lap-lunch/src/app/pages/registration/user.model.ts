import { Address } from "./address.model";

export class User {
    constructor(
        public userEmailId : string,
        public firstName : string,
        public lastName : string,
        public password : string,
        public address: Address[]
    ) {}
}