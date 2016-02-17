/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoo.finance.test;

/**
 *
 * @author 200240927
 */
public abstract class TesterBase {
    
    static void assertTrue(boolean input) {
        if (!input) {
            throw new RuntimeException("Test Failed");
        }
    }

    static void assertFalse(boolean input) {
        if (input) {
            throw new RuntimeException("Test Failed");
        }
    }
    
}
