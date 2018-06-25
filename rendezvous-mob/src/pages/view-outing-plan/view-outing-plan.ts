import { Component } from '@angular/core';
import {IonicPage, NavParams, ViewController} from 'ionic-angular';
import {OutingPlan} from "../create-outing/create-outing";

@IonicPage()
@Component({
  selector: 'page-view-outing-plan',
  templateUrl: 'view-outing-plan.html',
})
export class ViewOutingPlanPage {

  public outingPlan: OutingPlan;

  constructor(public navParams: NavParams, public viewCtrl: ViewController) {
  }

  ionViewWillLoad(){
    this.outingPlan = this.navParams.data;
    console.log(this.outingPlan)
  }

  dismiss() {
    this.viewCtrl.dismiss();
  }
}
