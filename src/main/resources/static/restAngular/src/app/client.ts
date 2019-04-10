import { Investor } from './investor';

export class Client {
  id: Number;
  name: string;
  description: string;
  clientInvestors: Investor[] = [];
  constructor() {

  }

}
