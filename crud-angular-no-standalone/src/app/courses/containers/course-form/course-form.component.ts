import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from '../../services/course.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { error } from 'console';
import { MatDialog } from '@angular/material/dialog';
import { SuccessDialogComponent } from '../../../shared/components/success-dialog/success-dialog.component';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrl: './course-form.component.scss'
})
export class CourseFormComponent {

  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: CourseService,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar,
    public dialog: MatDialog
  ){
    this.form = this.formBuilder.group({
      name: [null],
      category: [null]
    })
  }

  onSubmit() {
    this.service.save(this.form.value).subscribe(
      result => this.onSuccess('Curso salvo com sucesso!'),
      error => this.onError('Erro ao salvar curso')
    )
  }

  onCancel() {
    this.router.navigate([''], {relativeTo: this.route});
  }

  onSuccess(msg: string) {
    this.dialog.open(SuccessDialogComponent, {
      data: msg,
    });
  }

  onError(msg: string){
    this.snackBar.open(msg, 'Fechar', {duration: 5000})
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action);
  }

}
