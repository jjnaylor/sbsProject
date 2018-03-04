export class Employee {
  id: string;
  firstName: string; //*
  lastName: string; //*
  middleInitial: string;
  emailAddress: string; //*   VALIDATE EMAIL
  phoneNum: string;    //     VALIDATE NUMBERS
  positionCat: string;    //DROPDOWN: Indirect, Direct, Program Mgr, Director, Exec
  hireDate: Date;  //*
  address1: string;
  address2: string;
  city: string;
  state: string;   // DROPDOWN
  zip: number;  //  5 DIGIT NUM ONLY
  active: boolean; //*
}
