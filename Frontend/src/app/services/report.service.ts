import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {ReportRequestDTO} from "../models/dto/Report/reportRequestDTO.model";
import {ReportResponseDTO} from "../models/dto/Report/reportResponseDTO.model";

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private http: HttpClient) {
  }

  private url = "report"

  public Report(ad_id: number, report: ReportRequestDTO ) {
    return this.http.post(`${environment.baseApiUrl}/${this.url}/${ad_id}`, report);
  }

  public GetAllReports(): Observable<ReportResponseDTO[]> {
    return this.http.get<ReportResponseDTO[]>(`${environment.baseApiUrl}/${this.url}/all`);
  }
}
