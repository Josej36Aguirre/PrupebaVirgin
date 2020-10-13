import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import{PersonaDTO} from '../modelDTO/personaDTO'
import { PersoanService } from '../service/PersonaService';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css']
})
export class PersonaComponent implements OnInit {

  public formulariosPersona: FormGroup;
  private persona: PersonaDTO;
  public listaPersona: PersonaDTO[] = [];
  public esEditar:boolean =false;
  public documentoPersona:number;
  
  constructor(public fb: FormBuilder, protected personaService: PersoanService) {
    this.formulariosPersona = fb.group({
      documento:[null, Validators.required],
      nombres:[null, Validators.required],
      apellidos:[null, Validators.required],
      fechaNacimiento:[null, Validators.required],
      tipoDocumento: [null, Validators.required],
      direccion:[null, Validators.required],
      celular:[null, Validators.required]

    })
  }

  ngOnInit(): void {
    this.listarTodo();
  }
  public crear(): void {
    if (this.formulariosPersona.valid) {
      this.persona = new PersonaDTO();
      this.persona.documento = this.formulariosPersona.controls.documento.value;
      this.persona.nombres = this.formulariosPersona.controls.nombres.value;
      this.persona.apellidos = this.formulariosPersona.controls.apellidos.value;
      this.persona.fechaNacimiento = this.formulariosPersona.controls.fechaNacimiento.value;
      this.persona.direccion = this.formulariosPersona.controls.direccion.value;
      this.persona.celular = this.formulariosPersona.controls.celular.value;
      this.persona.tipoDocumento = this.formulariosPersona.controls.tipoDocumento.value;
      if(!this.esEditar){

        this.personaService.crear(this.persona).subscribe(respuesta => {
          console.log("Producto creado con exito", respuesta.body)
          this.formulariosPersona.reset();
          this.listarTodo();
        });
      }else{
        this.persona.documento = this.documentoPersona;
        this.personaService.editar(this.persona).subscribe(respuesta => {
          console.log("actualizar", respuesta.body);
          this.formulariosPersona.reset();
          this.listarTodo();
        });
      }

    } else {
      alert("campos incompletos");
    }
  }
  public listarTodo(): void {
    this.personaService.listar().subscribe(respuesta => {
      this.listaPersona = respuesta.body;
    });
  }

  public actualizar(producto: PersonaDTO): void {
    this.esEditar = true;
    this.documentoPersona = producto.documento;
    this.formulariosPersona.controls.nombres.setValue(this.persona.nombres);
    this.formulariosPersona.controls.apellidos.setValue(this.persona.apellidos);
    this.formulariosPersona.controls.fechaNacimiento.setValue(this.persona.fechaNacimiento);
    this.formulariosPersona.controls.direccion.setValue(this.persona.direccion);
    this.formulariosPersona.controls.celular.setValue(this.persona.celular);
    this.formulariosPersona.controls.tipoDocumento.setValue(this.persona.tipoDocumento);
  }
  public eliminar(cedula:number):void{
    this.personaService.eliminar(cedula).subscribe(respuesta=>{
      this.listarTodo();
    });
  }
}
