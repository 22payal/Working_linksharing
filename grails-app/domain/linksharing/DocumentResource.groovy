package linksharing

class DocumentResource extends Resource {
    String filepath
    String filename


    static constraints = {
        filepath(nullable: false,blank: false)
    }

    static transients = ['filename']
}
