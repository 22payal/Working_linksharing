package linksharing

import co.ResourceSearchCo
import vo.RatingInfoVO
import vo.ResourceRatingVO
import vo.ResourceVO


 class Resource {
     String description
     User createdBy
     Topic topic
     Date dateCreated
     Date lastUpdated
     RatingInfoVO ratingInfoVo

     static hasMany = [resourceRating: ResourceRating, readingItem: ReadingItem]

     static belongsTo = [createdBy: User, topic: Topic]

     static transients = ['ratingInfoVo']

     static constraints = {
         description(type: 'text')
     }

     void setRatingInfo() {
         this.ratingInfoVo = getResourceRatingInformation()

     }

     static namedQueries = {
         search {
             ResourceSearchCo resourceSearchCo ->
                 if (resourceSearchCo.topicId)
                     eq('topic.id', resourceSearchCo.topicId)
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


     RatingInfoVO getResourceRatingInformation() {
         RatingInfoVO ratingInfoVo = new RatingInfoVO()
         ratingInfoVo.totalVotes = totalVotes()
         ratingInfoVo.totalScore = totalScore()
         ratingInfoVo.averageScore = averageScore()

         return ratingInfoVo

     }
//
//     static List<ResourceRatingVO> getTopPost() {
//         List<ResourceRatingVO> topPosts = ResourceRating.createCriteria().list {
//             projections {
//                 createAlias('resource', 'r')
//                 groupProperty('r.id')
//                 property('r.createdBy')
//                 property('r.topic')
//                 count('r.score', 'count')
//             }
//             order('count', 'desc')
//             maxResults(5)
//         }
//         List result = []
//
//         topPosts.each {
//             result.add(new ResourceVO(id: it[0], createdBy: it[1], topic: it[2], count: it[3]))
//         }
//         return result
//     }

     static List<Resource> getRecentShares() {

         List<Resource> recentShares = Resource.createCriteria().list {
             order("dateCreated", "desc")
             maxResults(2)

         }
         return recentShares
     }

// boolean check(Integer id)
// {
//     Resource resource1 = LinkResource.load(id)
//     Resource resource2 = DocumentResource.load(id)
//
//     if (resource1)
//     {
//        viewFullSite()
//     }
//     else if(resource2)
//     {
//       showDownload()
//     }
//
//     else
//     {
//         println(" resource does not exists")
//     }
// }


 }

