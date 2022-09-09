import { RecommendationService } from './../../recommendation.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recommendation',
  templateUrl: './recommendation.component.html',
  styleUrls: ['./recommendation.component.css']
})
export class RecommendationComponent implements OnInit {
  data: any = []
  constructor(private recommendation:RecommendationService) {
    this.recommendation.getData().subscribe(data=>{
      console.log(data);
      this.data = data;
      
    })
   }

  ngOnInit(): void {
  }

}
