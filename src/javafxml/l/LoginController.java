/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package javafxml.l;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sql.consulta.Login;

/**
 * Login Controller.
 */
public class LoginController extends AnchorPane implements Initializable {

    @FXML private Label error;
    @FXML private TextField usuario;
    @FXML private PasswordField codigo;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        error.setText("");
        usuario.setPromptText("Usuario");
        codigo.setPromptText("Contraseña");
    }

    @FXML 
    public void 
    login(ActionEvent event) {
        Login.sesion(usuario.getText(), codigo.getText());
        error.setText(Login.error);
    }
}
