export class AdChangeStatusDTO{

  status:string = '';
  rejectedReason:string = '';


  AdChangeStatusDTO(status: string, rejectedReason: string) {
    this.status = status;
    this.rejectedReason = rejectedReason;
  }
}
