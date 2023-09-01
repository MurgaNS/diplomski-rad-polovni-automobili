import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, map, Observable} from "rxjs";
import {JwtUtilsService} from "./jwt-utils.service";
import {Router} from "@angular/router";
import {UserResponseDTO} from "../../models/dto/User/userResponseDTO.model";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private readonly loginPath = "http://localhost:8080/api/auth/login";

  constructor(private http: HttpClient,
              private jwtUtilsService: JwtUtilsService,
              private router: Router) {
  }

  Login(email: string, password: string): Observable<boolean> {
    const headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(this.loginPath, JSON.stringify({email, password}), {headers}).pipe(map((res: any) => {
        let token = res && res['accessToken'];
        let expiresIn = res && res['expiresIn']
        if (token && expiresIn) {
          sessionStorage.setItem('currentUser', JSON.stringify({
            token: token,
            expiresIn: expiresIn
          }));
          return true;
        } else {
          return false;
        }
      })
    )
  }

  Register(userResponseDTO: UserResponseDTO) {
    return this.http.post(`http://localhost:8080/api/auth/signup`, userResponseDTO);

  }

  logout() {
    sessionStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
  }

  hasLoggedIn() {
    return !!sessionStorage.getItem('currentUser');
  }

  getCurrentUser() {
    const localStorageUser = sessionStorage.getItem("currentUser")
    if (localStorageUser) {
      return JSON.parse(localStorageUser);
    } else {
      return undefined;
    }
  }

  getToken(): string {
    const sessionStorageUser = sessionStorage.getItem("currentUser")
    if (sessionStorageUser) {
      const currentUser = JSON.parse(sessionStorageUser);
      const token = currentUser && currentUser.token;
      return token ? token : "";
    }
    return "";
  }

  hasRole(role: string): boolean {
    return this.getCurrentUser()['role'].indexOf(role) !== -1;
  }

  isAdmin(): boolean {
    return this.jwtUtilsService.getRole(this.getToken()) === "ROLE_ADMIN";
  }

  getUsernameFromLoggedUser() {
    return this.jwtUtilsService.getUsername(this.getToken());
  }

}
