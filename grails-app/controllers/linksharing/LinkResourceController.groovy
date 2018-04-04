package linksharing

class LinkResourceController {

    def index() { }

    def save(){

             Topic topic = Topic.findByTopicNameAndCreatedBy(params.topicName,session.user)
                LinkResource linkResource = new LinkResource(url: params.url, createdBy: session.user, description: params.description, topic: topic)
                if (linkResource.save())
                        flash.message="LINK RESOURCE SAVED"
               else
                    flash.message="ERROR"

                       // forward(controller:'User', action: 'index')
            }
}
