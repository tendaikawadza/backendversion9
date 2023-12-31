package io.getarrays.securecapita.enumeration;

public enum PurchaseRequest {
	STOCK_REQUISITION("STOCK_REQUISITION"),PURCHASE_REQUISITION("PURCHASE_REQUISITION")
    ,RECEIVING_STOCKS("RECEIVING_STOCKS"),ISSUING_STOCKS("ISSUING_STOCKS"),
    STOCK_TRANSFER_REQUISITTION("STOCK_TRANSFER_REQUISITTION"),
    DISPOSAL_REQUISITION("DISPOSAL_REQUISITION");

    private final String description;

    PurchaseRequest(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public static PurchaseRequest getPurchaseRequestValueByName(String name){
        for (PurchaseRequest pr : values()){
            if (pr.description.equals(name)){
                return pr;
            }
        }
        return null;
    }
}
