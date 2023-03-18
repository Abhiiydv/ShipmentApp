

export class ShipmentDetails {

    shipment_id: number | undefined;
    source: string = "";
    destination: string = "";
    dateOfDispatch: | undefined;
    dateOfReceiving: | undefined;
    country: string = "";
    currentLocation: string = "";
    currentStatus: string = "";
    senderName: string = "";
    senderAddress: string = "";
    receiverName: string = "";
    receiverAddress: string = "";
    detailsOfPackage: string = "";
    modeOfTransport: string = "";
    phone: string = "";
    weight: DoubleRange | undefined;
    quantity: number | undefined;
    ammount: number | undefined;

}