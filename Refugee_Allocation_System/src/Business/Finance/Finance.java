/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Finance;

/**
 *
 * @author Manish
 */
public class Finance {
    private int incomePerYear;
    private int expensePerYear;
    private int savings;

    public int getIncomePerYear() {
        return incomePerYear;
    }

    public void setIncomePerYear(int incomePerYear) {
        this.incomePerYear = incomePerYear;
    }

    public int getExpensePerYear() {
        return expensePerYear;
    }

    public void setExpensePerYear(int expensePerYear) {
        this.expensePerYear = expensePerYear;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }
}