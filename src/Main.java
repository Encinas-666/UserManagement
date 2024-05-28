
import Presentation.UserUI;
import data.UserRepositoryBuilder;
import data.RoRuDecorator;
import data.UserRepositoryImpl;
import service.UserService;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserRepositoryBuilder repoBuilder = new UserRepositoryBuilder();
        UserRepositoryImpl repo = repoBuilder.build();
        RoRuDecorator repoDecorator = new RoRuDecorator(repo);
        UserService service = new UserService(repoDecorator);

        UserUI userUI = new UserUI(scanner, service);
        userUI.run();
    }
}