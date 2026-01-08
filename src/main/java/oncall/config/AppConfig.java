package oncall.config;

import oncall.controller.Controller;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {

    private InputView inputView;
    private OutputView outputView;
    private Controller controller;

    public AppConfig() {
    }

    private InputView inputView() {
        if (inputView == null) {
            return inputView = new InputView();
        }
        return inputView;
    }

    private OutputView outputView() {
        if (outputView == null) {
            return outputView = new OutputView();
        }
        return outputView;
    }

    public Controller controller() {
        if (controller == null) {
            return controller = new Controller(inputView(), outputView());
        }
        return controller;
    }

}
