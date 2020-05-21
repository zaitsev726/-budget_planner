package entityTest;

import entities.Income;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class IncomeTest {

    private Income income;
    private Date date;

    @Before
    public void setIncome(){
        income = new Income();
        income.setIdIncome((long) 5);
        income.setIdCategory((long) 2);
        income.setSum(300);
        date = new Date();
        income.setDate(date);
    }

    @Test
    public void testIncomeParameters(){
        assertEquals(5L, (long) income.getIdIncome());
        assertEquals(2L, (long) income.getIdCategory());
        assertEquals(300.0, income.getSum(), 1e-15);
        assertEquals(income.getDate(), date);
    }
}
