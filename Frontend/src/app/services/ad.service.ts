import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {AdResponseDTO} from "../models/dto/Ad/adResponseDTO.model";
import {AdRequestDTO} from "../models/dto/Ad/adRequestDTO.model";
import {AdChangeStatusDTO} from "../models/dto/Ad/adChangeStatusDTO.model";

@Injectable({
  providedIn: 'root'
})
export class AdService {

   httpOptions = {
    headers: new HttpHeaders({
      "Authorization": "Token " + localStorage.getItem("token")
    })
  };

  private url = "ad"
  constructor(private http: HttpClient) { }

  public GetAllActive(): Observable<AdResponseDTO[]>{
    return this.http.get<AdResponseDTO[]>(`${environment.baseApiUrl}/${this.url}/active`);
  }

  public GetAllInactive(): Observable<AdResponseDTO[]>{
    return this.http.get<AdResponseDTO[]>(`${environment.baseApiUrl}/${this.url}/inactive`);
  }

  public GetById(ad_id: number): Observable<AdResponseDTO> {
    return this.http.get<AdResponseDTO>(`${environment.baseApiUrl}/${this.url}/` + ad_id);
  }

  public CreateAd(ad: AdRequestDTO): Observable<AdResponseDTO> {
    return this.http.post<AdResponseDTO>(`${environment.baseApiUrl}/${this.url}/create`, ad);
  }

  public Follow(ad_id: number):Observable<AdResponseDTO> {
    return this.http.post<AdResponseDTO>(`${environment.baseApiUrl}/${this.url}` + `/${ad_id}` + "/follow", ad_id);
  }

  public GetUserAds(): Observable<AdResponseDTO[]> {
    return this.http.get<AdResponseDTO[]>(`${environment.baseApiUrl}/user/myAds/`);
  }

  public GetUserFollowedAds(): Observable<AdResponseDTO[]> {
    return this.http.get<AdResponseDTO[]>(`${environment.baseApiUrl}/user/followedAds/`);
  }

  public ChangeStatus(ad_id: number, adChangeStatusDTO : AdChangeStatusDTO): Observable<AdResponseDTO>{
    return this.http.patch<AdResponseDTO>(`${environment.baseApiUrl}/${this.url}/${ad_id}/change-status`, adChangeStatusDTO);

  }

}
