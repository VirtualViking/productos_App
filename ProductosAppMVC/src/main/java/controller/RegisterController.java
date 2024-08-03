package controller;

import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;

import java.util.Map;
import java.util.HashMap;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class RegisterController {
    private TextField usernameField;
    private PasswordField passwordField;
    private static Map<String, String> users = new HashMap<>();

    public RegisterController(TextField usernameField, PasswordField passwordField) {
        this.usernameField = usernameField;
        this.passwordField = passwordField;
    }

    public void handleRegisterButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validación de datos
        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Por favor, ingrese todos los campos.");
            return;
        }

        // Verificar si el usuario ya existe en el HashMap
        if (users.containsKey(username)) {
            showAlert("Error", "El usuario ya existe.");
            return;
        }

        // Guardar usuario en el HashMap
        users.put(username, password);
        showAlert("Éxito", "Registro exitoso: " + username);
        clearFields();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        usernameField.clear();
        passwordField.clear();
    }

    public static Map<String, String> getUsers() {
        return users;
    }
}


