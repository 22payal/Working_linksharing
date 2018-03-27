package linksharing

class LinkResource extends Resource{
    String url

    static constraints = {
        url(unique: true,nullable:false,blank: false)
    }
}

