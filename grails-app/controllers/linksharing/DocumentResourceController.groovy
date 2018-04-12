package linksharing

class DocumentResourceController {

    def index() {}

    def update() {
        def file = request.getFile('document')
        String fileName = file.originalFilename
        String uniqueFileName = UUID.randomUUID().toString() + "." + fileName.tokenize(".")?.last()?:""
        String filePath = grailsApplication.config.uploadFilePath
        file.transferTo(new File(filePath, uniqueFileName))
        Topic topic = Topic.findByTopicName(params.topicName)


        Resource resource = new DocumentResource(topic: topic, createdBy: session.user, description: params.description, filename: fileName, filepath: filePath + uniqueFileName)

        if (resource.validate()) {
            resource.save()
            flash.message = "saved successfully"
            redirect(controller: "user", action: "index")
        } else {
            resource.errors.allErrors.each {
                println(it)
            }
            flash.error = "error during saving resource"
            redirect(controller: "user", action: "index")
        }

    }


    def download() {
        DocumentResource documentResource = DocumentResource.get(params.id)

        def filePath = new File(documentResource.filepath)
        //def fileName = filePath.

        if (filePath.exists()) {
            response.setContentType("application/octet-stream")
            response.setHeader("Content-disposition", "filename=${filePath.name}")
            response.outputStream << filePath.bytes
        } else {
            render("could not find file")
        }
    }


}
