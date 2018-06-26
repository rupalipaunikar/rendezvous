import {Component, ViewChild} from '@angular/core';
import {IonicPage, Nav, NavController, NavParams} from 'ionic-angular';

export interface PageInterface {
  title: string;
  pageName: string;
  tabComponent?: any;
  index?: number;
  icon: string;
}

@IonicPage()
@Component({
  selector: 'page-menu',
  templateUrl: 'menu.html',
})
export class MenuPage {

  rootPage = "HomePage";
  @ViewChild(Nav) nav: Nav;
  pages: PageInterface[] = [
    {title: 'Home', pageName: 'HomePage', icon: 'md-home'},
    {title: 'My Plans', pageName: 'TabsPage', tabComponent: 'MyPlansPage', index: 0, icon: 'md-apps'},
    {
      title: 'Notifications',
      pageName: 'TabsPage',
      tabComponent: 'NotificationsPage',
      index: 1,
      icon: 'md-notifications'
    },
    {title: 'My Account', pageName: 'MyAccountPage', icon: 'md-person'},
    {title: 'Settings', pageName: 'SettingsPage', icon: 'md-settings'},
    {title: 'Help', pageName: 'HelpPage', icon: 'md-help'},
  ];

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  openPage(page: PageInterface) {
    let params = {};
    if (page.index) {
      params = {tabIndex: page.index};
    }

    if (this.nav.getActiveChildNav() && page.index != undefined) {
      this.nav.getActiveChildNav().select(page.index);
    }
    else {
      this.nav.setRoot(page.pageName, params);
    }
  }

  isActive(page: PageInterface) {
    let childNav = this.nav.getActiveChildNav();

    if (childNav) {
      if (childNav.getSelected() && childNav.getSelected().root === page.tabComponent) {
        return 'primary';
      }
      return;
    }

    if (this.nav.getActive() && this.nav.getActive().name === page.pageName) {
      return 'primary';
    }
  }
}
