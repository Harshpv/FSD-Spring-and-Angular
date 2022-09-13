import { Component, OnInit } from '@angular/core';
import { ApiserviceService  } from '../menuapiservice/apiservice.service';
@Component({
  selector: 'app-timetable',
  templateUrl: './timetable.component.html',
  styleUrls: ['./timetable.component.css']
})
export class TimetableComponent implements OnInit {

  ListofItems: any[]=[];
  constructor(private serviceapi: ApiserviceService) { }

  ngOnInit(): void {
    this.serviceapi.getItem()
    .subscribe(res=>{
      this.ListofItems =res
      console.log(this.ListofItems);

  })

 }}
