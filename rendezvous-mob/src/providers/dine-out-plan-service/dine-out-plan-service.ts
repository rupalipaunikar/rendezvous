import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import {DineOutPlan} from "../../pages/create-dine-out/create-dine-out";

declare var AWS: any;

@Injectable()
export class DineOutPlanServiceProvider {

  constructor(private http: HttpClient) {
  }

  getDineOutPlans() {
    let userId = AWS.config.credentials.identityId;
    return this.http.get("http://rendezvous-env.nmm7wbi53a.us-east-1.elasticbeanstalk.com/dineOutPlan/search?userId=" + userId)
      .do((res: DineOutPlan) => console.log(res))
  }

  saveDineOutPlan(dineOutPlan: DineOutPlan) {
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    headers = headers.set('Accept', 'application/json');

    return this.http.post("http://rendezvous-env.nmm7wbi53a.us-east-1.elasticbeanstalk.com/dineOutPlan",
      JSON.stringify(dineOutPlan), {headers})
      .do((res: Response) => console.log(res));
  }
}
