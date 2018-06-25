import { Component } from '@angular/core';
import {AlertController, IonicPage, NavController, NavParams} from 'ionic-angular';
import {MoviePlanServiceProvider} from "../../providers/movie-plan-service/movie-plan-service";

declare var AWS: any;

export class MoviePlan {
  userId: string;
  planName: string;
  movie: string;
  description: string;
  date: Date;
}

@IonicPage()
@Component({
  selector: 'page-create-movie',
  templateUrl: 'create-movie.html',
})
export class CreateMoviePage {

  public moviePlan : MoviePlan;

  constructor(public navCtrl: NavController, public alertCtrl: AlertController,
              public navParams: NavParams,
              private moviePlanService: MoviePlanServiceProvider) {
    this.moviePlan = new MoviePlan();
  }

  createPlan(){
    this.moviePlan.userId = AWS.config.credentials.identityId;
    this.moviePlanService.saveMoviePlan(this.moviePlan).subscribe(data => console.log(data));
    this.showCreatePlanAlert();
  }

  showCreatePlanAlert() {
    const alert = this.alertCtrl.create({
      title: 'Great!!',
      subTitle: 'Your plan was created successfully!',
      buttons: ['OK']
    });
    alert.present();
    this.navCtrl.setRoot('HomePage');
  }
}
