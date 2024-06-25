import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../model/course';
import { delay, first } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private urlAPI = 'http://localhost:8080/api/v1/courses'

  constructor(private httpClient: HttpClient) { }

  listAll() {
    return this.httpClient.get<Course[]>(this.urlAPI)
      .pipe(
        first()
      )
  }
}
