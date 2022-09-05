import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any[], filterString: string): any {
    const results=[];
    if(value.length===0 || filterString===' '){
      return value;
    }

    // value.forEach((a:any)=>{
    //   if(a[propName].trim().toLowerCase().includes(filterString.toLocaleLowerCase()))
    //     result.push(a);
    // });

    for (const result of value) {

      if((result['itemName']===filterString)){
        results.push(result);
      }
      
    }
    return results;
  }

}
