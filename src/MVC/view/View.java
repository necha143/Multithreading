package MVC.view;

import MVC.controller.Controller;
import MVC.model.ModelData;

public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}
