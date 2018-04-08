package linksharing


import enumeration.Seriousness

class Subscription {
    Topic topic
    User user
    Date dateCreated
    Seriousness seriousness


    static belongsTo = [topic: Topic, user: User]

    static constraints = {
        user(nullable: false)
        topic(nullable: false, unique: 'user')
        seriousness(nullable: false)

    }

    static mapping = {
        seriousness defaultValue: Seriousness.SERIOUS
        user fetch: 'join'
        topic fetch: 'join'
    }

//    static List<SubscriptionVO> getSubscribedTopics(){
//        List<ResourceVO> subscribedTopics = Subscription.createCriteria().list{
//            projections{
//                createAlias('subscription', 's')
//                groupProperty('s.id')
//                property('s.createdBy')
//                property('s.topic')
//                count('s.id', 'count')
//            }
//            order('count', 'desc')
//        }
//        List  result =[]
//
//        subscribedTopics.each {
//            result.add(new Subscription( id : it[0], createdBy: it[1], topic: it[2], count: it[3]))
//        }
//        return result
//}

    static List getSubscribedTopics(User user) {
        List<Subscription> subscribedTopics = Subscription.findAllByUser(user)
        List<Topic> result = []

        subscribedTopics.each {
            Topic topic = Topic.findByCreatedByAndTopicName(it.user, it.topic.topicName)
            if (!topic) {
                result.add(it.topic)
            }
        }
        return result
    }

    static transients = ['getSubscribedTopics']

}
