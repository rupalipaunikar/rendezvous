import { Component } from '@angular/core';
import {IonicPage, NavParams, ViewController} from 'ionic-angular';
import {DineOutPlan} from "../create-dine-out/create-dine-out";

@IonicPage()
@Component({
  selector: 'page-view-dine-out-plan',
  templateUrl: 'view-dine-out-plan.html',
})
export class ViewDineOutPlanPage {

  public dineOutPlan: DineOutPlan;

  constructor(public navParams: NavParams, public viewCtrl: ViewController) {
  }

  ionViewWillLoad(){
    this.dineOutPlan = this.navParams.data;
    console.log(this.dineOutPlan)
  }

  dismiss() {
    this.viewCtrl.dismiss();
  }
}
