import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoursesRoutingModule } from './courses-routing.module';
import { CoursesComponent } from './courses.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModuleModule } from '../shared/shared.module.module';


@NgModule({
  declarations: [
    CoursesComponent
  ],
  imports: [
    CommonModule,
    CoursesRoutingModule,
    AppMaterialModule,
    SharedModuleModule
  ]
})
export class CoursesModule { }
