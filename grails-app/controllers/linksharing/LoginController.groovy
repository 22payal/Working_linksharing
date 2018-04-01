package linksharing

import javax.servlet.http.HttpSession

class LoginController {

    def index() {
       render('hello')
    }

    def loginHandler(String userName,String password) {
        println(userName)
        User user = User.findByUserNameAndPassword(userName, password)
        if(user!=null) {
            if(user.active) {
                session.user=user
            }
            else {
                flash.error = "Your account is not active"

            }
        }
        else
        {
            flash.error="User not found"
        }

    }

    def logout() {
        session.invalidate()
       // redirect(controller: 'Login',action:'index')
    }
}
