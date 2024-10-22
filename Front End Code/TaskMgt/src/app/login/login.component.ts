import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  constructor(public http: HttpClient, public app: AppComponent) {}

  username: string = 'ajay';
  password: string = '123';
  login() {
    let url = 'http://localhost:8080/login' + this.username;
    this.http.post(url, this.password).subscribe((data: any) => {
      if (data > 0) {
        alert('Login Successfully');
        this.app.islogin = 1;
        this.app.userid = data;
      } else if (data == -1) {
        alert('Exception');
      } else if (data == -2) {
        alert('Username Wrong');
      } else if (data == -3) {
        alert('Multiple user');
      } else if (data == -4) {
        alert('Password wrong');
      } else {
        alert('somthing wrong on server');
      }
    });
  }
}
