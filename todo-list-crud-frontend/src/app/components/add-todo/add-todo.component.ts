import { Component, EventEmitter, OnInit, Output } from '@angular/core';

import { Todo } from 'src/app/models/todo.model';

@Component({
  selector: 'app-add-todo',
  templateUrl: './add-todo.component.html',
  styleUrls: ['./add-todo.component.css']
})

export class AddTodoComponent implements OnInit {

  title!: string;
  desc!: string;

  todo: Todo = {
    title: '',
    description: '',
    active: true
  };

  @Output() todoAdd: EventEmitter<Todo> = new EventEmitter();

  constructor() {
  }

  ngOnInit(): void {
  }

  submitOnClick(): void {
    this.todo.title = this.title;
    this.todo.description = this.desc;
    this.todoAdd.emit(this.todo);
  }

}
