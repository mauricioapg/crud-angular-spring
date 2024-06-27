import { Component } from '@angular/core';
import { Course } from '../../model/course'
import { CourseService } from '../../services/course.service';
import { Observable } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from '../../../shared/components/error-dialog/error-dialog.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrl: './courses.component.scss'
})
export class CoursesComponent {
  courses$: Observable<Course[]>;

  displayedColumns = ['name', 'category', 'actions'];

  constructor(
    private service: CourseService,
    private router: Router,
    private route: ActivatedRoute,
    public dialog: MatDialog
  ) {
    this.courses$ = this.service.listAll();

    // .pipe(
    // catchError(error => {
    // this.onError('Erro ao listar cursos...')
    // return of([])
    // })
    // );
  }

  onError(msg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: msg,
    });
  }

  ngOnInit(): void {

  }

  onAdd() {
    this.router.navigate(['new'], {relativeTo: this.route});
  }

  onDelete() {
    this.service.delete('667adebd4d00c16054a39a84')
  }
}
