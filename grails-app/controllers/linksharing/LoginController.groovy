package linksharing

import vo.ResourceVo

import javax.servlet.http.HttpSession

class LoginController {

   // static defaultAction = "loginHandler"

    def index() {

       render(view: 'register')

    }

    def loginHandler(String loginusername,String loginpassword) {
        User user = User.findByUserNameAndPassword(loginusername, loginpassword)
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

    }

    def topPost()
    {
                    List<ResourceVo> topPosts = Resource.getTopPost()
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
                   newuser.errors.allErrors.each{log.info(it)}

                   forward(controller: 'User', action: 'index')
                    }
        else
               {
                   newuser.errors.allErrors.each{println(it)}
               }

    }

    def topPosts() {
        List<ResourceVo> topPosts = Resource.getTopPost()
    }


}
