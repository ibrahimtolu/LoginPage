package com.ibrahim.views.list;


import com.ibrahim.services.UserService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@PageTitle("Login")
@Route(value = "")
public class LoginPage extends VerticalLayout {
    @Autowired
    private UserService userService;

    EmailField txt_email = new EmailField();
    PasswordField txt_Password = new PasswordField();
    Button btn_Login = new Button("Sing in");


    public LoginPage() {


        add(
                loginConfigure()
        );


    }

    private Component loginConfigure() {


        //txt_email configuration

        txt_email.setPlaceholder("Enter your mail");
        txt_email.setLabel("email");
        txt_email.getElement().setAttribute("title", "example@gmail.com");
        txt_email.setWidth("15em");
        txt_email.setAutofocus(true);


        //txt_Password configuration

        txt_Password.setLabel("Password");
        txt_Password.getElement().setAttribute("title", "Enter your password");
        txt_Password.setWidth("15em");
        btn_Login.setWidth("15em");
        btn_Login.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btn_Login.addClickListener(buttonClickEvent -> btn_LoginClick());


        VerticalLayout verticalLayout = new VerticalLayout(new H1("Login Page"), txt_email, txt_Password, btn_Login);
        verticalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        verticalLayout.setAlignItems(Alignment.CENTER);

        return verticalLayout;

    }


    private void btn_LoginClick() {


        if (userChecked(txt_email.getValue(), txt_Password.getValue())) {

            Notification.show("Welcome User");


        } else {

            Notification.show("something is wrong,check your email and password");

        }


    }

    public Boolean userChecked(String userName, String password) {

        return userService.userCheck(userName, password);
    }


}
