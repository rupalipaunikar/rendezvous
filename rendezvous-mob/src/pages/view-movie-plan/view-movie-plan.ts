import {Component} from '@angular/core';
import {IonicPage, NavParams, ViewController} from 'ionic-angular';
import {MoviePlan} from "../create-movie/create-movie";

@IonicPage()
@Component({
  selector: 'page-view-movie-plan',
  templateUrl: 'view-movie-plan.html',
})
export class ViewMoviePlanPage {

  public moviePlan: MoviePlan;

  constructor(public navParams: NavParams, public viewCtrl: ViewController) {
  }

  ionViewWillLoad() {
    this.moviePlan = this.navParams.data;
    console.log(this.moviePlan)
  }

  dismiss() {
    this.viewCtrl.dismiss().then();
  }
}
