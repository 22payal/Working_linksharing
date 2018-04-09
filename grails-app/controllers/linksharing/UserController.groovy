package linksharing

import Utilities.Util
import dto.EmailDTO
import enumeration.Visibility
import org.springframework.context.MessageSource

class UserController {

    EmailService emailService
    MessageSource messageSource
    UserService userService
    UnreadItemService unreadItemService

    def index() {
      //  render("welcome ${session.user.getName()}")
        List <Resource> resourceList = unreadItemService.inbox(session.user)

        render(view: '/user/dashboard', model: [resourceList:resourceList])
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
//            Util util = new Util()
            Long newPassword = Util.randomPassword
            String updatedPassword = String.valueOf(newPassword)

//            String subject= messageSource.getMessage('Reply from linkSharing', [].toArray(), Locale.default)


            def msg = messageSource.getMessage('my.localized.content', ['Juan', 'lunes'] as Object[], 'Reply from linkSharing', request.locale)


            EmailDTO emailDTO = new EmailDTO(to: params.email, subject: "Reply from linkSharing" ,from:"payalttn123@gmail.com",content:"Hello user your new password is : ${updatedPassword}")

            emailService.sendMail(emailDTO)

            userService.forgotPassword(updatedPassword,session.user.email)


            flash.message="password sent"
            render(" message sent successlly...check your mail...now login with new password")
        }

        else
        {
            render("sorry the mail could not be send...kindly check your provided email id or username")
        }

    }

    def add()
    {

    }

    def editProfile() {
        Map map = userService.showProfile((session.user.userName))
        render(view: 'editProfile', model: [user: map.userInformation, userTopics: map.userTopics, userPosts: map.userPosts])
    }

    def changePassword()
    {
        String oldPassword=params.oldPassword
        String newPassword= params.updatedPassword
        String confirmNewPassword= params.updatedConfirmPassword

       userService.changePassword(oldPassword,newPassword,confirmNewPassword)
    }
}
