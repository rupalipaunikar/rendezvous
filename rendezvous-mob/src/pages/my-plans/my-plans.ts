import {Component, ViewChild} from '@angular/core';
import {IonicPage, LoadingController, ModalController, NavController, NavParams, Slides} from 'ionic-angular';
import {OutingPlanServiceProvider} from "../../providers/outing-plan-service/outing-plan-service";
import {ViewOutingPlanPage} from "../view-outing-plan/view-outing-plan";
import {DineOutPlanServiceProvider} from "../../providers/dine-out-plan-service/dine-out-plan-service";
import {MoviePlanServiceProvider} from "../../providers/movie-plan-service/movie-plan-service";
import {ViewDineOutPlanPage} from "../view-dine-out-plan/view-dine-out-plan";
import {ViewMoviePlanPage} from "../view-movie-plan/view-movie-plan";
import {SocialSharing} from "@ionic-native/social-sharing";
import {OutingPlan} from "../create-outing/create-outing";
import {DineOutPlan} from "../create-dine-out/create-dine-out";
import {MoviePlan} from "../create-movie/create-movie";

declare var AWS: any;

@IonicPage()
@Component({
  selector: 'page-my-plans',
  templateUrl: 'my-plans.html',
})
export class MyPlansPage {

  @ViewChild('SwipedTabsSlider') SwipedTabsSlider: Slides;
  SwipedTabsIndicator: any = null;
  tabs: any = [];

  public outingPlans: any;
  public dineOutPlans: any;
  public moviePlans: any;

  constructor(public navCtrl: NavController, public navParams: NavParams,
              public  modalCtrl: ModalController,
              public loadingCtrl: LoadingController,
              private outingPlanService: OutingPlanServiceProvider,
              private dineOutPlanService: DineOutPlanServiceProvider,
              private moviePlanService: MoviePlanServiceProvider,
              private socialSharing: SocialSharing) {
    this.tabs = ["Outing", "Dine Out", "Movie"];
  }

  ionViewWillEnter() {
    this.presentLoading();
  }

  ionViewDidEnter() {
    this.SwipedTabsIndicator = document.getElementById("indicator");
  }

  selectTab(index) {
    this.SwipedTabsIndicator.style.webkitTransform = 'translate3d(' + (100 * index) + '%,0,0)';
    this.SwipedTabsSlider.slideTo(index, 500);
  }

  updateIndicatorPosition() {
    // this condition is to avoid passing to incorrect index
    if (this.SwipedTabsSlider.length() > this.SwipedTabsSlider.getActiveIndex()) {
      this.SwipedTabsIndicator.style.webkitTransform = 'translate3d(' + (this.SwipedTabsSlider.getActiveIndex() * 100) + '%,0,0)';
    }

  }

  animateIndicator($event) {
    if (this.SwipedTabsIndicator)
      this.SwipedTabsIndicator.style.webkitTransform = 'translate3d(' + (($event.progress * (this.SwipedTabsSlider.length() - 1)) * 100) + '%,0,0)';
  }

  ionViewDidLoad() {
    let userId = AWS.config.credentials.identityId;
    this.getOutingPlans(userId);
    this.getDineOutPlans(userId);
    this.getMoviePlans(userId);
  }

  getOutingPlans(userId: string) {
    this.outingPlans = [
      {"userId": "1", "planName": "Plan 1", "venue": "Available", "description": "Available", "date": new Date()},
      {"userId": "1", "planName": "Plan 2", "venue": "Available", "description": "Available", "date": new Date()},
      {"userId": "1", "planName": "Plan 3", "venue": "Available", "description": "Available", "date": new Date()},
    ];

    //this.outingPlanService.getOutingPlans().subscribe(data => this.outingPlans = data);
    //console.log(this.outingPlans);
  }

  getDineOutPlans(userId: string) {
    this.dineOutPlanService.getDineOutPlans().subscribe(data => this.dineOutPlans = data);
    console.log(this.dineOutPlans);
  }

  getMoviePlans(userId: string) {
    this.moviePlanService.getMoviePlans().subscribe(data => this.moviePlans = data);
    console.log(this.moviePlans);
  }

  viewOutingPlanSummary(outingPlan) {
    let modal = this.modalCtrl.create(ViewOutingPlanPage, outingPlan);
    modal.present().then();
  }

  viewDineOutPlanSummary(dineOutPlan) {
    let modal = this.modalCtrl.create(ViewDineOutPlanPage, dineOutPlan);
    modal.present().then();
  }

  viewMoviePlanSummary(moviePlan) {
    let modal = this.modalCtrl.create(ViewMoviePlanPage, moviePlan);
    modal.present().then();
  }

  presentLoading() {
    const loader = this.loadingCtrl.create({
      content: "Please wait...",
      duration: 1000
    });
    loader.present().then();
  }

  shareOutingPlan(plan: OutingPlan) {
    let msg = 'Hey!!\nLets plan for an outing to ' + plan.venue + ' on ' + plan.date;
    this.socialSharing.share(msg, null, null, null).then().catch();
  }

  shareDineOutPlan(plan: DineOutPlan) {
    let msg = 'Hey!!\nLets go out for lunch or dinner to ' + plan.venue + ' on ' + plan.date;
    this.socialSharing.share(msg, null, null, null).then().catch();
  }

  shareMoviePlan(plan: MoviePlan) {
    let msg = 'Hey!!\nLets go for a movie - ' + plan.movie + ' on ' + plan.date;
    this.socialSharing.share(msg, null, null, null).then().catch();
  }
}
