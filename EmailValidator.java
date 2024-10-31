class EmailValidator implements Validator {
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration request) throws ValidationException {
        String email = request.getEmail();
        if (email == null || !email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new ValidationException("Invalid email format.");
        }
        System.out.println("Email validated.");
        if (nextValidator != null) {
            nextValidator.validate(request);
        }
    }
}
