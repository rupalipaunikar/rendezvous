import {NgModule} from '@angular/core';
import {IonicPageModule} from 'ionic-angular';
import {ViewMoviePlanPage} from './view-movie-plan';

@NgModule({
  declarations: [
    ViewMoviePlanPage,
  ],
  imports: [
    IonicPageModule.forChild(ViewMoviePlanPage),
  ],
})
export class ViewMoviePlanPageModule {
}
