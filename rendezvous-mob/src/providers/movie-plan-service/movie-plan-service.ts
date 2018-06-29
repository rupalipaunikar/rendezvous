import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import {MoviePlan} from "../../pages/create-movie/create-movie";

declare var AWS: any;

@Injectable()
export class MoviePlanServiceProvider {

  constructor(private http: HttpClient) {
  }

  getMoviePlans() {
    let userId = AWS.config.credentials.identityId;
    return this.http.get("http://rendezvous-env.nmm7wbi53a.us-east-1.elasticbeanstalk.com/moviePlan/search?userId=" + userId)
      .do((res: MoviePlan) => console.log(res))
  }

  saveMoviePlan(moviePlan: MoviePlan) {
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    headers = headers.set('Accept', 'application/json');

    return this.http.post("http://rendezvous-env.nmm7wbi53a.us-east-1.elasticbeanstalk.com/moviePlan",
      JSON.stringify(moviePlan), {headers})
      .do((res: Response) => console.log(res));
  }
}
