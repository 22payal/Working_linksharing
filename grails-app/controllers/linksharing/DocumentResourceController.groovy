package linksharing

class DocumentResourceController {

    def index() {}

    def download(Integer id) {
        DocumentResource documentResource = DocumentResource.load(id)
    }

    def update() {
        def f = params.document
        def fullpath = f.getProperties()
        def sizeOfFile = f.getProperties().size()
        def originalPath = f.getProperties().get('originalFilename')
        int count = 0
        if (f) {
            println(params.topicName)

            Topic topic = Topic.findByTopicName(params.topicName)

            println(topic)


            Resource resource = new DocumentResource(topic: topic, createdBy: session.user, description: "hello this is a new doc", filename: "new document" , filepath: originalPath)

            if (resource.validate()) {
                resource.save()
                flash.message="saved successfully"
                render("resource saved successfully")
            }

            else
            {
                resource.errors.allErrors.each {
                    println(it)
                }
                flash.error="error during saving resource"
            }


            count++
        }
        println(count)
        println("full path is  : " + fullpath)
        println("size of file is :" + sizeOfFile)
        println("original path of the file " + originalPath)
    }

//    def download () {
//        def file = new File (params.filepath)
//
//        if (file.exists()) {
//            response.setContentType("application/octet-stream")
//            response.setHeader("Content-disposition", "filename=${file.name}")
//            response.outputStream << file.bytes
//            return
//        }
//    }


}
