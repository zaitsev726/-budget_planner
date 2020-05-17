package controller;

import service.BudgetPlannerService;

import java.awt.*;
import java.util.ArrayList;
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

    public List<String> getCategoryList() {
        List<String> categoryList = new ArrayList<>(categoryController.getCategories().keySet());
        return categoryList;
    }
}
