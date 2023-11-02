import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'frontend';
  private apiUrl = "http://localhost:8080/recipe/getAll";
  recipes: any[]

  constructor(private http: HttpClient, private router: Router) {
    this.recipes = []
  }

  getAllRecipes() {
    return this.http.get(this.apiUrl);
  }

  ngOnInit(): void {
    this.getAllRecipes().subscribe((data: any) => {
      this.recipes = data;
    })
  }
}
