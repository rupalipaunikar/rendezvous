import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { CreateDineOutPage } from './create-dine-out';

@NgModule({
  declarations: [
    CreateDineOutPage,
  ],
  imports: [
    IonicPageModule.forChild(CreateDineOutPage),
  ],
})
export class CreateDineOutPageModule {}
