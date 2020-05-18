package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Income {
    @Id
    @GeneratedValue
    private Long idIncome;

    @Column
    private Long idCategory;

    @Column
    private int sum;

    @Column
    private Date date;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Category categoryIncome;

    public Income(){}

    public Long getIdIncome() { return idIncome; }

    public void setIdIncome(Long idIncome) { this.idIncome = idIncome; }

    public Long getIdCategory() { return idCategory; }

    public void setIdCategory(Long idCategory) { this.idCategory = idCategory; }

    public int getSum() { return sum; }

    public void setSum(int sum) { this.sum = sum; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }
}
