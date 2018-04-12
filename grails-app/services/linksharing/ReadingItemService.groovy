package linksharing

import grails.gorm.transactions.Transactional

@Transactional
class ReadingItemService {

    def createReadingItem(User user, Topic newtopic) {
        List<Resource> resourceList = Resource.findAllByTopic(newtopic)

        //List<User> userList = User.findAll()

        resourceList.each {

                if ((!Topic.findAllByCreatedByAndTopicName(user, it.topic.topicName)) && (Subscription.findAllByUserAndTopic(user, it.topic))) {

                    ReadingItem readingItem = new ReadingItem(user: user, isRead: false, resource: it)

                    if (ReadingItem.findAllByUserAndResource(user, it).size() == 0) {
                        if (readingItem.validate()) {
                            readingItem.save(flush: true)
                            log.info("Saved Succesfully: $readingItem")
                            return 1

                        } else {
                            log.error("Error while saving : $readingItem")
                            return 0
                        }
                    }
            }
        }
    }
}
