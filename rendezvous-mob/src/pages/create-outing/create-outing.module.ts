import {NgModule} from '@angular/core';
import {IonicPageModule} from 'ionic-angular';
import {CreateOutingPage} from './create-outing';

@NgModule({
  declarations: [
    CreateOutingPage,
  ],
  imports: [
    IonicPageModule.forChild(CreateOutingPage)
  ],
})
export class CreateOutingPageModule {
}
