package linksharing

import co.ResourceSearchCo


abstract class Resource {
    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated

    static hasMany = [resourceRating:ResourceRating,readingItem:ReadingItem]

    static belongsTo = [createdBy:User,topic:Topic]

    static constraints = {
        description(type:'text')
    }

    static namedQueries = {
        search{
            ResourceSearchCo resourceSearchCo->
                if (resourceSearchCo.topicId)
                    eq('topic.id',resourceSearchCo.topicId)
                if (resourceSearchCo.visibility)
                    eq('topic.visibility', resourceSearchCo.visibility)


        }
    }

}

