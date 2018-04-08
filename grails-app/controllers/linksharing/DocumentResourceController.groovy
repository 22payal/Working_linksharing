package linksharing

class DocumentResourceController {

    def index() { }

    def download(Integer id)
    {
         DocumentResource  documentResource =  DocumentResource.load(id)
    }
}
