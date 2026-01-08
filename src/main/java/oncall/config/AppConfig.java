package oncall.config;

import oncall.controller.Controller;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {

    public static final String ERROR_MSG = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.";

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
