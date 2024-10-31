class PasswordValidator implements Validator {
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration request) throws ValidationException {
        String password = request.getPassword();
        if (password == null || password.length() < 8 ||
                !password.matches(".*[A-Z].*") || // At least one uppercase letter
                !password.matches(".*[a-z].*") || // At least one lowercase letter
                !password.matches(".*[0-9].*")) { // At least one digit
            throw new ValidationException("Password must be at least 8 characters long with uppercase, lowercase, and a digit.");
        }
        System.out.println("Password validated.");
        if (nextValidator != null) {
            nextValidator.validate(request);
        }
    }
}