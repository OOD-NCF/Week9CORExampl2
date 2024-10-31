public class RegistrationValidatorDemo {
    private static Validator setupValidatorChain() {
        Validator usernameValidator = new UsernameValidator();
        Validator passwordValidator = new PasswordValidator();
        Validator emailValidator = new EmailValidator();
        Validator phoneValidator = new PhoneValidator();

        // Setting up the chain of responsibility
        usernameValidator.setNextValidator(passwordValidator);
        passwordValidator.setNextValidator(emailValidator);
        emailValidator.setNextValidator(phoneValidator);

        return usernameValidator; // Return the start of the chain
    }

    public static void main(String[] args) {
        Validator validatorChain = setupValidatorChain();

        // Sample user registration details
        UserRegistration user = new UserRegistration(
                "testuser",          // Username
                "Password1",         // Password
                "user@example.com",  // Email
                "1234567890"         // Phone number (optional)
        );

        try {
            validatorChain.validate(user);
            System.out.println("Registration passed all validations.");
        } catch (ValidationException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
