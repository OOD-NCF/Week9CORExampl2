interface Validator {
    void setNextValidator(Validator nextValidator);
    void validate(UserRegistration request) throws ValidationException;
}