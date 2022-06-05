import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { Todo } from 'src/app/models/todo.model';

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.css']
})

export class TodoItemComponent implements OnInit {

  @Input() todoItem!: Todo;
  @Input() todoTitle?: string;
  @Output() todoDelete: EventEmitter<string> = new EventEmitter();
  @Output() todoUpdate: EventEmitter<string> = new EventEmitter();

  constructor() {
  }

  ngOnInit(): void {
  }

  deleteOnClick(): void {
    this.todoDelete.emit(this.todoTitle);
  }

  checkBoxOnClick(): void {
    this.todoUpdate.emit(this.todoTitle);
  }

}
