package linksharing

import dto.EmailDTO


class EmailController {

    EmailService emailService

    def index() {
        //render('in emails index')

       // EmailService emailService
       // def emailService

        EmailDTO emailDTO = new EmailDTO(to: params.to, subject:"NEW INVITATION" ,from:"payalttn123@gmail.com",content:"hello user..how are you?")

       // render(params.to)
       // render(params.visibility)
        println(emailDTO.properties)

        emailService.sendMail(emailDTO)

    }
}
