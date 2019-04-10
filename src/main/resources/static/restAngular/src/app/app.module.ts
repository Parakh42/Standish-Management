import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { TableModule } from 'primeng/table';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientServiceService } from './services/client-service.service';
import { InvestorService } from './services/investor.service';
import { FundService } from './services/fund.service';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    TableModule,
    FormsModule
  ],
  providers: [ClientServiceService, InvestorService, FundService],
  bootstrap: [AppComponent]
})
export class AppModule { }
