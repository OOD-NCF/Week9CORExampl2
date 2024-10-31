class PhoneValidator implements Validator {
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration request) throws ValidationException {
        String phoneNumber = request.getPhoneNumber();
        if (phoneNumber != null && (!phoneNumber.matches("\\d{10}"))) {
            throw new ValidationException("Phone number must be exactly 10 digits.");
        }
        System.out.println("Phone number validated.");
        if (nextValidator != null) {
            nextValidator.validate(request);
        }
    }
}