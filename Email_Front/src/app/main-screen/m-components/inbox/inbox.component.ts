import { Component, OnInit } from '@angular/core';
import { EmailHeader } from 'src/app/Controller/Classes/EmailHeader';
import { ProxyService } from 'src/app/Controller/Proxy/proxy.service';
import { faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import { ActionService } from 'src/app/Controller/Classes/action.service';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent implements OnInit{

  headers: EmailHeader[] = [];
  
  //// Mak
  Trash = faTrashAlt;
  p: number = 1;
  //// Moving
  destination: string
  // Searching
  function: string
  functionParameter: string

  constructor(public proxy: ProxyService, private action: ActionService) {
    proxy.getEmailList("inbox").
    subscribe(
      data => {
        this.headers = JSON.parse(data);
      }
    )
  }

  ngOnInit(): void {
    this.action.$action.subscribe({
      next: (action: string) => {
        console.log(action)
        let actions = action.split(",");
        if(actions[0] != "inbox") return;
        switch(actions[1]) {
          case 'sort': 
            this.sort(actions[2]);
            break;
          // case 'search':
          //   this.search(actions[2]);
          //   break;
          // case 'filter':
          //   this.filter(actions[2]);
          //   break;
        }
      }
    })
  }

  move(){
    for(let header of this.headers) {
      if(header.selected) {
        this.proxy.moveEmails("Inbox", this.destination, header.id).
        subscribe({
          next: (data) => {
            alert(data);
            if(data == 'Email Moved Successfully')
              this.headers.splice(this.headers.indexOf(header), 1)
          },
          error(err) {
            alert(err.message)
          }
        });
      }
    }
  }

  delete(){
    for(let header of this.headers) {
      if(header.selected) {
        this.proxy.moveEmails("Inbox", "Trash", header.id).
        subscribe({
          next: (data) => {
            alert(data);
            if(data == 'Email Moved Successfully')
              this.headers.splice(this.headers.indexOf(header), 1)
          },
          error(err) {
            alert(err.message)
          }
        });
      }
    }
  }

  sort(sortType: string) {
    console.log(sortType)
    this.proxy.sortEmails('inbox', sortType)
    .subscribe({
      next: (data) => {
        this.headers = JSON.parse(data);
      },
      error(err) {
        alert(err.error)
      }
    });
    console.log(sortType)
  }

}
