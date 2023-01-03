import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
<<<<<<< Updated upstream
=======
import { HttpService } from './Controller/Http/http.service';
import { MainScreenModule } from './main-screen/main-screen.module';
import { RegisterationModule } from './registeration/registeration.module';
import { ProxyService } from './Controller/Proxy/proxy.service';
import { ActionService } from './Controller/Classes/action.service';
>>>>>>> Stashed changes

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
<<<<<<< Updated upstream
  providers: [],
=======
  providers: [HttpService, ProxyService, ActionService],
>>>>>>> Stashed changes
  bootstrap: [AppComponent]
})
export class AppModule { }
