package linksharing

class LinkResourceController {

    def index() { }

    def save(){
                LinkResource linkResource = new LinkResource(createdBy: session.user, description: params.description, topic: params.topic)
                if (linkResource.save())
                        flash.message="LINK RESOURCE SAVED"
               else
                    flash.message="ERROR"

                       // forward(controller:'User', action: 'index')
            }
}
