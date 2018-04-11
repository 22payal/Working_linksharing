package linksharing

import Utilities.Util
import dto.EmailDTO
import enumeration.Visibility
import org.springframework.context.MessageSource
import vo.UserVO

class UserController {

    EmailService emailService
    MessageSource messageSource
    UserService userService
    UnreadItemService unreadItemService
    def assetResourceLocator

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

            userService.forgotPassword(updatedPassword,emailDTO.to)


            flash.message="password sent"
            render(" message sent successlly...check your mail...now login with new password")
        }

        else
        {
            render("sorry the mail could not be send...kindly check your provided email id or username")
        }

    }

    def fetchUserImage(){
        def user = User.findByUserName(params.username)
        byte[] photo
        if(!user?.photo){
            println("Photo Not Found")
            photo = assetResourceLocator.findAssetForURI('user.png').byteArray
        }else {
            println("Photo Found")
            photo= user.photo
        }
        OutputStream out = response.getOutputStream()
        out.write(photo)
        out.flush()
        out.close()
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

    def updateUser()
    {
        if (userService.updateProfile(params, new String(session.user.userName)))
        {
            flash.message = "Updation Successful"
        } else
            flash.error = "Unable To Update Credentials"
    }

    def showUserListToAdmin(){
        List<UserVO> allUsers= userService.showAllUsers()
        render(view: '/user/adminView', model: [allUsers:allUsers])
    }

    def changeState(){
        println "Printing params- $params.id"
        if(userService.activateDeactivate(new Integer(params.id))){
            flash.message= "State Changed"
        }else
            flash.error= "Unable To Change State"
        redirect(controller: 'user', action: 'showUserListToAdmin')
    }
}
