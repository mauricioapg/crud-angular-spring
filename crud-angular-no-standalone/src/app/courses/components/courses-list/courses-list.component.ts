import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Course } from '../../model/course';

@Component({
  selector: 'app-courses-list',
  templateUrl: './courses-list.component.html',
  styleUrl: './courses-list.component.scss'
})
export class CoursesListComponent {

  @Input() courses: Course[] = [];
  @Output() delete = new EventEmitter(false);

  readonly displayedColumns = ['name', 'category', 'actions'];

  constructor(){}

  onDelete() {
    this.delete.emit(true);
  }

}
