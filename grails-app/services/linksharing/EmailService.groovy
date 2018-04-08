package linksharing

import dto.EmailDTO
import grails.gorm.transactions.Transactional
import org.springframework.context.MessageSource

@Transactional
class EmailService {

    static transactional = false
    def mailService
    MessageSource messageSource

    def groovyPageRenderer

    def sendMail(EmailDTO emailDTO) {
        mailService.sendMail {
            to emailDTO.to
            subject emailDTO.subject
            body emailDTO.content

        }
    }

    def sendInvitation(EmailDTO emailDTO)
    {
        println("in email service")
//        def htmlContent = groovyPageRenderer.render(view: '/email/_invite',model:[link:emailDTO.linkId])
        mailService.sendMail {
            to emailDTO.to
            subject emailDTO.subject
            html view: "/email/_invite", model: [link: "${emailDTO.linkId}"]
//            body emailDTO.content
//            html(htmlContent)
//            body "<%@ page contentType=\"text/html\" %>"
//            html "<b>Hello</b> World"
        }
    }
}
