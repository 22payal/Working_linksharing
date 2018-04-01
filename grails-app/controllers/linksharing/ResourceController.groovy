package linksharing

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

}
