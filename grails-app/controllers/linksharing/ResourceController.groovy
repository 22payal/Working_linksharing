package linksharing

import co.ResourceSearchCo
import enumeration.Visibility
import vo.RatingInfoVO
import vo.TopicVO

class ResourceController {

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

    def show(Integer ResourceId)
    {
        Resource resource = Resource.findById(resourceId)
               RatingInfoVO ratingInfoVo = resource.getResourceRatingInformation()
                render("TOTAL VOTES- $ratingInfoVo.totalVotes + TOTAL SCORE- $ratingInfoVo.totalScore + AVERAGE SCORE- $ratingInfoVo.averageScore")

        List<TopicVO> trendingTopics = Topic.getTrendingTopics()
        render("TRENDING TOPICS-"+trendingTopics.each {println("$it.name + $it.visibility + $it.createdBy")})

    }

    def handleNullPointerException(NullPointerException e) {

        render ("null found")
    }

def findTrendingTopics(){
            List<TopicVO> trendingTopics = Topic.getTrendingTopics()
        render("TRENDING TOPICS-" +
            trendingTopics.each {println("$it.name + $it.visibility + $it.createdBy")})
}

}
