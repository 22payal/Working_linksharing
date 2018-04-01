package linksharing

import co.ResourceSearchCo
import vo.RatingInfoVo


abstract class Resource {
    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated
    RatingInfoVo ratingInfoVo

    static hasMany = [resourceRating:ResourceRating,readingItem:ReadingItem]

    static belongsTo = [createdBy:User,topic:Topic]

    static transients = ['ratingInfoVo']

    static constraints = {
        description(type:'text')
    }

    void setRatingInfo()
    {
        this.ratingInfoVo = getResourceRatingInformation()

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

    Integer totalVotes() {
             Integer totalVotes = ResourceRating.createCriteria().count {
                        eq('resource', this)
                    }
                return totalVotes
            }

        Integer totalScore() {
               Integer totalScore = ResourceRating.createCriteria().get() {
                      projections {
                                sum('score')
                            }
                        eq('resource', this)
                    }
                return totalScore
           }

       Double averageScore() {
                Double averageScore = ResourceRating.createCriteria().get() {
                       projections {
                                avg('score')
                            }
                        eq('resource', this)
                    }
               return averageScore
          }



    RatingInfoVo getResourceRatingInformation() {
               RatingInfoVo ratingInfoVo = new RatingInfoVo()
                ratingInfoVo.totalVotes = totalVotes()
                ratingInfoVo.totalScore = totalScore()
                ratingInfoVo.averageScore = averageScore()

                return ratingInfoVo

    }


}

