import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Client } from 'src/app/client';
import { Investor } from 'src/app/investor';
import { Fund } from 'src/app/fund';
import { ClientServiceService } from 'src/app/services/client-service.service';
import { InvestorService } from 'src/app/services/investor.service';
import { FundService } from 'src/app/services/fund.service';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Standish Management Services';


  constructor(private investorService: InvestorService, private clientService: ClientServiceService, private fundService: FundService) { }

  public Client: Client[];
  public investors: Investor[];
  public allInvestors: Investor[];
  public funds: Fund[];
  cli: any = {};
  t1: String;
  t2: String;
  t3: Number;
  isCreated: boolean = true;
  showInvestor: boolean = true;
  showFund: boolean = true;
  showEdit: boolean = true;
  
  ngOnInit() {
    this.clientService.getClients().subscribe(res => {
      this.Client = res;
    })
    this.isCreated = true;
    this.showEdit = true;
  }

  //method to show create client form when create client button is clicked
  createNewClient() {
    this.showInvestor = true;
    this.showFund = true;
    this.isCreated = !this.isCreated;
    //this.showEdit = false;
  };

  //this shows the investor list for a particular client
  showInvestorList(id: Number) {
    this.investorService.getInvestors(id).subscribe(res => {
      this.allInvestors = res;
    })
    this.isCreated = true;
    this.showEdit = true;
    this.showInvestor = !this.showInvestor;
  }

  //this shows the fund list for a particular investor
  showFundList(id: Number) {
      this.fundService.getFunds(id).subscribe(res => {
      this.funds = res;
      this.isCreated = true;
      this.showEdit = true;
      this.showFund = !this.showFund;
    })
  }

  //this create the client when all the fields are filled
  onSubmit(client1: Client) {
    this.clientService.createClient(client1).subscribe(status => console.log(JSON.stringify(status)));
    location.reload();
    //this.ngOnInit();
    //console.log(client1);
  }

  //this method to populate the edit form
  callupdate(cli: Client) {
    //console.log(cli);
    this.t1 = cli.name;
    this.t2 = cli.description;
    this.t3 = cli.id;
    this.showInvestor = true;
    this.showFund = true;
    this.showEdit = !this.showEdit;
  }

  //this method update the client details
  onEdit(cli: Client) {
    //console.log(this.t3);
    //console.log(cli);
    this.clientService.updateClient(this.t3, cli).subscribe(res => console.log("Entered here"));
    location.reload();
  }
  
}
