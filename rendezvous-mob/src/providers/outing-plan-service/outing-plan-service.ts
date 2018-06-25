import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import {OutingPlan} from "../../pages/create-outing/create-outing";

declare var AWS: any;

@Injectable()
export class OutingPlanServiceProvider {

  constructor(private http: HttpClient) {}

  getOutingPlans(){
    let userId = AWS.config.credentials.identityId;
    return this.http.get("http://172.26.26.15:8080/rendezvous-0.0.1-SNAPSHOT/outingPlan/search?userId="+userId)
      .do((res: OutingPlan) => console.log(res))
  }

  saveOutingPlan(outingPlan: OutingPlan){
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    headers = headers.set('Accept', 'application/json');

    return this.http.post("http://172.26.26.15:8080/rendezvous-0.0.1-SNAPSHOT/outingPlan",
      JSON.stringify(outingPlan), {headers})
      .do((res:Response) => console.log(res));
  }
}
