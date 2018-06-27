import {Component} from '@angular/core';
import {IonicPage, NavController, NavParams, ViewController} from 'ionic-angular';
import {MoviePlan} from "../create-movie/create-movie";
import {SearchPlacePage} from "../search-place/search-place";

@IonicPage()
@Component({
  selector: 'page-view-movie-plan',
  templateUrl: 'view-movie-plan.html',
})
export class ViewMoviePlanPage {

  public moviePlan: MoviePlan;

  constructor(public navParams: NavParams, public viewCtrl: ViewController,
              private navCtrl: NavController) {
  }

  ionViewWillLoad() {
    this.moviePlan = this.navParams.data;
    console.log(this.moviePlan)
  }

  dismiss() {
    this.viewCtrl.dismiss().then();
  }

  searchPlace() {
    this.navCtrl.push(SearchPlacePage).then();
  }
}
