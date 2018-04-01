package linksharing

import co.ResourceSearchCo
import enumeration.Visibility

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


}
