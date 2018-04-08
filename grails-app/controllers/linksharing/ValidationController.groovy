package linksharing

class ValidationController {

    def index() { }

    def isEmailExists() {
        User user = User.findByEmail(params.emailField)
        String result = user ? false : true
        render result
    }

    def isUsernameExists() {
        User user = User.findByUserName(params.userNameField)
        String result = user ? false : true
        render result
    }
}
