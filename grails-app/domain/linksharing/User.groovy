package linksharing

class User {

    String firstName
    String lastName
    String userName
    String password
    String email
    Boolean admin
    Boolean active
    Date dateCreated
    Date lastUpdated
    Byte photo

   // List<Topic> topics

    String name

    String  getName() {
        name= firstName+" "+lastName
    }

    static transients = ['name']

    static constraints = {
        email(email: true,unique: true ,blank: false , nullable: false)
        password(size: 5..15, blank: false ,nullable: false)
        firstName(blank: false ,nullable: false)
        lastName(blank: false , nullable: false)
        userName(unique: true, blank:false , nullable: false)
        photo(nullable: true,sqlType:'longBlob')
        admin(nullable:true)
        active(nullable: true)

    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
