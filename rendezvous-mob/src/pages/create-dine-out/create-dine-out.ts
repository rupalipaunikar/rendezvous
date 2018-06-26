import {Component} from '@angular/core';
import {AlertController, IonicPage, NavController, NavParams} from 'ionic-angular';
import {DineOutPlanServiceProvider} from "../../providers/dine-out-plan-service/dine-out-plan-service";

declare var AWS: any;

export class DineOutPlan {
  userId: string;
  planName: string;
  dineOutType: string;
  venue: string;
  description: string;
  date: Date;
}

@IonicPage()
@Component({
  selector: 'page-create-dine-out',
  templateUrl: 'create-dine-out.html',
})
export class CreateDineOutPage {

  public dineOutPlan: DineOutPlan;

  constructor(public navCtrl: NavController, public alertCtrl: AlertController,
              public navParams: NavParams,
              private dineOutPlanService: DineOutPlanServiceProvider) {
    this.dineOutPlan = new DineOutPlan();
  }

  createPlan() {
    this.dineOutPlan.userId = AWS.config.credentials.identityId;
    this.dineOutPlanService.saveDineOutPlan(this.dineOutPlan).subscribe(data => console.log(data));
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
