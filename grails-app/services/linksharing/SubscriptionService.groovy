package linksharing

import enumeration.Seriousness
import grails.gorm.transactions.Transactional

@Transactional
class SubscriptionService {

    def serviceMethod() {

    }

//    def update(Map topicData) {
//
//        println("in subscription service with id ${topicData.topicId}")
//
//        Topic topic = Topic.findById(topicData.topicId)
//
//        Subscription subscription= Subscription.findByTopic(topic)
//        subscription.seriousness = Seriousness.convert(topicData.seriousness)
//
//            if (subscription.validate()) {
//                subscription.save(flush: true)
//                log.info("Topic seriousness Changed Successfully : $topic")
//               return true
//            } else {
//                log.info("Topic seriousness could not be Changed : $topic")
//               return false
//            }
//        }
}
