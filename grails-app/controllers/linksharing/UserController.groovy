package linksharing

import Utilities.Util
import dto.EmailDTO
import enumeration.Visibility
import org.springframework.context.MessageSource

class UserController {

    EmailService emailService
    MessageSource messageSource

    def index() {
      //  render("welcome ${session.user.getName()}")
        render(view: 'dashboard')
    }

    def show(Integer id) {

        Topic topic = Topic.get(id)
        if (topic.visibility == Visibility.PUBLIC) {
            render("success")
        } else {
            if (Subscription.findByTopicAndUser(topic, session.user))
                render("Subscription Exists")
            else {
                flash.error = "Subscription does not exists"

            }

        }
    }


    def forgotPasswordEmail(String email)
    {
        if(User.findByEmailAndUserName(params.email,params.username))
        {
            Util util = new Util()
            def newPassword = Util.randomPassword

//            String subject= messageSource.getMessage('Reply from linkSharing', [].toArray(), Locale.default)

            EmailDTO emailDTO = new EmailDTO(to: params.email, subject: "Reply from linkSharing" ,from:"payalttn123@gmail.com",content:"Hello user your new password is : ${newPassword}")

            emailService.sendMail(emailDTO)

            flash.message="password sent"
            render(" message sent successlly...check your mail")
        }

        else
        {
            render("sorry the mail could not be send...kindly check your provided email id or username")
        }

    }

    def add()
    {

    }

}
