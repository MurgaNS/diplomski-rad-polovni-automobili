import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {AdResponseDTO} from "../models/dto/Ad/adResponseDTO.model";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {UserResponseDTO} from "../models/dto/User/userResponseDTO.model";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  public GetProfileInfo(): Observable<UserResponseDTO> {
    return this.http.get<UserResponseDTO>(`${environment.baseApiUrl}/user/myProfile`);
  }
}
