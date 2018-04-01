package linksharing


import enumeration.Visibility

class TopicController {

    def index() { }

    def topicShow()
    {
        Topic topic=Topic.read()
    }

    def topicDelete(Integer id)
    {
        Topic topic=Topic.load(id)
    }

    def topicSave() { }

    def save(Topic topic, String visibility)
    {
        topic = new Topic(topicName:"new topic" , createdBy: session.user, visibility:Visibility.convertIntoEnum(visibility) )

        if (topic.save())
        {
            flash.message ="Topic is now saved"
            render("topic saved successfully")
        }
        else
        {
            flash.error ="Topic is not saved"
            render("error during saving topic")
        }

    }
}
