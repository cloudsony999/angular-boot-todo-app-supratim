import { Component, OnInit } from '@angular/core';

import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

  showDeleteButton: boolean = true;

  constructor(private _todoService: TodoService) {
  }

  ngOnInit(): void {
    this.getTodoLen();
  }

  deleteTodosOnClick(): any {
    this._todoService.deleteAllTodos().subscribe(
      response => {
        console.log('DEBUG:', response);
      },
      error => {
        console.log('ERRORES:', error);
        this.getTodoLen();
      }
    );
  }

  getTodoLen(): any {
    this._todoService.getAllTodos().subscribe(
      response => {
        console.log(response);
        if (response.length === 0) {
          this.showDeleteButton = false;
        }
      },
      error => {
        console.log(error);
      }
    );
  }

}
