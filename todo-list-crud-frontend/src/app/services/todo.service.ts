import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Todo } from '../models/todo.model';

@Injectable({
  providedIn: 'root'
})

export class TodoService {

  private _baseURL: string = 'http://localhost:8888/todo/api';

  private _addTodoAPI: string = `${this._baseURL}/todo`;
  private _getAllTodosAPI: string = `${this._baseURL}/todos`;

  private _deleteTodoAPI: string = this._addTodoAPI;
  private _updateTodoAPI: string = this._deleteTodoAPI;
  private _deleteAllTodosAPI: string = this._getAllTodosAPI;

  constructor(private _httpClient: HttpClient) {
  }

  getAllTodos(): Observable<Todo[]> {
    return this._httpClient.get<Todo[]>(this._getAllTodosAPI);
  }

  addTodo(todo: Todo): Observable<Todo> {
    return this._httpClient.post<Todo>(this._addTodoAPI, todo);
  }

  deleteTodo(title: string): Observable<any> {
    return this._httpClient.delete<any>(`${this._deleteTodoAPI}/${title}`);
  }

  updateTodo(title: string): Observable<Object> {
    return this._httpClient.put<any>(`${this._updateTodoAPI}/${title}`, null);
  }

  deleteAllTodos(): Observable<any> {
    return this._httpClient.delete(`${this._deleteAllTodosAPI}`);
  }

}
