import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/*
As a customer, I want to know if the vending machine can make change, so that I can cancel my choice if it can't make change.
You may have more public methods than than those listed above.
 */
public class VendingMachineTest {
    @Test
    public void createsEmptyVendingMachine(){
        VendingMachine machine = new VendingMachine();
        int expected = 0;
        int actual = machine.items.size();
        assertEquals(expected,actual);
    }
    @Test
    public void allowsYouToSeeItems(){
        VendingMachine machine = new VendingMachine();
        HashMap<Integer, Item> expected = new HashMap<Integer, Item>();
        HashMap<Integer, Item> actual = machine.getItems();
        assertEquals(expected,actual);
    }
    @Test
    public void allowsYouToSeeTotalSales(){
        VendingMachine machine = new VendingMachine();
        float expected = 0f;
        float actual = machine.getTotalSales();
        assertEquals(expected,actual);
    }
    @Test
    public void allowsYouToAddItem(){
        VendingMachine machine = new VendingMachine();
        Item item = new Item("Sour Patch Kids", 0.5f, 3);
        machine.addItem(item);
        int expected = 1;
        int actual = machine.items.size();
        assertEquals(expected,actual);
    }
    @Test
    public void doesntAllowYouToAddExistingItem(){
        VendingMachine machine = new VendingMachine();
        Item item = new Item("Sour Patch Kids", 0.5f, 3);
        machine.addItem(item);
        machine.addItem(item);
        int expected = 1;
        int actual = machine.items.size();
        assertEquals(expected,actual);
    }
    @Test
    public void allowsYouToDepositMoney(){
        VendingMachine machine = new VendingMachine();
        machine.deposit(1.0f);
        float expected = 1.0f;
        float actual = machine.deposit;
        assertEquals(expected,actual);
    }
    @Test
    public void allowsYouToSeeNonExistentItem(){
        VendingMachine machine = new VendingMachine();
        String expected = "The item doesn't exist";
        String actual = machine.showItem(1);
        assertEquals(expected,actual);
    }
    @Test
    public void allowsYouToSeeItem(){
        VendingMachine machine = new VendingMachine();
        Item item = new Item("Sour Patch Kids", 0.5f, 3);
        machine.addItem(item);
        String expected = "Sour Patch Kids";
        String actual = machine.showItem(1);
        assertEquals(expected,actual);
    }
    @Test
    public void allowsYouToBuyItem(){
        VendingMachine machine = new VendingMachine();
        Item item = new Item("Sour Patch Kids", 0.5f, 4);
        machine.addItem(item);
        machine.deposit(1f);
        machine.buyItem(1);
        int expected = 3;
        int actual = machine.items.get(1).quantity;
        assertEquals(expected,actual);
    }
    @Test
    public void itDecreasesTheDepositWhenBuying(){
        VendingMachine machine = new VendingMachine();
        Item item = new Item("Sour Patch Kids", 0.5f, 3);
        machine.addItem(item);
        machine.deposit(1f);
        machine.buyItem(1);
        float expected = 0.5f;
        float actual = machine.deposit;
        assertEquals(expected,actual);
    }
    @Test
    public void itTellsYouWhenYoureBroke(){
        VendingMachine machine = new VendingMachine();
        Item item = new Item("Sour Patch Kids", 0.5f, 3);
        machine.addItem(item);
        machine.deposit(0.25f);
        machine.buyItem(1);

        String expected = "Funds insufficient";
        String actual = machine.buyItem(1);
        assertEquals(expected,actual);
    }
    @Test
    public void itAlllowsYouToCancelDeposit(){
        VendingMachine machine = new VendingMachine();
        Item item = new Item("Sour Patch Kids", 0.5f, 3);
        machine.addItem(item);
        machine.deposit(1f);
        machine.cancelDeposit();

        float expected = 0f;
        float actual = machine.deposit;
        assertEquals(expected,actual);
    }
    @Test
    public void itCancelsIfItDoesntMakeChange(){
        VendingMachine machine = new VendingMachine();
        machine.allowsChange = false;
        machine.deposit(1f);
        machine.allowsChange();
        float expected = 0f;
        float actual = machine.deposit;
        assertEquals(expected,actual);

    }


}
