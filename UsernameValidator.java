class UsernameValidator implements Validator {
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration request) throws ValidationException {
        if (request.getUsername() == null || request.getUsername().length() < 5) {
            throw new ValidationException("Username must be at least 5 characters long.");
        }
        System.out.println("Username validated.");
        if (nextValidator != null) {
            nextValidator.validate(request);
        }
    }
}
