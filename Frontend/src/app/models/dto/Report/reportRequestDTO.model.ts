export class ReportRequestDTO {

  reportReason: string = '';

  ReportRequestDTO(reportReason: string) {
    this.reportReason = reportReason;
  }

}
