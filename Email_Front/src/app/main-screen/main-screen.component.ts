import { Component } from '@angular/core';
import {faPencilAlt} from '@fortawesome/free-solid-svg-icons'
import {faInbox} from '@fortawesome/free-solid-svg-icons'
import {faStar} from '@fortawesome/free-solid-svg-icons'
import {faTrashAlt} from '@fortawesome/free-solid-svg-icons'
import {faBookOpen} from '@fortawesome/free-solid-svg-icons'
import {faTelegramPlane} from '@fortawesome/free-brands-svg-icons'
import {faAddressBook} from '@fortawesome/free-solid-svg-icons'
import {faSearch} from '@fortawesome/free-solid-svg-icons'
import {faFolderPlus} from '@fortawesome/free-solid-svg-icons'
import {faFolder} from '@fortawesome/free-solid-svg-icons'
import { Router } from '@angular/router';
import { ProxyService } from '../Controller/Proxy/proxy.service';
import { take } from 'rxjs';
import { ActionService } from '../Controller/Classes/action.service';

@Component({
  selector: 'app-main-screen',
  templateUrl: './main-screen.component.html',
  styleUrls: ['./main-screen.component.css']
})
export class MainScreenComponent {

  Compose = faPencilAlt;
  Inbox = faInbox;
  Starred = faStar;
  Trash = faTrashAlt;
  Draft = faBookOpen;
  Sent = faTelegramPlane;
  Contacts = faAddressBook;
  Search = faSearch;
  NewFolder = faFolderPlus;
  Folders = faFolder;

  query: string

  constructor(public router: Router, public proxy: ProxyService, private action: ActionService) {
    proxy.getFolderList().
    subscribe(
      data => {
        proxy.setFolders(JSON.parse(data));
      }
    )
  }

  public logOut() {
    this.proxy.signOut().pipe(take(1)).subscribe();
    this.router.navigate(["/registeration/login"]);
  }

  search(){
    this.router.navigate([`/main-screen/inbox/search/${this.query}`]); 
  }

  sort(event: any) {
    let sortType = event.target.value.toLowerCase();
    let emailType = this.router.url.split("/")[2];
    this.action.setAction(emailType + ",sort," + sortType)
  }

  deleteFolder($event){
    this.proxy.deleteFolder($event).pipe(take(1)).subscribe()
    this.proxy.getFolders().splice(this.proxy.getFolders().indexOf($event),1)
  }

}
