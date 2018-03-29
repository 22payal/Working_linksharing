package linksharing

class LinkResource extends Resource{
    String url

    static constraints = {
        url(unique: true,nullable:false,blank: false)
    }


    @Override
    public String toString() {
        return "LinkResource{" +
                "url='" + url + '\'' +
                '}';
    }
}

