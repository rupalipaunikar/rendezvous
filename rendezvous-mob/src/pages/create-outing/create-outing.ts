import {Component} from '@angular/core';
import {AlertController, IonicPage, NavController, NavParams} from 'ionic-angular';
import {OutingPlanServiceProvider} from "../../providers/outing-plan-service/outing-plan-service";

declare var AWS: any;

export class OutingPlan {
  userId: string;
  planName: string;
  venue: string;
  description: string;
  date: Date;
}

@IonicPage()
@Component({
  selector: 'page-create-outing',
  templateUrl: 'create-outing.html',
})
export class CreateOutingPage {

  public outingPlan: OutingPlan;

  constructor(public navCtrl: NavController, public alertCtrl: AlertController,
              public navParams: NavParams,
              private outingPlanService: OutingPlanServiceProvider) {
    this.outingPlan = new OutingPlan();
  }

  createPlan() {
    this.outingPlan.userId = AWS.config.credentials.identityId;
    this.outingPlanService.saveOutingPlan(this.outingPlan).subscribe(data => console.log(data));
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
