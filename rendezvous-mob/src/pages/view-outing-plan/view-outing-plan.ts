import {Component} from '@angular/core';
import {IonicPage, NavController, NavParams, ViewController} from 'ionic-angular';
import {OutingPlan} from "../create-outing/create-outing";
import {SearchPlacePage} from "../search-place/search-place";

@IonicPage()
@Component({
  selector: 'page-view-outing-plan',
  templateUrl: 'view-outing-plan.html',
})
export class ViewOutingPlanPage {

  public outingPlan: OutingPlan;

  constructor(public navParams: NavParams, public viewCtrl: ViewController,
              private navCtrl: NavController) {
  }

  ionViewWillLoad() {
    this.outingPlan = this.navParams.data;
    console.log(this.outingPlan)
  }

  dismiss() {
    this.viewCtrl.dismiss().then();
  }

  searchPlace() {
    this.navCtrl.push(SearchPlacePage).then();
  }
}
