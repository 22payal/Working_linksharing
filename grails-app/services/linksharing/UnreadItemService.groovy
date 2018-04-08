package linksharing

import dto.EmailDTO
import grails.gorm.transactions.Transactional
import org.springframework.scheduling.annotation.Scheduled

@Transactional
class UnreadItemService {
    boolean lazyInit = false

    EmailService emailService

    def unreaditem() {
        println("invoked")

        List<User> userList = User.findAll()
        List<String> topicName = []
        List<String> createdBy =[]

        userList.each { user ->
            List<ReadingItem> readingItemList = ReadingItem.findAllByUserAndIsRead(user, false)

            readingItemList.resource.each { list ->

                topicName.add(list.topic.topicName)
                createdBy.add(list.createdBy.getName())
            }
//
//            println("size of list is :"+topicName.size())
//            topicName.each {println(it)}

            EmailDTO emailDTO = new EmailDTO(to: user.email, subject: "Unread items in inbox", itemList: topicName, createrList:createdBy )

            emailService.sendUnreadResourcesEmail(emailDTO)

            println(emailDTO.properties)

            topicName = []
            createdBy=[]

        }
    }
}
