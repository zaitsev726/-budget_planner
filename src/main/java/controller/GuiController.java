package controller;

import entities.Expense;
import service.BudgetPlannerService;

import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GuiController {
    private BudgetPlannerService service;
    private CategoryController categoryController;

    public GuiController(BudgetPlannerService budgetPlannerService, CategoryController categoryController) {
        service = budgetPlannerService;
        this.categoryController = categoryController;
    }

    public List<Color> getColorList(int size) {
        List<Color> colorList = new ArrayList<>();
        int constant = 0;
        int k = 1;
        int step = 75;
        int delta = 0;
        int change = 0;
        for (int i = 0; i < size; ++i) {
            if (constant == 0) {
                if (k == 1 && change == 0 || k == -1 && change == 1) {
                    colorList.add(new Color(255, delta, 0));
                    change = 0;
                } else
                    colorList.add(new Color(255, 0, delta));
            } else if (constant == 1) {
                if (k == -1 && change == 1) {
                    colorList.add(new Color(delta, 255, 0));
                    change = 0;
                } else
                    colorList.add(new Color(0, 255, delta));
            } else if (constant == 2) {
                if (k == -1 && change == 1) {
                    colorList.add(new Color(delta, 0, 255));
                    change = 0;
                } else
                    colorList.add(new Color(0, delta, 255));
            }
            delta = delta + k * step;
            if (delta > 255 - step) {
                delta = 255;
                constant = (++constant) % 3;
                k = -k;
                change = 1;
            } else if (delta < step) {
                delta = 0;
                constant = (++constant) % 3;
                k = -k;
                change = 1;
            }
        }
        return colorList;
    }

    /**
     *
     * @return список, состоящий из названий категорий
     */
    public List<String> getCategoryList() {
        List<String> categoryList = new ArrayList<>();
        categoryList.add("Продукты");
        categoryList.add("Транспорт");
        categoryList.add("Здоровье");
        categoryList.add("Рестораны");
        return categoryList;
    }

    /**
     * Для всех категорий считаем, какой процент они вкладывают в расход по всем категориям
     * @return список процентов, который соответствует списку категорий, возвращаемых getCategoryList()
     */
    public List<Double> getCategoryValuesList() {
        /*List<Category> categoryList = new ArrayList<>(/*categoryController.getCategories().values());
        List<Double> categorySizeList = new ArrayList<>();
        categoryList.forEach(e -> categorySizeList.add(0.0 /*e.getExpenseHistory().size()));
        double total = categorySizeList.stream().reduce(0.0, Double::sum);
        List<Double> values = new ArrayList<>();
        categorySizeList.forEach(e -> values.add(e / total * 100));*/
        List<Double> testValues = new ArrayList<>();
        testValues.add(0.0);
        testValues.add(50.0);
        testValues.add(25.0);
        testValues.add(25.0);
        return new ArrayList<>();
    }

    /**
     *
     * @param categoryName название категории
     * @return лист расходов для категории с названием categoryName
     */
    public List<Expense> getExpenseListByCategoryName(String categoryName) {
        List<Expense> testList = new ArrayList<>();
        Expense e = new Expense();
        e.setSum(1800.0);
        e.setDate(new Date(2020, Calendar.JANUARY,22));
        testList.add(e);
        return testList;
    }
}
