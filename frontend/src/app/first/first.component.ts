import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent {
  private apiUrl:string = "http://localhost:8080/recipe/getAll";
  recipes: any[]
  constructor(private http: HttpClient) {
    this.recipes = []
  }

  getAllRecipes(){
    return this.http.get(this.apiUrl);
  }

  ngOnInit(): void {
    this.getAllRecipes().subscribe((data: any) => {
      this.recipes = data;
    })
  }
}
