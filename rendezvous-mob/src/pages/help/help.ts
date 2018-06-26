import {Component} from '@angular/core';
import {IonicPage} from 'ionic-angular';
import {StreamingMedia, StreamingVideoOptions} from "@ionic-native/streaming-media";

@IonicPage()
@Component({
  selector: 'page-help',
  templateUrl: 'help.html',
})
export class HelpPage {

  constructor(private streamingMedia: StreamingMedia) {
  }

  startVideo() {
    let options: StreamingVideoOptions = {
      successCallback: () => {
        console.log('Finished Video')
      },
      errorCallback: (e) => {
        console.log('Error: ', e)
      },
      orientation: 'portrait'
    };

    this.streamingMedia.playVideo('http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_30mb.mp4', options);
  }
}
