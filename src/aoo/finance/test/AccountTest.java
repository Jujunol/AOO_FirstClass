package aoo.finance.test;

import aoo.finance.Account;

public class AccountTest extends TesterBase {
    
    public static void main(String[] args) {
        Account chequing = new Account(100, 500, "Chequing");
        // Account apMike = new Account(200, 0, "A/P Mike");
        
        assertTrue(chequing.deposit(250));
        assertTrue(chequing.getBalance() == 750);
        
        assertFalse(chequing.withdraw(850));
        assertTrue(chequing.getBalance() == 750);
        
        assertTrue(chequing.withdraw(200));
        assertTrue(chequing.getBalance() == 550);
        
        System.out.println("Test ran successfully");
    }
    
}
