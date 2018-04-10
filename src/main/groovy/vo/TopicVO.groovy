package vo

import enumeration.Visibility
import linksharing.User

class TopicVO {

    Integer topicId
    String topicName
    Visibility topicVisibility
    String ownerName
    String ownerUsername
    Integer subscriptionCount
    Integer resourcesCount
}
