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

        List<Topic> topicList = Topic.findAllByTopicNameIlikeAndVisibility("%${name}%",Visibility.PRIVATE)
        List result = []

        if (topicList) {
            topicList.each {
                result.add(it)
            }
        }

    }

    def editTopicName(Map topicData){
        Topic topic = Topic.findById(topicData.topicId)
        topic.topicName= topicData.changedTopicName
        if(topic.save(flush:true)){
            log.info("Topic Name Changed Successfully : $topic")
            return true
        }else
        {
            log.error("Error Changing Topic Name : $topic")
            topic.errors.allErrors.each {println it}
            return false
        }
    }
}
