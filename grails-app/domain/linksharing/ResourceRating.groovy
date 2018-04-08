package linksharing

import enumeration.Visibility
import vo.ResourceRatingVO
import vo.ResourceVO


class ResourceRating {
    Resource resource
    User createdBy
    Integer score

    static belongsTo = [resource: Resource, createdBy: User]

    static constraints = {
        score(nullable: false, size: 1..5)
        resource(nullable: false)
        createdBy(nullable: false)
    }

    int getScore(User user, Resource resource) {
        List<ResourceRating> ratingList = ResourceRating.findByCreatedByAndResource(user, resource)
        return ratingList.score
    }

//    static List<ResourceRating> getTopPost() {
//
//        List<ResourceRating> topPosts = ResourceRating.createCriteria().list{
//            createAlias('resource','r')
//            createAlias('r.topic','tr')
//            projections{
//
//                groupProperty('r.id')
//                   sum('score')
//              // property('r.createdBy')
//               // property('r.topic')
//               // property('r.description')
//
//            }
//            eq('tr.visibility',Visibility.PUBLIC)
//            order('score','desc')
//            maxResults(5)
//
//        }
//        List<ResourceRating> result = []
//
//        topPosts.each {
//            result.add(it[0])
//        }
//        return result
//    }

    static List getTopPost() {

        List query =  ResourceRating.executeQuery("select ra.resource from Resource r inner join ResourceRating ra on r.id=ra.resource group by r.id order by sum(ra.score) desc",[offset:0,max:5])

        List results =[]
        query.each {
            results.add(it)
        }
        return results

    }


}