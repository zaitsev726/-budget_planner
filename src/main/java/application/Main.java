package application;

import controller.GuiController;
import gui.MainFrame;
import service.BudgetPlannerService;

public class Main {
    public static void main(String[] args) {
        new MainFrame(new GuiController(new BudgetPlannerService()));
    }
}
