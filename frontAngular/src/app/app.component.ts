import { Component } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {environment} from "../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontAngular';

  address: any;
  cepValid = false;
  pageUsers: any;

  public formGroup: FormGroup = new FormGroup(
    {
      nome: new FormControl("", [Validators.required]),
      telefone:new FormControl("", [Validators.required]),
      cpf:new FormControl("", [Validators.required]),
      cep:new FormControl("", [Validators.required]),
      numero: new FormControl("", [Validators.required]),
    }
  );
  errorMessage: any;
  successMessage: any;

  constructor(
    private router: Router,
    private http: HttpClient,

  ) {
  }

  ngOnInit() {

    this.address = {
      logradouro: "",
      numero: "",
      bairro: "",
      localidade: "",
      uf: "",
      complemento: "",
    }

  }

  cadastrar() {
    this.address.numero = this.formGroup.value["numero"]
    let body = {
      nome: this.formGroup.value["nome"],
      telefone: this.formGroup.value["telefone"],
      cpf: this.formGroup.value["cpf"],
      cep: this.formGroup.value["cep"],
      address: this.address,
    }
    console.log("body")
    console.log(
      body
    )
    this.http.post(

      `${environment.apiUrl}/users/save`,
      body
    )
      .subscribe(
        {
          next:(res) => {
            console.log(res)
            this.errorMessage = ""
            this.successMessage = "Usuário salvo com sucesso."
          },
          error: (err) => {
            this.errorMessage = err
            console.log(err)
          }
        }
      );
  }


  getEnderecoByCep(cep: String) {

    this.http.get(
      `${environment.apiUrl}/address/byCep/${cep}`
    )
      .subscribe(
        {
          next:(res) => {
            this.address = res
            this.address.numero = ""
            this.errorMessage = ""
            this.cepValid = true;
          },
          error: (err) => {
            this.cepValid = false
            this.errorMessage = err
            console.log(err)
          }
        }
      );
  }

  getCadastros(page: number) {

    this.http.get(
      `${environment.apiUrl}/users/visualizar/page/${page}/size/10`
    )
      .subscribe(
        {
          next:(res) => {
            this.pageUsers = res
            this.errorMessage = ""
            console.log("page")
            console.log(this.pageUsers)
          },
          error: (err) => {
            this.errorMessage = err
            console.log(err)
          }
        }
      );
  }
}
