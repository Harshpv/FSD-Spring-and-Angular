import { Menu } from "./menu.model";

export class Cart {
   
    constructor(
    public userEmailId : string,
    public items:Menu[] ){}
    
}