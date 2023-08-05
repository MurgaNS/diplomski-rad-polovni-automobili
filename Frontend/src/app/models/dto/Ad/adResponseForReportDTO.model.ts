export class AdResponseForReportDTO {

  id: number = 0;
  price: number = 0;
  description: string = '';

  AdResponseForReportDTO(id: number, price: number, description: string) {
    this.id = id;
    this.price = price;
    this.description = description;
  }
}
