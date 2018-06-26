import {NgModule} from '@angular/core';
import {IonicPageModule} from 'ionic-angular';
import {CreateMoviePage} from './create-movie';

@NgModule({
  declarations: [
    CreateMoviePage,
  ],
  imports: [
    IonicPageModule.forChild(CreateMoviePage),
  ],
})
export class CreateMoviePageModule {
}
