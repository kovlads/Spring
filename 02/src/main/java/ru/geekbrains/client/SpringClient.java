package ru.geekbrains.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.service.AppConfig;
import ru.geekbrains.service.Cart;
import ru.geekbrains.service.CartImpl;

import java.text.MessageFormat;
import java.util.Scanner;

public class SpringClient {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Cart cart = context.getBean("cart", Cart.class);

        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: ");
            String message = console.nextLine();
            String[] words = message.split(" ");
            if (words.length == 0) {
                return;
            }
            Command command = Command.valueOf(words[0].toUpperCase());
            switch (command) {
                case ADD:
                    if (words.length > 1)  {
                        cart.add(Long.parseLong(words[1]));
                    }
                    else {
                        System.out.println("Wrong command");
                    }
                    break;
                case DELETE:
                    if (words.length > 1)  {
                        cart.delete(Long.parseLong(words[1]));
                    }
                    else {
                        System.out.println("Wrong command");
                    }
                    break;
                case CART:
                    cart = context.getBean(CartImpl.class);
                    break;
                case VIEW:
                    System.out.println(MessageFormat.format("Products in cart: {0}", cart.getAllProducts()));
                    break;
                case EXIT:
                    System.out.println("your choice is EXIT");
                    return;
            }

        }

    }

    public enum Command {
        ADD,
        DELETE,
        CART,
        EXIT,
        VIEW
    }


}
