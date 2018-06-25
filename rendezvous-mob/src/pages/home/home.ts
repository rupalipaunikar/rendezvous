import {Component} from '@angular/core';
import {IonicPage, NavController, NavParams} from 'ionic-angular';
import {CreateOutingPage} from "../create-outing/create-outing";
import {CreateDineOutPage} from "../create-dine-out/create-dine-out";
import {CreateMoviePage} from "../create-movie/create-movie";

@IonicPage()
@Component({
  selector: 'page-home',
  templateUrl: 'home.html',
})
export class HomePage {

  public createOutingPage = CreateOutingPage;
  public createDineOutPage = CreateDineOutPage;
  public createMoviePage = CreateMoviePage;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }
}
