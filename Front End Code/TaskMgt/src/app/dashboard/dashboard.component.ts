import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  tasks:any;
  constructor(public http:HttpClient,public app:AppComponent)
  {
   let url='http://localhost:8080/read'+this.app.userid;
    this.http.get(url).subscribe((data:any)=>
    
    {
      this.tasks=data;
    });
  }

  logout()
  {
    alert('Are you sure to Logout.')
    this.app.islogin=0;
  }

  details:string='';
  add()
  {

   let url='http://localhost:8080/add'+this.app.userid;
    this.http.post(url,this.details).subscribe((data:any)=>
    {
      if(data==null)
      {
        alert('exception')
      }
      else{
        this.tasks.push(data);
        this.details='';
      }

    }
    );
    
  }
  delete(task:any)
  {
    alert('Are you sure to delete '+task.details +' task.');
   let url='http://localhost:8080/delete'+task.id;
    this.http.get(url).subscribe((data:any)=>
    {
    if(data==1)
    {
      let index=this.tasks.indexOf(task);
      if(index >= 0)
      {
        this.tasks.splice(index,1);

      }
    }
    else{
      alert('Exception..')
    
    }
    });

  }
}
