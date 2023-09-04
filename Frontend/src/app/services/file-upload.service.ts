import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ReportRequestDTO} from "../models/dto/Report/reportRequestDTO.model";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FileUploadService {

  constructor(private http: HttpClient) {
  }

  private url = "upload-photos"

  public UploadImage(file: any):Observable<string[]> {
    let formData = new FormData();
    formData.append("photos", file);
    return this.http.post<string[]>(`${environment.baseApiUrl}/${this.url}`, file);
  }

}
