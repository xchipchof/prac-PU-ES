package services.suggestions;

import data.ProductID;

public class Suggestion {
    public final ProductID item;

    public final String operation;

    protected Suggestion(ProductID product, String op){
        this.item = product;
        this.operation = op;
    }

    public String getOperation(){
        return this.operation;
    }

    public ProductID getItem() {
        return this.item;
    }
}
