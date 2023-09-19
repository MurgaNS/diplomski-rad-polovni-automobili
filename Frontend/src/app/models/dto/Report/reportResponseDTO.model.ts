import {AdResponseDTO} from "../Ad/adResponseDTO.model";

export class ReportResponseDTO{

  reportReason: string = '';
  adResponseDTO : AdResponseDTO = new AdResponseDTO();

  ReportResponseDTO(reportReason: string, adResponseDTO: AdResponseDTO) {
    this.reportReason = reportReason;
    this.adResponseDTO = adResponseDTO;
  }
}
