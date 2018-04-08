package linksharing

import dto.EmailDTO
import grails.gorm.transactions.Transactional
import org.springframework.scheduling.annotation.Scheduled

@Transactional
class UnreadItemService {
    boolean lazyInit = false

    EmailService emailService

    def serviceMethod() {


    }

    @Scheduled(cron = "0 0 1 ? * MON *")
    def unreaditem() {
        List<User> userList = User.findAll()
        List<String> topicName = []

        userList.each { user ->
            List<ReadingItem> readingItemList = ReadingItem.findAllByUserAndIsRead(user, false)

            readingItemList.resource.each { list ->

                topicName.add(list.topic.topicName)
            }

            EmailDTO emailDTO = new EmailDTO(to: user.email, subject: "Unread items in inbox", itemList: topicName)

            emailService.sendUnreadResourcesEmail(emailDTO)

            topicName = []

        }
    }
}
