package linksharing

import vo.ResourceVO

class LoginController {

    static defaultAction = "home"

    def home()
    {
        render(view: 'main')
    }

    def index() {
        if(session.user)
        {
            flash.message= "user is logged in"
            redirect(controller: 'User', action: 'index')

        }
        else
        {
            render("session over")
        }
     }

    def loginHandler(String loginusername,String loginpassword) {
        User user = User.findByUserNameAndPassword(loginusername, loginpassword)
        if(user!=null) {
            user.active=true
            if(user.active) {
                session.user=user
                redirect(controller: 'User',action: 'index')
            }
            else {
                flash.error = "Your account is not active"
                render("Your account is not active")

            }
        }
        else
        {
            flash.error="User not found"
            render("User not found")
        }

    }

    def logout() {
            session.invalidate()

            redirect(controller: 'Login', action: 'home')


    }

    def topPost()
    {
                    List<ResourceVO> topPosts = Resource.getTopPost()
                    println("$topPosts.id + $topPosts.createdBy + $topPosts.topicName")

    }

    def register() {

        User newuser = new User(firstName: params.firstName,
                               lastName: params.lastName,
                                email: params.email,
                                userName: params.userName,
                                  password: params.password,
                                confirmPassword: params.confirmPassword)

               if (newuser.validate()) {
                   newuser.save(flush: true, failOnError: true)

                    render(view: 'main')
                    }
        else
               {
                   if (newuser.errors.hasFieldErrors("password")) {
                       println newuser.errors.getFieldError("password").rejectedValue
                   }

                   else if (newuser.errors.hasFieldErrors("userName")) {
                       println newuser.errors.getFieldError("userName").rejectedValue
                   }

                 else  if (newuser.errors.hasFieldErrors("email")) {
                       println newuser.errors.getFieldError("email").rejectedValue
                   }

                   else if (newuser.errors.hasFieldErrors("firstName")) {
                       println newuser.errors.getFieldError("firstName").rejectedValue
                   }
               }

    }

//    def topPosts() {
//        List<ResourceVO> topPosts = Resource.getTopPost()
//    }


    def forgotPassword()
    {
        render(view: 'ForgotPassword')
    }

}
