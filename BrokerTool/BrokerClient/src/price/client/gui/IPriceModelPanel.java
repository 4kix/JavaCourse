package price.client.gui;

import javax.swing.*;

import price.common.controller.IPriceController;
import price.common.model.IPriceModel;

public interface IPriceModelPanel {
    void registerController(IPriceController controller);
    void registerModel(IPriceModel model);
    void display(Object obj);
    void refresh();
    JPanel getPanel();
}
