import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PersonaDTO } from '../modelDTO/personaDTO';

@Injectable({
  providedIn: 'root'
})
export class PersoanService {
  private url:string ="http://localhost:8080/persona";

  constructor(private http : HttpClient) { }

  public crear(personaDTO:PersonaDTO):Observable<any>{
    return this.http.post(this.url+'/crear',personaDTO);
  }
  
  public listar():Observable<any>{
    return this.http.get(this.url+'/listar');
  }

  public editar(personaDTO:PersonaDTO):Observable<any>{
    return this.http.put(this.url+'/actualizar',personaDTO);
  }

  public eliminar(cedula:number):Observable<any>{
    return this.http.delete(this.url+'/eliminar/'+cedula);  
  }
}
