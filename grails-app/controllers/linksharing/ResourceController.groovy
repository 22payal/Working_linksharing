package linksharing

import co.ResourceSearchCo
import co.TrendingTopicsCO
import enumeration.Visibility
import vo.RatingInfoVO
import vo.ResourceVO
import vo.TopicVO
import vo.TrendingTopicsVO

class ResourceController {

    ResourceService resourceService
    def index() { }


    def resourceDelete(Integer id)
    {
        Resource resource=Resource.load(id)

        if(!resource)
        {
            throw new Exception( "exception of object not found")
        }
    }

    def search(){
        ResourceSearchCo resourceSearchCo=new ResourceSearchCo()
        if(resourceSearchCo.q)
            resourceSearchCo.visibility=Visibility.PUBLIC

    }

//    def show(Integer ResourceId)
//    {
//        Resource resource = Resource.findById(resourceId)
//               RatingInfoVO ratingInfoVo = resource.getResourceRatingInformation()
//                render("TOTAL VOTES- $ratingInfoVo.totalVotes + TOTAL SCORE- $ratingInfoVo.totalScore + AVERAGE SCORE- $ratingInfoVo.averageScore")
//
//        List<TopicVO> trendingTopics = Topic.getTrendingTopics()
//        render("TRENDING TOPICS-"+trendingTopics.each {println("$it.name + $it.visibility + $it.createdBy")})
//
//    }

    def handleNullPointerException(NullPointerException e) {

        render ("null found")
    }

//def findTrendingTopics(){
//            List<TopicVO> trendingTopics = Topic.getTrendingTopics()
//        render("TRENDING TOPICS-" +
//            trendingTopics.each {println("$it.name + $it.visibility + $it.createdBy")})
//}

    def showPost() {
        Long resourceId = new Long(params.id)
        println("in show post controller "+resourceId)
        ResourceVO resource = resourceService.showResourcePage(resourceId)

        if (resource) {
            println(resource.ownerName)

            render(view: '/Resource/_resourceShow', model: [resource: resource])

        } else
            render("RESOURCE NOT FOUND")
    }

}
