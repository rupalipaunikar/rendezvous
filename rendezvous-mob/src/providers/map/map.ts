import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class MapProvider {

  app: any;
  google_api_key: any;

  constructor(public http: Http) {
    this.google_api_key = 'AIzaSyBSWTBMtj6RPJx-cGsQeV-gVKmAc_sbFgc';
  }

  getAddress(params) {
    let url = 'http://maps.googleapis.com/maps/api/geocode/json?latlng=' + params.lat + ',' + params.long;
    return this.GET(url);
  }

  getStreetAddress(params) {
    let url = 'https://maps.googleapis.com/maps/api/geocode/json?key=' + this.google_api_key + '&latlng=' + params.lat + ',' + params.long + '&result_type=street_address';
    return this.GET(url);
  }

  GET(url) {
    return this.http.get(url).map(res => res.json());
  }
}
