import { Role } from "./role.enum";


export class User{

    id: number|undefined;
    userName:string = "";
    password: string= "";
    accessToken: string= "";
    refreshToken: string= "";
    role: Role = Role.ADMIN;

}