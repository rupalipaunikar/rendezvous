import {Component} from '@angular/core';
import {IonicPage, NavController, NavParams, ViewController} from 'ionic-angular';
import {DineOutPlan} from "../create-dine-out/create-dine-out";
import {SearchPlacePage} from "../search-place/search-place";

@IonicPage()
@Component({
  selector: 'page-view-dine-out-plan',
  templateUrl: 'view-dine-out-plan.html',
})
export class ViewDineOutPlanPage {

  public dineOutPlan: DineOutPlan;

  constructor(public navParams: NavParams, public viewCtrl: ViewController,
              private navCtrl: NavController) {
  }

  ionViewWillLoad() {
    this.dineOutPlan = this.navParams.data;
    console.log(this.dineOutPlan)
  }

  dismiss() {
    this.viewCtrl.dismiss().then();
  }

  searchPlace() {
    this.navCtrl.push(SearchPlacePage).then();
  }
}
