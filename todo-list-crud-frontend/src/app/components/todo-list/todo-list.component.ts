import { Component, OnInit } from '@angular/core';

import { Todo } from 'src/app/models/todo.model';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})

export class TodoListComponent implements OnInit {

  todos: Todo[];

  constructor(private _todoService: TodoService) {
    this.todos = [];
  }

  ngOnInit(): void {
    this.fetchTodos();
  }

  fetchTodos(): void {
    this._todoService.getAllTodos().subscribe(
      response => {
        console.log(response);
        this.todos = response;
      },
      error => {
        console.log(error);
      }
    );
  }

  addTodo(todo: Todo): void {
    this._todoService.addTodo(todo).subscribe(
      response => {
        console.log(response);
        this.fetchTodos();
      },
      error => {
        console.log(error);
      }
    );
  }

  deleteTodo(todoTitle: string): void {
    this._todoService.deleteTodo(todoTitle).subscribe(
      response => {
        console.log('DEBUG:', response);
      },
      error => {
        console.log('ERROR:', error);
        this.fetchTodos();
      }
    );
  }

  updateTodo(title: string): void {
    this._todoService.updateTodo(title).subscribe(
      response => {
        console.log(response);
        this.fetchTodos();
      },
      error => {
        console.log(error);
      }
    );
  }

}
