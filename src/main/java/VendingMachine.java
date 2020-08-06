import java.util.*;

public class VendingMachine {
    public HashMap<Integer, Item> items;
    public float totalSales;
    public int code;
    public float deposit;
    public boolean allowsChange;

    VendingMachine(){
        this.items = new HashMap<Integer, Item>();
        this.totalSales = 0f;
        this.code = 0;
        this.deposit = 0f;
        this.allowsChange = true;
    }

    public HashMap<Integer, Item>getItems(){
        return this.items;
    }
    public float getTotalSales(){
        return this.totalSales;
    }
    public void addItem(Item item){
        if(!this.items.containsValue(item)){
            this.code += 1;
            this.items.put(code, item);
        }
    }
    public void deposit(float amount){
        if(amount > 0f){
            this.deposit += amount;
        }
    }
    public String showItem(int code){
        if(this.items.get(code) == null){
            return "The item doesn't exist";
        }else{
            return this.items.get(code).name;
        }
    }
    public String buyItem(int code){
        if(this.items.get(code) == null){
            return "Item unavailable";
        }else if(this.deposit < this.items.get(code).price){
            return "Funds insufficient";
        }
        else{
            Item item = this.items.get(code);
            item.quantity -= 1;
            this.deposit -= item.price;
            return String.format("Remaining balance %f", this.deposit);
        }
    }
    public void cancelDeposit(){
        this.deposit = 0f;
    }
    public void allowsChange(){
        if(!this.allowsChange){
           this.cancelDeposit();
        }
    }
}
