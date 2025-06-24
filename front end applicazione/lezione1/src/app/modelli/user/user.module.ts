import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';




export class UserModule { 

 constructor(
        public email:string,
        public id:string,
        private _token:string,
        private nome:string
        
    ){}



    get token(){
      
      return this._token


    }


}
