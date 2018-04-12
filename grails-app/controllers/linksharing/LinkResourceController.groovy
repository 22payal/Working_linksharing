package linksharing

class LinkResourceController {

    def index() { }

    def save(){

             Topic topic = Topic.findByTopicNameAndCreatedBy(params.topicName,session.user)
        println(params.topicName)
        println(params.url)
        println(params.description)

                LinkResource linkResource = new LinkResource(url: params.url, createdBy: session.user, description: params.description, topic: topic)
                if (linkResource.validate()) {
                    linkResource.save()
                    flash.message = "LINK RESOURCE SAVED"
                    render("link resource saved successfully")
                }
               else
                    flash.message="ERROR"
        render("link resource could not be saved successfully")

            }

    def viewUrl()
    {
        render("in view url ")
    }
}
