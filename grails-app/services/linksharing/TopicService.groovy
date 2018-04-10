package linksharing

import grails.gorm.transactions.Transactional

@Transactional
class TopicService {

    def serviceMethod() {

    }

    def delete(Topic topic)
    {
        topic.delete(flush:true)

    }
}
