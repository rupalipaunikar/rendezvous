import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';

import {LoadingController} from 'ionic-angular';

@Injectable()
export class SpinnerProvider {

  loader: any;

  constructor(public http: Http, public loadingCtrl: LoadingController) {
    console.log('Hello SpinnerProvider Provider');
  }

  load() {
    this.loader = this.loadingCtrl.create({
      content: ''
    });
    this.loader.present();
  }

  dismiss() {
    if (this.loader) {
      this.loader.dismiss();
      this.loader = null;
    }
  }
}
