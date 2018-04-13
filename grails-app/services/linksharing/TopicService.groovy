package linksharing

import enumeration.Visibility
import grails.gorm.transactions.Transactional

@Transactional
class TopicService {

    def serviceMethod() {

    }

    def delete(Topic topic)
    {
        topic.delete(flush:true)

    }

    def publicSearch(String name) {
        println("name gotten is: ${name}")

        List<Topic> topicList = Topic.findAllByTopicNameIlikeAndVisibility("%${name}%",Visibility.PUBLIC)

        topicList.each {
            println(it)
        }

        return topicList
    }


    def changeVisibility(Map topicData) {
        Topic topic = Topic.findById(topicData.id)
        topic.visibility = topicData.visibility
        if (topic.save(flush: true)) {
            log.info("Visibility Changed : $topic")
            return true
        } else {
            log.error("Unable to Change Visibility : $topic")
            topic.errors.allErrors.each { println it }
            return false
        }
    }

    def editTopicName(Map topicData) {
        Topic topic = Topic.findById(topicData.topicId)
        topic.topicName = topicData.changedTopicName
        if (topic.save(flush: true)) {
            log.info("Topic Name Changed Successfully : $topic")
            return true
        } else {
            log.error("Error Changing Topic Name : $topic")
            topic.errors.allErrors.each { println it }
            return false
        }
    }
}
