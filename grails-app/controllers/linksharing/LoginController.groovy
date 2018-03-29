package linksharing

import javax.servlet.http.HttpSession

class LoginController {

    static defaultAction = "loginHandler"

    def index() {
        if(session.user)
            forward(controller: 'user',action:'index')
        else
            render( 'failure')    }

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
        redirect(action: 'index')    }

    def logout() {
        session.invalidate()
        redirect(action:'index')
    }
}
