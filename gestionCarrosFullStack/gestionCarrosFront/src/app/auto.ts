import { Usuario } from "./usuario";

export class Auto {
    constructor(public placa: string, public ano: string, public color: string, public marca: string, public modelo: string, public usuario: Usuario){
        
    }
}
