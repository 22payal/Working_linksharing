//package linksharing
//
//import co.ResourceSearchCo
//import enumeration.Visibility
//
//class TopicController {
//
//    def index() { }
//
//    def topicShow()
//    {
//        Topic topic=Topic.read()
//    }
//
//    def topicShow(ResourceSearchCo resourceSearchCo)
//    {
//        Topic topic = Resource.search(resourceSearchCo)
//        render("CreatedBy- $topic.createdBy.firstName having Topicname- $topic.topicName")
//
//
//    }
//
//    def topicDelete(Integer id)
//    {
//        Topic topic=Topic.load(id)
//    }
//
//    def topicSave() { }
//
//    def save(Topic topic, String visibility)
//    {
//        topic = new Topic(topicName:"new topic" , createdBy: session.user, visibility:Visibility.convertIntoEnum(visibility) )
//        topic.save()
//        if (topic.validate())
//        {
//            flash.message ="Topic is now saved"
//            render("topic saved successfully")
//        }
//        else
//        {
//            flash.error ="Topic is not saved"
//            render("error during saving topic")
//        }
//
//    }
//}
