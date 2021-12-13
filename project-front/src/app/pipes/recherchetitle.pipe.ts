import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'recherchetitle'
})
export class RecherchetitlePipe implements PipeTransform {

  transform(value:any,term:any ): any {
    if(term==null){
      return value;
    }else{
      return value.filter((item:any)=>(item.titre.includes(term)));
    }
  }

}
