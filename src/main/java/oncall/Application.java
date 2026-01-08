package oncall;

import camp.nextstep.edu.missionutils.Console;
import oncall.config.AppConfig;
import oncall.controller.Controller;


public class Application {

    public static void main(String[] args) {
        try {
            AppConfig appConfig = new AppConfig();
            Controller controller = appConfig.controller();
            controller.run();
        } finally {
            Console.close();
        }
    }

}
