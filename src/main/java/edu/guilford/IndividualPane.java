package edu.guilford;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;





public class IndividualPane extends GridPane {
    
        //Could have GridPane, TilePane, FlowPane, StackPane, BorderPane, AnchorPane, etc.
        //These organize the compenents we want to display
    
        //Four String attributes
        // private String name;
        // private String email;
        // private String phone;
        // private String address;
    
        //Individual attribute
        private Individual individual;
    
        //add a textfield for the name
        //add a textfield for the email
        //add a textfield for the phone
        //add a textfield for the address
        
        private TextField nameField;
        private TextField emailField;
        private TextField phoneField;
        private TextField addressField;
        // add a submit button attribute
        private Button submitButton;
        //add a datepicker attribute
        private DatePicker datePicker;
    
        //Four Label attributes for name email phone and address
        private Label nameLabel;
        private Label emailLabel;
        private Label phoneLabel;
        private Label addressLabel;
        private Label dateLabel;
    
        //declare an imageView attribute
        private ImageView imageView;
    
        
        //Constructor
        public IndividualPane(Individual individual) {
            //set the individual attribute to the individual parameter
            this.individual = individual;
    
            //Instantiate the submit button
            submitButton = new Button("Submit");
            //Instantiate the datepicker
            datePicker = new DatePicker();
    
            //Instantiate the imageView
            // get the file that contains the image
            File Block_M = new File(this.getClass().getResource("Block_M.png").getPath());
    
            //URI stands for Uniform Resource Identifier and it's similar to a URL
            imageView = new ImageView(Block_M.toURI().toString());
    
            //Instantiate textfield attributes
            nameField = new TextField();
            emailField = new TextField();
            phoneField = new TextField();
            addressField = new TextField();
    
            //Instantiate the label attributes
            nameLabel = new Label("Name:" + individual.getName());
            emailLabel = new Label("Email: " + individual.getEmail());
            phoneLabel = new Label("Phone: " + individual.getPhone());
            addressLabel = new Label("Address: " + individual.getAddress());
            dateLabel = new Label("Date: " + individual.getDate());
    
    
            //Add a label to the pane
            this.add(nameLabel, 0, 0);
            //Add a label to the pane
            this.add(emailLabel, 0, 1);
            //Add a label to the pane
            this.add(phoneLabel, 0, 2);
            //Add a label to the pane
            this.add(addressLabel, 0, 3);
            //Add a label to the pane
            this.add(dateLabel, 0, 4);
            //add nameField to the pane next to the name label
            this.add(nameField, 1, 0);
            //add emailField to the pane next to the email label
            this.add(emailField, 1, 1);
            //add phoneField to the pane next to the phone label
            this.add(phoneField, 1, 2);
            //add addressField to the pane next to the address label
            this.add(addressField, 1, 3);
            //add the submit button to the pane
            this.add(submitButton, 0, 5);
            //add the datepicker to the pane
            this.add(datePicker, 1, 4);
    
            //add the imageView to the pane to the right of the TextField
            this.add(imageView, 2, 0, 1, 4);
    
            //We can change the image to be of a different size
            imageView.setFitHeight(100);
            imageView.setPreserveRatio(true);
            //rotate it by 45 degrees
            //imageView.setRotate(180);
    
            //give the pane a border
            this.setStyle("-fx-border-color: black");
            //add a background color
            this.setStyle("-fx-background-color: lightblue");

            
            
            //Add a listner for the button that changes the labels
            submitButton.setOnAction(e -> {
                nameLabel.setText("Name: " + nameField.getText());
                emailLabel.setText("Email: " + emailField.getText());
                addressLabel.setText("Address: " + addressField.getText());
                dateLabel.setText("Date: " + datePicker.getValue());
            
                try {
                    if (isValidPhoneNumber(phoneField.getText())) {
                        phoneLabel.setText("Phone: " + phoneField.getText());
                        individual.setPhone(phoneField.getText());
                    } else {
                        throw new BadNumberException("Invalid phone number format. Enter a 10 digit phone number with no spaces or dashes");
                    }
                } catch (BadNumberException ex) {
                    System.out.println(ex.getMessage());
                    Alert alert = new Alert(AlertType.ERROR, ex.getMessage());
                    alert.showAndWait();
                }
                try {
                    isValidEmail(emailField.getText());
                } catch (BadEmailException ex) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Invalid Email");
                    alert.setHeaderText("Invalid email format");
                    alert.setContentText("Please enter a valid email address in the form of example@example.tld");
                    alert.showAndWait();
                    return;
                }
                System.out.println(e.toString());                
            });
            
            
            
            // write and event listner and connect it to the component that triggers it
            //rotate the image by 180 degrees when the mouse is clicked on it
            imageView.setOnMouseClicked(e -> {
                imageView.setRotate(180);
            });
            
            
    
            
    
    
    
        }


        private boolean isValidPhoneNumber(String phoneNumber) {
            if (phoneNumber == null || phoneNumber.isEmpty()) {
                return false;
            }
            // check if the phone number has exactly 10 digits
            if (phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
                return false;
            }
            // other validation rules, if any
            // ...
            return true;
        }
        private boolean isValidEmail(String email) throws BadEmailException {
            // check if the email matches the pattern
            Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
            Matcher matcher = pattern.matcher(email);
            
            // if the email doesn't match the pattern, throw an exception
            if (!matcher.matches()) {
                throw new BadEmailException("Invalid email format. enter an email in the form of example@example.tld");
            }
            
            return true;
        }
        
        
    
    }
    