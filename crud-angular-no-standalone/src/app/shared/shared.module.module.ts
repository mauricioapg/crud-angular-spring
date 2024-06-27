import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import { AppMaterialModule } from './app-material/app-material.module';
import { SuccessDialogComponent } from './components/success-dialog/success-dialog.component'

@NgModule({
  declarations: [
    ErrorDialogComponent,
    SuccessDialogComponent
  ],
  imports: [
    CommonModule,
    AppMaterialModule
  ],
  exports: [ErrorDialogComponent]
})
export class SharedModuleModule { }
