import {BrowserModule} from '@angular/platform-browser';
import {ErrorHandler, NgModule} from '@angular/core';
import {IonicApp, IonicErrorHandler, IonicModule} from 'ionic-angular';
import {SplashScreen} from '@ionic-native/splash-screen';
import {StatusBar} from '@ionic-native/status-bar';

import {Camera} from '@ionic-native/camera';

import {MyApp} from './app.component';
import {LoginPage} from '../pages/login/login';
import {SignupPage} from '../pages/signup/signup';
import {ConfirmPage} from '../pages/confirm/confirm';
import {AboutPage} from '../pages/about/about';

import {User} from '../providers/user';
import {Cognito} from '../providers/aws.cognito';
import {DynamoDB} from '../providers/aws.dynamodb';
import {MenuPage} from "../pages/menu/menu";
import {MyPlansPage} from "../pages/my-plans/my-plans";
import {NotificationsPage} from "../pages/notifications/notifications";
import {CreateOutingPage} from "../pages/create-outing/create-outing";
import {CreateDineOutPage} from "../pages/create-dine-out/create-dine-out";
import {CreateMoviePage} from "../pages/create-movie/create-movie";
import {HttpModule} from "@angular/http";
import {OutingPlanServiceProvider} from '../providers/outing-plan-service/outing-plan-service';
import {HttpClientModule} from "@angular/common/http";
import {ViewOutingPlanPage} from "../pages/view-outing-plan/view-outing-plan";
import {MoviePlanServiceProvider} from '../providers/movie-plan-service/movie-plan-service';
import {DineOutPlanServiceProvider} from '../providers/dine-out-plan-service/dine-out-plan-service';
import {ViewMoviePlanPage} from "../pages/view-movie-plan/view-movie-plan";
import {ViewDineOutPlanPage} from "../pages/view-dine-out-plan/view-dine-out-plan";
import {SocialSharing} from '@ionic-native/social-sharing';
import {StreamingMedia} from '@ionic-native/streaming-media';
import {SearchPlacePage} from "../pages/search-place/search-place";
import {SpinnerProvider} from "../providers/spinner/spinner";
import {MapProvider} from "../providers/map/map";
import {Geolocation} from '@ionic-native/geolocation';
import {IonicStorageModule} from "@ionic/storage";

@NgModule({
  declarations: [
    MyApp,
    MenuPage,
    MyPlansPage,
    CreateOutingPage,
    CreateDineOutPage,
    CreateMoviePage,
    NotificationsPage,
    LoginPage,
    SignupPage,
    ConfirmPage,
    AboutPage,
    ViewOutingPlanPage,
    ViewMoviePlanPage,
    ViewDineOutPlanPage,
    SearchPlacePage
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    IonicModule.forRoot(MyApp),
    IonicStorageModule.forRoot(),
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    MenuPage,
    MyPlansPage,
    CreateOutingPage,
    CreateDineOutPage,
    CreateMoviePage,
    NotificationsPage,
    LoginPage,
    SignupPage,
    ConfirmPage,
    AboutPage,
    ViewOutingPlanPage,
    ViewMoviePlanPage,
    ViewDineOutPlanPage,
    SearchPlacePage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    Camera,
    User,
    Cognito,
    DynamoDB,
    OutingPlanServiceProvider,
    MoviePlanServiceProvider,
    DineOutPlanServiceProvider,
    SocialSharing,
    StreamingMedia,
    Geolocation,
    SpinnerProvider,
    MapProvider
  ]
})
export class AppModule {
}

declare var AWS;
AWS.config.customUserAgent = AWS.config.customUserAgent + ' Ionic';

